/**
  * Created by lucieburgess on 13/05/2017.
  * See doc.akka.io/docs/akka/2.02/intro/getting-started-first-scala.html
  * NB. This uses an old version of the API so I've updated the import statements and some of the logic may need
  * updating to, to akka v2.5.1.
  * The design we are aiming for is to have one Master actor initiating the computation. It creates a set of Worker actors.
  * The work is split up into discrete chunks and these chunks are sent to different Worker actors using round-robin scheduling.
  * The Master actor waits until the Worker actors have completed their work and they send back results for aggregation.
  * When the computation is completed the Master sends the results to a Listener actor which prints out the result
  *
  * An Actor class extends Akka's Actor trait and its messages are customarily defined as case classes in a companion object
  * Algorithm is : pi/4 = Sum To Infinity of (-1)^n/(2n+1) = 1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13 ....
  */

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}
import scala.concurrent.duration._
import scala.concurrent.duration.Duration

/** We create a common base trait for our messages, which is sealed to prevent creating messages out of our control */
sealed trait PiMessage

/** A message sent to the Master actor to start the calculation
  * This can be a case object rather than a case class as there are no constructor arguments
  */
case object Calculate extends PiMessage

/** A message sent from the Master actor to the Worker actors containing the work assignment */
case class Work(start: Int, nuElements: Int) extends PiMessage

/** a message sent from the Worker actors to the Master actor containing the result of the worker's calculation */
case class Result(value: Double) extends PiMessage

/** Message sent from the Master actor to the Listener actor containing the final pi result and how long the calculation took */
case class PiApproximation (pi: Double, duration: Duration)

/**
  * Create a Worker actor. This extends the Actor trait and defines a Receive method.
  * The general syntax to send a message to an actor is: actorInstance ! message
  * We have created an Actor with a receive method as a handler for the Work message
  * In this handler we invoke the calculatePiFor method, wrap the result in a Result message and send it back asynchronously
  * to the original sender using the sender reference which comes with the Actor trait
  */
class Worker extends Actor {

  def receive = {
    case Work(start, nuElements) =>
      sender ! Result(calculatePiFor(start, nuElements)) // actorInstance ! message
  }
/**
  * Helper method calculatePiFor containing the actual pi calculation
  *  Now we create a method for calculating pi. Note the (1-(1 % 2) * 2) just gives -1, 1, -1, 1 ....
  */
  def calculatePiFor(start: Int, nuElements: Int) :Double = {
    var acc = 0.0
    for (i <- start until (start + nuElements)) {
      acc += 4.0 * (1 - (i % 2) * 2) / (2 * i + 1)
    }
    acc
  }
}

/**
  * Now we create the Master actor. In its constructor we create a round-robin router to allow the work to spread
  * evenly between the workers. This is val workerRouter. This then is a router than represents all workers in a single
  * abstraction.
  * Note we pass in an ActorRef, listener, to the Master actor. This is used to report the result to the world
  * The message handler for the Master actor needs to react to two different messages: Calculate, which starts the calculation;
  * and Result, which aggregates all the different results. The Calculate handler sends work to the Workers via its router.
  * @param nrWorkers - defines how many workers we should start up
  * @param nrMessages - defines how many number chunks to send to the workers
  * @param nrElements - defines how big the number chunks sent to the workers should be
  * @param listener
  */
class Master(nrWorkers: Int, nrMessages: Int, nrElements: Int, listener: ActorRef) extends Actor {

  var pi: Double = _
  var nrResults: Int = _
  val start: Long = System.currentTimeMillis

  val workerRouter = {
    val routees = Vector.fill(nrWorkers) {
      val r = context.actorOf(Props[Worker])
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(),routees)
  }

  def receive = {
    case Calculate =>
      for (i <- 0 until nrMessages) workerRouter.route(Work(i*nrElements, nrElements), sender())
    case Result(value) =>
      pi += value
      nrResults += 1
      if (nrResults == nrMessages) { //send the result to the Listener
        listener ! PiApproximation(pi, duration = (System.currentTimeMillis() - start).millis)
      }
      context.stop(self) //stops this actor and all supervised children
  }
}

/**
  * Creating the result Listener. When it receives PiApproximation from Master it prints the results
  * and shuts down the Actor system
  */
class Listener extends Actor {


  def receive = {
    case PiApproximation(pi, duration) =>
      println("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s".format(pi, duration))
      //context.system.terminate()
  }
}

/**
  * Now all we need is a main method:
  */
object PiMain extends App {

  // Define a calculate method and run it
  calculate(4, 10000, 10000)

  def calculate(nrWorkers: Int, nrElements: Int, nrMessages: Int) = {

    // Create an Akka Actor System
    val system = ActorSystem("PiSystem")

    // Create the Listener actor that listens for the result i.e. create and start the actor
    val listener = system.actorOf(Props[Listener], name = "listener")

    // Create the Master actor
    val master = system.actorOf(Props(new Master(nrWorkers, nrMessages, nrElements, listener)), name = "master")

    master ! Calculate
  }
}
package studentsimulator

/**
  * Created by lucieburgess on 25/05/2017.
  * Akka tutorial from: http://rerun.me/2014/09/11/introducing-actors-akka-notes-part-1/
  * Student creates something called an Actor System
  * It uses the ActorSystem to create something called as ActorRef (proxy for Teacher Actor).
  * QuoteRequest message sent to ActorRef
  * ActorRef passes message to dispatcher
  * Dispatcher enqueues the messgae in the target Actor's Mailbox
  * Dispatcher puts the Mailbox on a Thread
  * Mailbox dequeues a message and delegates that to the actual Teacher Actor's receive method
  */

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import studentsimulator.TeacherProtocol.QuoteRequest


object StudentStimulator extends App {

  //Initialize the system
  val actorSystem = ActorSystem("University_message_system")

  //construct the Teacher Actor Ref
  val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])

  //send a message to the Teacher Actor
  teacherActorRef!QuoteRequest

  //Let's wait for a couple of second before we shut down the system
  Thread.sleep(2000)

  //Shut down the Actor
  actorSystem.terminate()
}

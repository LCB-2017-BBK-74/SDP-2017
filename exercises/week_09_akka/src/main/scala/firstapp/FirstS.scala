package firstapp

/**
  * Created by lucieburgess on 25/05/2017.
  */

import akka.actor.{Actor, ActorSystem, Props}

class FirstActor extends Actor {

  def receive = {
    case "hello" => println("Hello world!")
    case msg: String => println("Got " + msg)
    case _ => println("Unknown message")
  }
}

object FirstApp {
  def main(args: Array[String]) :Unit = {

    val system = ActorSystem("First_example")

    val first = system.actorOf(Props[FirstActor], name = "first")

    println("The path associated with first is" + first.path)

    first!"hello"
    first!"Goodbye"
    first!4
    first!6
    first!"hello"
    first!"Summer"

    system.terminate
  }
}

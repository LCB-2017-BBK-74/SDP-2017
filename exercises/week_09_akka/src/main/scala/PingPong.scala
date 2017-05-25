/**
  * Created by lucieburgess on 25/05/2017.
  */

import akka.actor.{Actor, ActorSystem, Props}

class PingPong extends Actor {

  def receive = {
    case "PING" => println("PING  |")
      Thread.sleep(500)
      sender ! "PONG"
    case "PONG" => println("  | PONG")
      Thread.sleep(500)
      sender ! "PING"
    case "start" => val second = context.actorOf(Props[PingPong], name = "second")
      println(second.path)
      second ! "PING"
  }
}

object Server {
  def main(args: Array[String]) :Unit = {
    val system = ActorSystem("PingPong")
    val first = system.actorOf(Props[PingPong], name = "first")
    println(first.path)
    first ! "start"
    println("Server ready")

    Thread.sleep(20000)
    system.terminate
  }
}

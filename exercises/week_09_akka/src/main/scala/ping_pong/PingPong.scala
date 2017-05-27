package ping_pong

import akka.actor.{Actor, Props}

/**
  * Created by lucieburgess on 26/05/2017.
  */
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

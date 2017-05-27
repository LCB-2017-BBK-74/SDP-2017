package ping_pong

import akka.actor.{ActorSystem, Props}

/**
  * Created by lucieburgess on 26/05/2017.
  */
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

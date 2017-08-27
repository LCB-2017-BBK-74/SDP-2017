package akka_example

/**
  * Created by lucieburgess on 05/06/2017.
  *
  */

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import scala.annotation.tailrec


object AkkaFactorial extends App {

  val factorials = List(20,18,28,22,42,55,48)

  // an actor needs an ActorSystem
  val system = ActorSystem("factorial")

  val collector = system.actorOf(Props(new FactorialCollector(factorials)), "collector") //NB. system
}

class FactorialCollector(factorials: List[Int]) extends Actor with ActorLogging{

  var ls = List[BigInt]()
  var size = factorials.size

  val calculator = context.actorOf(Props(new FactorialCalculator)) //NB. context

  for (num <- factorials) {
    calculator ! num
  }

  def receive = {
    case (num: Int, fac: BigInt) => {

      log.info(s"Factorial for $num is $fac")

      ls = num :: ls
      size -= 1

      if (size == 0) {
        context.system.terminate()
      }
    }
  }

}

class FactorialCalculator extends Actor {

  def receive = {
    case num: Int => sender ! (num, factor(num), println(s"Factorial for $num is ${factor(num)}"))
  }

  private def factor(num :Int) :BigInt = {
    @tailrec
    def factorTail(num :Int, accum: BigInt) :BigInt = (num, accum) match {
      case (0, accum) => accum
      case (n, accum) => factorTail(n - 1, n * accum)
      }
    factorTail(num, 1)
  }
}

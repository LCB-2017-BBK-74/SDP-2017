package tail_recursion

/**
  * Created by lucieburgess on 05/06/2017.
  */

import scala.annotation.tailrec

object TailRecursiveExamples {

  /** Summing a list - general recursion */
  def sum(ls: List[Int]) :Int = ls match {
    case Nil => 0
    case h::t => h + sum(t)
  }

  /** Summing a list - tail recurion */
  def sumTailRec(ls: List[Int]) :Int = {
    @tailrec
    def sumWithAccumulator(ls: List[Int], accum: Int) :Int = ls match {
      case Nil => accum
      case h :: t => sumWithAccumulator(t, h + accum)
    }
    sumWithAccumulator(ls, 0)
  }

  /** Fibonnaci sequence - general recursion */
  def fib(n: Int) :Int = n match {
    case (0|1) => 1
    case _ => fib(n-1) + fib(n-2)
  }

  /** Fibonnaci sequence - tail recursion */
  def fibTailRec(n: Int) :BigInt = {
    @tailrec
    def fibWithAccumulator (n:Int, prev: BigInt = 0, next: BigInt = 1) :BigInt = n match {
      case 0 => prev
      case 1 => next
      case _ => fibWithAccumulator(n-1, prev, (prev+next))
    }
    fibWithAccumulator(n)
  }

  /** Factorial - general recursion */
  def factorial(n: Int) :Int = n match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }

  /** Factorial - tail recursion */
  def factorialTailRec (n:Int) :BigInt = {
    @tailrec
    def factWithAccumulator (n:Int, accum: BigInt) :BigInt = (n, accum) match {
      case(0, accum) => accum
      case (n, accum) => factWithAccumulator(n-1, n*accum)
    }
    factWithAccumulator(n,1)
  }

  /** Product - general recursion */
  def product(ls: List[Int]) :Int = ls match {
    case Nil => 0
    case h::t => h * product(t)
  }

  def productTail(ls: List[Int]) :Int = {
    @tailrec
    def productWithAccumulator(ls: List[Int], accum :Int) :Int = ls match {
      case Nil => accum
      case h::t => productWithAccumulator(t, h * accum)
    }
    productWithAccumulator(ls,1)
  }

}

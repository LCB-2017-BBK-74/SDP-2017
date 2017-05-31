package q39_fibonacci

import scala.collection.mutable

/**
  * Created by lucieburgess on 31/05/2017.
  * 1,1,2,3,5,8,13
  */
object Fibonacci extends App {

  def fibR(n: Int) :Int = n match {
    case 0 | 1 => n
    case _  => fibR(n-1) + fibR(n-2)
  }

  def fib3(n :Int) :Int = {
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail( n-1, b, a+b )
    }
    return fib_tail( n, 0, 1)
  }

  /**
    * A memoization function that checks whether the function has already been computed. If it has been computed, it
    * checks the map to see whether a value of the function exists for that key. If not, it computes it.
    * @param f a function that maps an Int to an Int, like fib
    * @param n an Integer
    * @return the memoized version of the version.
    */
  def memo(f: (Int=>Int), n: Int) :Option[Int] = {

    val functionMap = scala.collection.mutable.Map[Int, Int]()

    def getFunctionValue(map: mutable.Map[Int, Int], k: Int) :Option[Int] = k match {
      case k if k < 0 => None
      case k if map.contains(k) => functionMap get (k)
      case k if !map.contains(k) => {
        functionMap put(k, f(k))
        functionMap get(k)
      }
      case _ => throw new IllegalArgumentException
    }
    getFunctionValue(functionMap, n)
  }

//  def memfib(f: (Int=>Option[Int]), n: Int) :Int = n match {
//
//    case n if memo(fibR, n).getFunctionValue()
//    // not sure how to do this using memo ... where we need to look is the point at which functionMap put(k, f(k))
//      // calls f(k) ... in that case we call can use an iterative or
//  }



  val fibmap = scala.collection.mutable.Map[Int, Int]()
  fibmap += (0 -> 1, 1 -> 1, 2 -> 2, 3 -> 3, 4 -> 5, 5 -> 8, 6 -> 13, 7 -> 21)

  println(fib3(5))

  val mf = memo(fib3,8)
  println(mf)

}

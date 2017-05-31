package q36_golden_ratio

/**
  * Created by lucieburgess on 31/05/2017.
  * The golden ratio a/b satisfies the equality (a + b)/a = a/b
  */

import scala.math.abs

object Golden extends App {

  def estimateB(a: Double, bmin: Double, bmax: Double, err: Double) :Double = {

    var estB = (bmin+bmax)/2 //1.5
    val golden1 = (a+estB)/a //1.5
    val golden2 = a/estB // 2
    val result = math.abs(golden1-golden2) //0.5

    if (result < err) result
    else if (golden2 >= golden1) estimateB(a, estB, bmax, err)
    else estimateB(a, bmin, estB, err)
  }

  val a = 3.0
  val b = estimateB(a, 0, a, 0.000000001)
  println(b)
  println("Estimate is " + (a/b))

}

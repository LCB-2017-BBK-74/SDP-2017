package q8_strategy

/**
  * Created by lucieburgess on 31/05/2017.
  * The strategy design pattern is represented in the following code. Strategy defines a set of encapsulated algorithms that
  * can be swapped out to carry out a set of specific behaviour.
  * The algorithms (in this case the specific methods fromCartesian, fromPolar), access or utilise data that the calling code
  * shouldn't be exposed to.
  * The behaviour of the class is defined at runtime.
  * In this case we have two different ways of implementing imaginary numbers from co-ordinate systems:
  * Cartesian and polar.
  *
  */

import scala.math.cos
import scala.math.sin

case class Complex private (real: Double, imaginary: Double)

object Complex {

  def fromCartesian(x: Double, y: Double): Complex = Complex(x, y)

  def fromPolar(radius: Double, theta: Double) :Complex = Complex(radius * cos(theta), radius * sin(theta))

}

object Test extends App {

  var c: Complex = Complex.fromPolar(1,45)
  println(c.toString)
  c = Complex.fromCartesian(5,6)
  println(c.toString)
}



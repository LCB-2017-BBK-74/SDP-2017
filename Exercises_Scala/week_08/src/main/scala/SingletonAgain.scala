/**
  * Created by lucieburgess on 02/03/2017.
  * Singleton has a private constructor. It's just an instance of an object
  * This example demonstrates lazy evaluation
  *
  */

object SingletonAgain {

  var args = 0
  lazy val x = args // delays the evaluation so that x takes the value args at the point that we evaluate x

  def apply(arg: Int) = { // apply is behaving like a function setOnce or Initialise
    args = arg
    println(s"The value of x is $x")
  }
}

class SingletonAgain private()

// case class SingletonCC private() - could write this instead of the class and the companion object with the apply method

object Main extends App {
  //val zz = Person() // must be a case class hence the brackets. Case class must have arguments
  val xx = SingletonAgain
  //println(xx.args)
  xx.apply(3)
  println(xx.x)

  val yy = Singleton
  yy.apply(3121)

}


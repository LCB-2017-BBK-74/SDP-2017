/**
  * Created by lucieburgess on 02/03/2017.
  * We want a single instance of the class. It may be mutable or immutable
  */

object Singleton {
  var instance: Singleton = null
  def apply(arg: Int) :Singleton = {
//    if (instance == null)
//      instance = new Singleton(arg)
    instance.x = arg
    instance
  }
}

object Singleton {
  private var args = 0
  private lazy val x = args // evaluated at runtime when needed
}


class Singleton private() {
  private var x: Int = 0
}

class Singleton private() // lazy version


object Main extends App {
  val x = Singleton.apply(3)
  val y = Singleton.apply(4)
  // val x = new Singleton(3)
  // val y = new Singleton(4)
  println(x)
  println(y)
}

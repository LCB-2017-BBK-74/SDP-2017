package singleton

/**
  * Created by lucieburgess on 05/03/2017.
  */
class SingletonAgain private(var state : Int) {
  def DoSomething() = {
    state += 1
    System.out.println("I did something for the " + this.state + " time")
  }
}

object SingletonAgain {
  private var _instance :SingletonAgain = null
  def instance() = {
    if (_instance == null)
      _instance = new SingletonAgain(0)
    _instance
  }
}

object MainAgain extends App {
  SingletonAgain.instance.DoSomething()
  SingletonAgain.instance.DoSomething()
  SingletonAgain.instance.DoSomething()
}
package singleton

/**
  * Created by lucieburgess on 05/03/2017.
  * This design pattern restricts the creation of a class to a single object
  * If more than one class in the application tries to use the object, the same instance is returned for everyone
  * This is another design pattern that can be easily achieved with the use of basic Scala features
  *
  * To create a Singleton, what do we do?
  * We make the constructor of the class private
  * We provide a method that will return the single instance of the class
  * We either:
  * a) create the object on loading (eager) or b) create the object on demand (lazy)
  *
  *
  */
class Singleton private(var state :Int) {
  //private declaration of constructor
  def doSomething() = {
    state += 1
    System.out.println("I did something for the " + this.state + " time")
  }
}

// If you use this.state without the string utility, gives result:
// I did something for the 1 time
// I did something for the 2 time
// I did something for the 3 time
// Use the string utility, shows that the same object reference is being called every time, but it's a mutable
// object with a field 'state' which is incrementing by 1 every time doSomething() is called

object Singleton {
  private val _instance = new Singleton(0)
  def instance() = _instance
}

//object Singleton {
//  def instance() = new Singleton(0)
//}

object Main extends App {
  Singleton.instance().doSomething()
  Singleton.instance().doSomething()
  Singleton.instance().doSomething()
}

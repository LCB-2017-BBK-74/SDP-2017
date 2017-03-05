package factory

import java.lang.reflect.Constructor
import java.lang.reflect._


/**
  * Created by lucieburgess on 23/02/2017.
  */
class DuckCreator(duckType: String) extends DuckProduct {

  // e.g. duckType could be FemaleMallard or RubberDuck

  def makeADuck: DuckProduct = {
    var duck: DuckProduct = null;
    try {
      val className = duckType.concat("ConcreteDuckProduct")
      // is it a concrete DP or a DP?
      var duckClass = Class.forName(className)
      val cons = duckClass.getConstructors()
      //returns Returns an array containing Constructor objects reflecting all the public constructors of the class represented by this Class object.
      // In this case we know cons(0) is the right element in the array as there is only one constructor for Mallard
      val args = cons(0).getParameterTypes
      duck = cons(0).newInstance(args: _*).asInstanceOf[DuckProduct] //Uses the constructor represented by this Constructor object to create and initialize a new instance of the constructor's declaring class, with the specified initialization parameters.
      // Now we have an instance of, say, a female mallard

      //var methods = Array(colour,sound,food,wings)
      val allMethods = duckClass.getMethods() // need to invoke methods
      try {
        for (m <- allMethods) {
          var mname: String = m.getName()
          var result: Object = m.invoke(duck, 0) //each method does not have parameters. Would have to getParameterTypes otherwise
        }
      } catch {
        case ex: InvocationTargetException => var cause: Throwable = ex.getCause()
      }

    } catch {
      case ex: ClassNotFoundException =>
        println(s"Unknown class name $duckType")
      case ex: InstantiationException =>
        ex.printStackTrace()
      case ex: IllegalArgumentException =>
        ex.printStackTrace()
    }
    return duck;
  }
}
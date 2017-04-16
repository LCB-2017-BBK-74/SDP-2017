package decorator

/**
  * This is a basic implementation of the Pizza trait
  * Then we use a base decorator, which is the abstract class PizzaDecorator
  * Then we have different implementations of the decorator itself, depending on whether they are simply veg or simply non-veg
  */

class SimplyNonVegPizza extends Pizza {

  def getDesc: String = "Simply Non Veg Pizza"

  def getPrice: Double = 350

}

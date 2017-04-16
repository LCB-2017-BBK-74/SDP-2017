package decorator

/**
  * Created by lucieburgess on 16/04/2017.
  * The decorator wraps the object whose functionality needs to be increased without affecting all subclasses, so it
  * needs to implement the basic Pizza interface
  */

abstract class PizzaDecorator (pizzaToDecorate: Pizza) extends Pizza {

  override def getDesc = pizzaToDecorate.getDesc

  override def getPrice = pizzaToDecorate.getPrice

}

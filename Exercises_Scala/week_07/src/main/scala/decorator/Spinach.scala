package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator (pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Spinach (7.92)"

  override def getPrice: Double = pizza.getPrice + 7.92
}

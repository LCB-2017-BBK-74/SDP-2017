package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator (pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Cheese (20.72)"

  override def getPrice: Double = pizza.getPrice + 20.72
}

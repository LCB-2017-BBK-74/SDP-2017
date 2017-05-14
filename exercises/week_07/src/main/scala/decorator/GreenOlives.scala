package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Green Olives (5.47)"

  override def getPrice: Double = pizza.getPrice + 5.47
}

package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator (pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Ham (18.12)"

  override def getPrice: Double = pizza.getPrice + 18.12
}

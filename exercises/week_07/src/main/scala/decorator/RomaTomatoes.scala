package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator (pizza: Pizza) {

  override def getDesc: String = pizza.getDesc + ", Roma Tomatoes (5.20)"

  override def getPrice: Double = pizza.getPrice + 5.20

}

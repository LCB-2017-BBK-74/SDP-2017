package decorator

import java.text.DecimalFormat

object TestDecoratorPattern {

  private var dformat: DecimalFormat = new DecimalFormat("#.##")

  def main(args: Array[String]) {
    var pizza: Pizza = new SimplyVegPizza
    pizza = new RomaTomatoes(pizza)
    pizza = new GreenOlives(pizza)
    pizza = new Spinach(pizza)
    print(pizza)
    pizza = new SimplyNonVegPizza
    pizza = new Meat(pizza)
    pizza = new Cheese(pizza)
    pizza = new Cheese(pizza)
    pizza = new Ham(pizza)
    print(pizza)
  }

  private def print(pizza: Pizza) {
    System.out.println("Desc: " + pizza.getDesc)
    System.out.println("Price: " + dformat.format(pizza.getPrice))
  }
}

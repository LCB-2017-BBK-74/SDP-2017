package q3_method_arguments

/**
  * Created by lucieburgess on 31/05/2017.
  */
class Item (val name: String, val price: Double) {

  def cost (grocery: Boolean = false, medication: Boolean = false, taxRate: Double = 0.10) = {
    if (grocery || medication) price
    else price * (1+taxRate)
  }
}

object Shopping extends App {

  val flour = new Item("flour",4)
  println(s"The cost of flour is ${flour.cost(grocery = true)}")

  val sunscreen = new Item(name = "sunscreen", 3)
  println(s"The cost of sunscreen is ${sunscreen.cost()}")

  val tv = new Item(name = "television", 500)
  println(s"The cost of a new TV is ${tv.cost(taxRate = 0.06)}")

}
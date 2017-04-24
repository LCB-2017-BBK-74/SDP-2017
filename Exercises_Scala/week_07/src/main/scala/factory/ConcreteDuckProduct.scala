package factory

/**
  * Created by lucieburgess on 14/04/2017.
  * Mallard is equivalent to a ConcreteDuckProduct
  *
  */
class Mallard extends DuckProduct {

  override def duck = {
    val noise = "Quack!"
    val wings = 2
    val colour = "Green"
    println(s"This ${this.getClass()} makes a $noise noise, has $wings wings and its colour is $colour ")
  }
}


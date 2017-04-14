package factory

/**
  * Created by lucieburgess on 14/04/2017.
  */
class RubberDuck extends DuckProduct{

  override def duck = {
    val noise = "Squeak"
    val wings = 0
    val colour = "Yellow"
    println(s"This ${this.getClass()} makes a $noise noise, has $wings wings and its colour is $colour ")
  }

}

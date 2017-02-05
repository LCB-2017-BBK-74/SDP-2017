/**
  * Created by lucieburgess on 02/02/2017.
  */
object Cats extends App {

  case class Cat(name: String, colour: String, favouriteFood: String) {

    def eat(food :String) :String = {
        if (food == favouriteFood) "OMNOM"
        else "Blehh"
    }

  }

  val oswald = Cat ("Oswald", "black", "milk")
  val henderson = Cat ("Henderson", "gingerandwhite", "chips")
  val quentin = Cat("Quentin", "tabby and white", "curry")

  println(oswald)
  println(oswald.colour)
  println(oswald.eat("fish"))
  println(oswald eat "coconut")
  println(oswald eat "milk")


}

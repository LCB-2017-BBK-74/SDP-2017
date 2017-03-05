package factory

/**
  * Created by lucieburgess on 23/02/2017.
  * ConcreteProduct implements the Product interface
  */
case class FemaleMallard() extends DuckProduct {
    def colour = println("Brown")
    def sound = println("Small Quack")
    def food = println("Pondweed")
    def wings = 2
}

case class MaleMallard() extends DuckProduct {
    def colour = println("Green")
    def sound = println("Big Quack")
    def food = println("Pondweed")
    def wings = 2
}

case class RubberDuck() extends DuckProduct {
    def colour = println("Yellow")
    def sound = println("Squeak")
    def food = println("Water") //later we can override this in another factory method as rubber ducks don't eat
    def wings = 0
}


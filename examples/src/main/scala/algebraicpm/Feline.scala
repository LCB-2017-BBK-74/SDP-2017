package algebraicpm

import food._

/**
  * Created by lucieburgess on 24/05/2017.
  */

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat(favouriteFood: String) extends Feline

/**
  * Pattern matching in the base trait
  */
sealed trait Feline {
  def dinner: Food = this match {
    case Lion() => Antelope
    case Tiger() => TigerFood
    case Panther() => Humans
    case Cat(favouriteFood) => CatFood(favouriteFood)
  }
}

/**
  * Pattern matching in an external object: implement the code in a method in an object Diner
  */
object Diner {
  def dinner(feline: Feline) :Food = feline match {
    case Lion() => Antelope
    case Tiger() => TigerFood
    case Panther() => Humans
    case Cat(favouriteFood) => CatFood(favouriteFood)
  }
}

// When we implement a method in the classes of interest we can only have one implementation of the method -
// Everything that requires that method to work must be contained within the class and parameters we pass to the method



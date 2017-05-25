package algebraicpoly

import food._

/**
  * Created by lucieburgess on 24/05/2017.
  */
sealed trait Feline {
  def dinner: Food
}

final case class Lion() extends Feline {
  def dinner: Food = Antelope
}

final case class Tiger() extends Feline {
  def dinner: Food = TigerFood
}

final case class Panther() extends Feline {
  def dinner: Food = Humans
}

final case class Cat(favouriteFood: String) extends Feline {
  def dinner: Food = CatFood(favouriteFood)
}


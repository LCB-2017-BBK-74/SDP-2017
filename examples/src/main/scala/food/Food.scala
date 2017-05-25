package food

/**
  * Created by lucieburgess on 24/05/2017.
  */
sealed trait Food

final case object Antelope extends Food
final case object TigerFood extends Food
final case object Humans extends Food
final case class CatFood(food: String) extends Food // can't be an object as takes a parameter, must be a class


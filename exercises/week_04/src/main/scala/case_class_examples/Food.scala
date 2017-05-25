package case_class_examples

/**
  * Created by lucieburgess on 09/02/2017.
  * Using a case class has a built in apply method
  */
sealed trait Food

  final case class Antelope() extends Food
  final case class TigerFood() extends Food
  final case class Liquorice() extends Food
  final case class Mice() extends Food


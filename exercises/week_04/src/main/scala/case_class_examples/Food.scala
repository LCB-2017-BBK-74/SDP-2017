package case_class_examples

/**
  * Created by lucieburgess on 09/02/2017.
  */
sealed trait Food

  final case class Antelope() extends Food //() means calling apply implicitly. If you use object, you get an apply method for free
  final case class TigerFood() extends Food
  final case class Liquorice() extends Food
  final case class Mice() extends Food


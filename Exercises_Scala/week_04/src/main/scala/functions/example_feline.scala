package functions

/**
  * Created by lucieburgess on 09/02/2017.
  */

// Model feline is a lion, tiger, panther, (as a trait/case pattern algebraic data type)
// Only one Red whereas more than one Lion - so need a class rather than an object
// Commented out version is the polymorphic version instead of the pattern match version

sealed trait Feline {
  //def dinner: Food
  def dinner = this match {
    case Lion() => Antelope()
    case Tiger() => TigerFood()
    case Panther() => Liquorice()
    case Cat() => Mice()
  }
}

final case class Lion() extends Feline {
  //def dinner = Antelope()
}
final case class Tiger() extends Feline {
  //def dinner = TigerFood()
}
final case class Panther() extends Feline {
  //def dinner = Liquorice()
}
final case class Cat() extends Feline {
  //def dinner = Mice()
}

// define a method dinner()
//polymorphism

// case class Person (name: String, age: Int) -
// gives you all the getters, setters, hashcode, toString(), equals() etc etc - can't do that in Java!!

package CasePerson

/**
  * Created by lucieburgess on 14/02/2017.
  * What happens when we define a companion object for a case class?
  * Take our CasePerson class and turn it into a case class. Make sure you still have the companion object with the
  * alternate apply method.
  * Case class generates an apply method with a companion object for you, or you can override it and write your own
  * This gives a method apply(firstname: String, lastname: String) = new Person (firstname, lastname) as default within the companion object
  * See Scala Cookbook 6.8
  */

// default constructor: accessor and mutator methods written for these if defined as var
case class Person(var firstname: String, var lastname: String) {

  // left out the name field here as it's the same syntax as the class Person example
}

// auxiliary constructors
  object Person {

    def apply() = new Person("<no name>","<no name>")

    def apply(name: String) : Person = {
      val splitname = name.split(" ")
      val p = new Person(splitname(0),splitname(1))
      p
    }
  }

object Test extends App {
  val js = Person()
  val lb = Person("Lucie Burgess")
  val fc = Person("Father","Christmas")

  println(js)
  println(lb)
  println(lb.firstname)
  println(lb.lastname)
  println(fc)

  //Test the mutator/ setter methods which are generated because we defined firstname, lastname as var
  js.firstname = "Leonard"
  js.lastname = "Nimoy"
  println(js)


}
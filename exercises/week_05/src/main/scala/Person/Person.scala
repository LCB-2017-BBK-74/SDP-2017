package Person

/**
  * Created by lucieburgess on 16/02/2017.
  * http://otfried.org/scala/apply.html
  *
  */
class Person (var firstName: String, var lastName: String) {

  var name: String = _
}

  object Person {

    def apply(name: String) :Person = {
      var p = new Person (firstName = "", lastName = "")
      val splitname = name.split(" ")
      p.name = name
      p.firstName = splitname(0)
      p.lastName = splitname(1)
      p
    }
  }

object Main extends App {
  val js = Person("John Smith")
  println(js.firstName)
  println(js.lastName)
  val lb = Person("Lucie Burgess")
  println(lb.firstName)
  println(lb.lastName)
  println(lb.name)
}


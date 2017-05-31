package q5_case_class

/**
  * Created by lucieburgess on 31/05/2017.
  */
case class Person(val firstName: String, val lastName: String, val contact: String) {

}

object PersonMain extends App {
  val p = Person("Jane", "Smith", "janesmith@gmail.com")
  println(p.firstName)
  println(p.lastName)
  println(p.contact)
}


package Person

/**
  * Created by lucieburgess on 14/02/2017.
  * What happens when we define a companion object for a case class?
  * Take our Person class and turn it into a case class. Make sure you still have the companion object with the
  * alternate apply method.
  */
case class Person(firstname: String, surname: String) {

  object Person {

    def apply = ???


  }

}

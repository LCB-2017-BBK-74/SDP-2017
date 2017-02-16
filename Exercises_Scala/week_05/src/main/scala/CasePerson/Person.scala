package CasePerson

/**
  * Created by lucieburgess on 14/02/2017.
  * What happens when we define a companion object for a case class?
  * Take our CasePerson class and turn it into a case class. Make sure you still have the companion object with the
  * alternate apply method.
  */
case class Person(val firstname: String, val lastname: String) {

  var name: String = _

}

  object Person {

    def apply = ???


  }

}

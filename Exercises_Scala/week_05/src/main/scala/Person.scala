/**
  * Created by lucieburgess on 14/02/2017.
  * Implement a companion object for a Person class containing an apply method that accepts a whole name as a single string
  * rather than individual first and last names.
  * Tip: you can split a String into an Array of components as follows: scala> val parts = "John Doe".split(" ")
  * parts: Array[String] = Array(John, Doe)
  * scala> parts(0)
  * res36: String = John
  */
class Person {

  object Person {

    def apply(name: String) = {
      // not sure what this method is supposed to do?
    }
    // the companion object contains static methods, effectively, that apply to the whole class
  }

}

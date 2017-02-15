
/**
  * Created by lucieburgess on 14/02/2017.
  * Film constructor should contain: a field name of type String, a field yearOfRelease of type Int, a field imdbRating of type Double
  * a field director of type Director
  * a method directorsAge that returns the age of the director at the time of release
  * a method isDirectedBy that accepts a Director as a parameter and returns a Boolean
  * NB. Constructor parameters (fields) need var or val to generate accessors and mutators
  */

class Film(var name: String, var yearOfRelease: Int, var imdbRating: Double, var director: Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) :Boolean = director.equals(this.director)

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating, director: Director = this.director) :Film = {
    new Film(name,yearOfRelease,imdbRating,director)
  }

}

//Use this for testing until we've implemented tests using ScalaTest

object FilmMain extends App {

  var testDirector1 = new Director("Some","French Guy", 1946)
  var testDirector2 = new Director("Some","American Guy",1983)
  var testFilm1 = new Film("High Plains Drifter",1973,7.7,testDirector1)
  var inception = new Film("Inception",1996,8.2,testDirector2)

  println("director's firstname is " + testDirector1.firstName)
  println("director's lastname is " + testDirector2.lastName)
  println("director's year of birth is " + testDirector1.yearOfBirth)
  println("Age of director when released was " + testFilm1.directorsAge)

  println(testFilm1.name)
  println(testFilm1.copy(name = "L'homme des hautes plaines").name)
  println(inception.copy().copy().copy().name)
}
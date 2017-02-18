package Film

/**
  * Created by lucieburgess on 14/02/2017.
  * NB. Constructor parameters (fields) need var or val to generate accessors and mutators
  * Converting class to a case class automatically generates the methods copy() and apply() so these are not required
  */

class Film(var name: String, var yearOfRelease: Int, var imdbRating: Double, var director: Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) :Boolean = director.equals(this.director)

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating,
             director: Director = this.director) :Film = {
    new Film(name,yearOfRelease,imdbRating,director)
  }

}

/**
  * apply() method is not required if a case class
  */
object Film {

  def apply (name: String, yearOfRelease: Int, imdbRating: Double, director: Director) = new Film (name,yearOfRelease,imdbRating,director)

  def highestRating (f1: Film, f2: Film) :Double = if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirector (f1: Film, f2: Film) :Director = if (f1.directorsAge > f2.directorsAge) f1.director else f2.director
}



package Film

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

/**
  * Created by lucieburgess on 18/02/2017.
  * Question - using 'before' as shown in the ScalaCookbook/Alvin Alexander example prevents eastwood etc being seen
  * in the scope of the tests. Why is this?
  * Using sbt test as I can't get this to run from Intellij. Navigate to the project top level folder (week05) and type sbt test in Terminal
  * All 21 tests pass
  */
class FilmTest extends FunSuite with BeforeAndAfter {

  var dir: Director = _

  //before {
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)
    val someGuy = new Director("Just", "Some Guy", 1990)
    var spielberg = Director("Stephen", "Spielberg", 1946)
    var tarantino = Director("Quentin", "Tarantino", 1963)
    var scorsese = Director("Martin", "Scorsese", 1942)

    val memento = new Film("Memento", 2000, 8.5, nolan)
    val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
    val inception = new Film("Inception", 2010, 8.8, nolan)

    val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
    val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
    val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)

    val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)
    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
  //}

  test("[01] New director can be created using new") {
    assert(eastwood.isInstanceOf[Director])
  }

  test("[02] New director can be created without using new") {
    assert(spielberg.isInstanceOf[Director])
  }

  test("[03] Director's first name can be accessed") {
    assert(eastwood.firstName.equals("Clint"))
  }

  test("[04] Director's last name can be accessed") {
    assert(spielberg.lastName.equals("Spielberg"))
  }

  test("[05] Director's full name can be accessed") {
    assert(spielberg.name.equals("Stephen Spielberg"))
  }

  test("[06] call to older returns oldest Director") {
    assert(Director.older(eastwood,mcTiernan).equals(eastwood))
  }

  test("[07] call to older returns oldest Director again") {
    assert(Director.older(scorsese,someGuy).equals(scorsese))
  }

  test("[08] New film can be created using new") {
    assert(memento.isInstanceOf[Film])
  }

  test("[09] New film can be created without using new") {
    assert(highPlainsDrifter.isInstanceOf[Film])
  }

  test("[10] Film's name can be accessed from name field") {
    assert(memento.name.equals("Memento"))
  }

  test("[11] Film's year of release can be accessed from field") {
    assert(darkKnight.yearOfRelease.equals(2008))
  }

  test("[12] Film's imdb rating can be accessed from field") {
    assert(unforgiven.imdbRating.equals(8.3))
  }

  test("[13] Film's director can be accessed from field") {
    assert(inception.director.equals(nolan))
  }

  test("[14] Film isDirectedBy returns Director") {
    assert(inception.isDirectedBy(nolan))
  }

  test("[15] Director's age returns correct age") {
    assert(highPlainsDrifter.directorsAge == 43)
  }

  test("[16] Copy returns a new copy of the film") {
    assert(inception.copy().ne(inception))
  }

  test("[17] Copy returns a new copy of the film with correct name") {
    assert(inception.copy().name.equals("Inception"))
  }

  test("[18] Copy returns a new of the film with changed name") {
    assert(unforgiven.copy(name = "Not forgiven").name.equals("Not forgiven"))
  }

  test("[19] Copy returns a new copy of the film with the director changed") {
    assert(granTorino.copy(director = someGuy).director.firstName.equals("Just"))
  }

  test("[20] Oldest director returns correct older director") {
    assert(Film.oldestDirector(memento,granTorino).equals(eastwood))
  }

  test("[21] Highest rating returns correct rating") {
    assert(Film.highestRating(darkKnight,invictus).equals(9.0))
  }

}


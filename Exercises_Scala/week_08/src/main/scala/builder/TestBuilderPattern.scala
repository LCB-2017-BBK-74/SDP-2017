package builder

import builder.CarDirector

/**
  * Created by lucieburgess on 23/04/2017.
  */
object TestBuilderPattern {

  def main(args: Array[String]) = {

    var carBuilder: CarBuilder = SedanCarBuilder
    var director: CarDirector = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)

    carBuilder = SportsCarBuilder
    director = CarDirector(carBuilder)

    director.build
    println(carBuilder.getCar)
  }

}

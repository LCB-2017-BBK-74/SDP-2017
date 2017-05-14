package builder

/**
  * Created by lucieburgess on 23/04/2017.
  */
case class CarDirector(var carbuilder: CarBuilder) {

  def build = {

    carbuilder.buildBodyStyle
    carbuilder.buildBrakes
    carbuilder.buildEngine
    carbuilder.buildFuelType
    carbuilder.buildPower
    carbuilder.buildSeats
    carbuilder.buildWindows
  }

}

package builder

/**
  * Created by lucieburgess on 23/04/2017.
  */
trait CarBuilder {

  def buildBodyStyle

  def buildPower

  def buildEngine

  def buildBrakes

  def buildSeats

  def buildWindows

  def buildFuelType

  def getCar: Car

}

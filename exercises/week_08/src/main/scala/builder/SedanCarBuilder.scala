package builder

/**
  * Created by lucieburgess on 23/04/2017.
  */
object SedanCarBuilder extends CarBuilder {

  private val sedan = Car("Sedan Car")

  override def buildBodyStyle = {
    sedan.bodyStyle = "Sedan body style"
  }

  override def buildPower = {
    sedan.power = "Sedan power"
  }

  override def buildEngine = {
    sedan.engine = "Sedan engine"
  }

  override def buildBrakes = {
    sedan.brakes = "Sedan brakes"
  }

  override def buildSeats = {
    sedan.seats = "Sedan seats"
  }

  override def buildWindows = {
    sedan.windows = "Sedan windows"
  }

  override def buildFuelType = {
    sedan.fuelType = "Diesel 19 MPG city"
  }

  override def getCar = sedan

}

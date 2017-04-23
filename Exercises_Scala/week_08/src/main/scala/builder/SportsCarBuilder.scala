package builder

/**
  * Created by lucieburgess on 23/04/2017.
  */
object SportsCarBuilder extends CarBuilder{

    private val sports = Car("Sports Car")

    override def buildBodyStyle = {
      sports.bodyStyle = "Sporty Body Style"
    }

    override def buildPower = {
      sports.power = "Sporty power"
    }

    override def buildEngine = {
      sports.engine = "Sporty engine"
    }

    override def buildBrakes = {
      sports.brakes = "Sporty brakes"
    }

    override def buildSeats = {
        sports.seats = "Sporty seats"
    }

    override def buildWindows = {
      sports.windows = "Sporty windows"
    }

    override def buildFuelType = {
      sports.fuelType = "Petrol 17 MPG city"
    }

    override def getCar = sports

}

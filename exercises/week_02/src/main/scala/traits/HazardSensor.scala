package traits

/**
  * Created by lucieburgess on 25/01/2017.
  */
trait HazardSensor extends Sensor {

    def getBatteryPercentage: Double
    // Returns a number between 1 and 100 where 0 is empty and 100 is fully charged

}

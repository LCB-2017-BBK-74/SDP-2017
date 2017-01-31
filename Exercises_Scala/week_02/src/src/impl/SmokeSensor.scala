package impl

/**
  * Created by lucieburgess on 26/01/2017.
  */

import scala.util.Random

class SmokeSensor(location: String) extends Sensor with HazardSensor {

  /**
    * created by LucieCBurgess on 24.01.2017
    * Task is to implement and test the SmokeSensor methods
    * For this I created a mew trait called HazardSensor. Both SmokeSensor and FireSensor implement interface HazardSensor
    */

    private val sensorType: String = "Smoke_sensor"
    private var batteryPercentage: Int = 100
    private var randomint = new Random

    override def isTriggered: Boolean = {
      if (getBatteryPercentage != 0) {
        batteryPercentage -= 20
      }
      return Random.nextInt() < 0.1
    }

    override def getLocation: String = location

    override def getSensorType: String = sensorType

    override def getBatteryPercentage: Double = batteryPercentage

}

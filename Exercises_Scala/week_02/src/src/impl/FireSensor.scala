package impl

/**
  * created by LucieCBurgess on 24.01.2017
  * Task is to implement and test the FireSensor methods
  */

import scala.util.Random

class FireSensor(location: String) extends Sensor with HazardSensor {

    private val sensorType: String = "Fire_sensor"
    private var batteryPercentage: Int = 100
    private var randomint = new Random

    override def isTriggered: Boolean = {
      if (getBatteryPercentage != 0) batteryPercentage -= 10
      Random.nextInt() < 0.05
    }

    override def getLocation: String = location

    override def getSensorType: String = sensorType

    override def getBatteryPercentage: Double = batteryPercentage

}

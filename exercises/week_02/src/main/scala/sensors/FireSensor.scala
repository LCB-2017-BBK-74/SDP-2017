package sensors

/**
  * created by LucieCBurgess on 24.01.2017
  * Task is to implement and test the FireSensor methods
  * FireSensor implements Sensor and HazardSensor
  * 5% of the time it is called, it raises an alarm
  * Drains 10% of the battery between each poll
  */

import traits.{HazardSensor, Sensor}

import scala.util.Random

class FireSensor(private val location: String, private val sensorType: String = "Fire_sensor",
                 private var batteryPercentage: Int = 100) extends Sensor with HazardSensor {

    override def isTriggered: Boolean = {
      if (getBatteryPercentage != 0) batteryPercentage -= 10
      Random.nextInt(100) < 5
    }

    override def getLocation: String = location

    override def getSensorType: String = sensorType

    override def getBatteryPercentage: Double = batteryPercentage

}

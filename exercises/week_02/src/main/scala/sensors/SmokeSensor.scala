package sensors

/**
  * Created by lucieburgess on 26/01/2017.
  * Task is to implement and test the SmokeSensor methods
  * For this I created a mew trait called traits.HazardSensor.
  * FireSensor implements Sensor and HazardSensor
  */

import scala.util.Random

import traits.{HazardSensor, Sensor}

class SmokeSensor(private val location: String, private val sensorType: String = "Smoke_sensor",
                  private var batteryPercentage: Int = 100) extends Sensor with HazardSensor {

  override def isTriggered: Boolean = {
    if (getBatteryPercentage != 0) batteryPercentage -= 20
    Random.nextInt(100) < 10
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = batteryPercentage

}

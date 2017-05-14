package sensors

/**
  * Created by lucieburgess on 14/05/2017.
  */

import traits.{SecuritySensor, Sensor}

import scala.util.Random

class MotionSensor(private val location: String, private val sensorType: String = "Motion_sensor")
                                      extends Sensor with SecuritySensor {

  override def isTriggered: Boolean = {
    Random.nextInt(100) < 5
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType



  }

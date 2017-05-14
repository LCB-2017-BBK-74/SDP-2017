import java.time.LocalTime

import traits.{SecuritySensor, Sensor}

import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 14/05/2017.
  */
class SecurityControlUnit extends ControlUnit {

  /**
    * Takes a sensor to be configured as an argument
    * @param sensor
    * @return list of configured sensors for this control unit
    */
  def configureSensor(sensor: SecuritySensor): ListBuffer[Sensor] = {
    sensors += sensor
  }

  override def pollSensors() {
    if (timeCheck) super.pollSensors()
  }

  def timeCheck: Boolean = {
    val timePoint = LocalTime.now
    val timeOn = LocalTime.of(22, 0)
    val timeOff = LocalTime.of(6, 0)
    timePoint.isAfter(timeOn) || timePoint.isBefore(timeOff)
  }

}

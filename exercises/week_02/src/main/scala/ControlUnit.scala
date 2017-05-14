import scala.collection.mutable.ListBuffer
import traits.{HazardSensor, Sensor}

class ControlUnit {

  val sensors = new ListBuffer[Sensor]()

  /**
    * Takes a sensor to be configured as an argument
    * @param sensor
    * @return list of configured sensors for this control unit
    */
  def configureSensor(sensor: HazardSensor): ListBuffer[Sensor] = {
    sensors += sensor
  }

  /**
    * @throws UnsupportedOperationException if the control unit attempts to poll the sensors before configuring
    */
  def pollSensors() :Unit = {
      if (sensors.isEmpty) throw new UnsupportedOperationException
      else for (sensor <- sensors) {
        if (sensor.isTriggered) println(s"A ${sensor.getSensorType} was triggered at ${sensor.getLocation}")
        else println(s"Polled ${sensor.getSensorType} at ${sensor.getLocation} successfully")
      }
  }

}

object ControlUnit

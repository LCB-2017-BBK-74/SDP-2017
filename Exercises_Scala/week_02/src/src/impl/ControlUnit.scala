import scala.collection.mutable.ListBuffer
import impl.Sensor
import impl.FireSensor
import impl.SmokeSensor

object ControlUnit

class ControlUnit {

  val sensors = new ListBuffer[Sensor]()
  sensors += new FireSensor("Auditorium")
  sensors += new SmokeSensor("Ground_floor_lobby")

  def pollSensors() {

    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

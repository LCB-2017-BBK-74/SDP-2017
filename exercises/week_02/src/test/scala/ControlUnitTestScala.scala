/**
  * Created by lucieburgess on 14/05/2017.
  */

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import sensors.{FireSensor, SmokeSensor}

class ControlUnitTestScala extends FunSuite with BeforeAndAfter {

  val fs1 = new FireSensor("Auditorium")
  val fs2 = new FireSensor("Lobby")
  val ss1 = new SmokeSensor("Auditorium")
  val ss2 = new SmokeSensor("Lobby")

  test("[01] controlUnitConfiguresNewSensors") {
    val cu = new ControlUnit
    cu.configureSensor(fs1)
    cu.configureSensor(fs2)
    assert(cu.sensors(0).equals(fs1))
    assert(cu.sensors(1).equals(fs2))
  }

  test("[02 controlUnitPollsSensorsCorrectly") {
    val cu1 = new ControlUnit
    cu1.configureSensor(ss1)
    cu1.configureSensor(ss2)
    cu1.pollSensors()
  }

  test("[03 notConfiguringControlUnitThrowsException") {
    val cu2 = new ControlUnit
    intercept[UnsupportedOperationException] {
      cu2.pollSensors()
    }
    assert(cu2.sensors.isEmpty)
  }

}

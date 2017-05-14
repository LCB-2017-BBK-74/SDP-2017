/**
  * Created by lucieburgess on 14/05/2017.
  */

import org.scalatest.FunSuite
import sensors.FireSensor

class FireSensorTestScala extends FunSuite {

  test("[01] isTriggeredReturnsTrue5%OfTime") {
    val fs = new FireSensor("location1")
    var triggered = 0
    for (i <- 1 to 10000) {
      if (fs.isTriggered) triggered += 1
    }
    assert(triggered <= (10000 * 0.06))
  }

  test("[02] getLocationReturnsLocation") {
    val fs = new FireSensor("location_2")
    assert(fs.getLocation.equals("location_2"))
  }

  test("[03 getSensorTypeReturnsCorrectType") {
    val fs = new FireSensor("Location3")
    assert(fs.getSensorType == "Fire_sensor")
  }

  test("[04 getBatteryPercentageReturns100WhenNew") {
    val fs = new FireSensor("auditorium")
    assert(fs.getBatteryPercentage == 100)
  }

  test("[05 getBatteryPercentageReturns80WhenPolledTwice") {
    val fs = new FireSensor("hallway")
    fs.isTriggered
    fs.isTriggered
    assert(fs.getBatteryPercentage == 80)
  }

  test("[06 batteryNeverDrainsBelowZero") {
    val fs = new FireSensor("Lounge")
    for (i <- 1 to 20) {
      fs.isTriggered
    }
    assert(fs.getBatteryPercentage == 0)
  }

}



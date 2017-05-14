/**
  * Created by lucieburgess on 14/05/2017.
  */

import org.scalatest.FunSuite
import sensors.SmokeSensor

class SmokeSensorTestScala extends FunSuite {

    test("[01] isTriggeredReturnsTrue10%OfTime") {
      val ss = new SmokeSensor("location1")
      var triggered = 0
      for (i <- 1 to 10000) {
        if (ss.isTriggered) triggered += 1
      }
      assert(triggered <= (10000 * 0.11))
    }

    test("[02] getLocationReturnsLocation") {
      val ss = new SmokeSensor("location_2")
      assert(ss.getLocation.equals("location_2"))
    }

    test("[03 getSensorTypeReturnsCorrectType") {
      val ss = new SmokeSensor("location_3")
      assert(ss.getSensorType == "Smoke_sensor")
    }

    test("[04 getBatteryPercentageReturns100WhenNew") {
      val ss = new SmokeSensor("auditorium")
      assert(ss.getBatteryPercentage == 100)
    }

    test("[05 getBatteryPercentageReturns60WhenPolledTwice") {
      val ss = new SmokeSensor("hallway")
      ss.isTriggered
      ss.isTriggered
      assert(ss.getBatteryPercentage == 60)
    }

    test("[06 batteryNeverDrainsBelowZero") {
      val ss = new SmokeSensor("Lounge")
      for (i <- 1 to 20) ss.isTriggered
      assert(ss.getBatteryPercentage == 0)
    }

}

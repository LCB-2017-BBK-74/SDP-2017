package impl;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {

  private String location1 = "Auditorium";
  private String location2 = "Break_out_room";
  private String location3 = "Cloakroom";

  public void pollSensors() {
    List<Sensor> sensors = new ArrayList<Sensor>();
    sensors.add(new FireSensor(location1));
    sensors.add(new FireSensor(location2));
    sensors.add(new FireSensor(location3));
    sensors.add(new SmokeSensor(location1));
    sensors.add(new SmokeSensor(location2));
    sensors.add(new SmokeSensor(location3));

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
      } else {
        System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
      }
    }
  }
}

/** Part 3. ControlUnit.pollSensors() method. Its current responsibilities are to add sensors to an ArrayList,
 * instantiating a new object each time new FireSensor(location) or new SmokeSensor(location) is called
 * If the sensor is triggered, get the sensor type and sensor location and print them;
 *  Finally to print a message stating that theu have been polled successfully
 *  Sensors will be polled each time the pollSensors() method is called but not always triggered
 *
 *  The current design - creating the list of sensors within the pollSensors() method in the ControlUnit class -
 *  violates the Single Responsibility Principle (the S of SOLID).
 *  Instead, we want to create the list outside the pollSensors() method, but still within the ControlUnit class.
 *  Alternatively we could create a new class just for creating the sensor list, but this feels over-complex.
 */
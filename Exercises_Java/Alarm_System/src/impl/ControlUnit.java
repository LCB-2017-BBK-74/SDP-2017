package impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * ControlUnit class to control Hazard Sensors.
 * SecuritySensors are only polled at night so are managed in a different class, SecurityControlUnit.
 */

public class ControlUnit {

  protected String location1 = "Auditorium";  // protected fields can be inherited by the subclass SecurityControlUnit
  protected String location2 = "Break_out_room";
  protected String location3 = "Cloakroom";

  private FireSensor fs1 = new FireSensor(location1);
  private FireSensor fs2 = new FireSensor(location2);
  private FireSensor fs3 = new FireSensor(location3);
  private SmokeSensor ss1 = new SmokeSensor(location1);
  private SmokeSensor ss2 = new SmokeSensor(location1);
  private SmokeSensor ss3 = new SmokeSensor(location1);

  private List<Sensor> cuSensors = Arrays.asList(fs1, fs2, fs3, ss1, ss2, ss3);

  public ControlUnit(List<Sensor> sensorList) { // pass in list of sensors to the constructor
      this.cuSensors = sensorList;
  }

  public List<Sensor> getSensors() {
      return cuSensors;
  }

  public void pollSensors() {

      for (Sensor sensor : cuSensors) {
          if (sensor.isTriggered()) {
              System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
          } else {
              System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
          }
      }
  }
}

// Bit confused here - doesn't make sense to both list the sensors as fields, and pass them in as a parameter to the constructor
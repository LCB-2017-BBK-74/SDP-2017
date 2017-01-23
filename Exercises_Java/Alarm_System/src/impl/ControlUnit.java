package impl;

import java.util.List;
import impl.SensorProvider;


/**
 * ControlUnit class to control Sensors.
 * HazardSensors have additional behaviour but extend Sensor.
 * SecuritySensors are only polled at night so are managed in a different class, SecurityControlUnit.
 * Set up a new SensorProvider to provide the sensors to the ControlUnit, so that these can change
 * independent of the class - but seems a bit elaborate ...
 */

public class ControlUnit {

  private List<Sensor> configuredSensors;

  public ControlUnit() { // pass in list of sensors to the constructor
      configureControlUnitSensors();
  }

  public void configureControlUnitSensors() {
      SensorProvider sp = new SensorProvider();
      sp.addSensors();
      configuredSensors = sp.getSensorList();
  }

  public void pollSensors() {

      for (Sensor sensor : configuredSensors) {
          if (sensor.isTriggered()) {
              System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
          } else {
              System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
          }
      }
  }
}

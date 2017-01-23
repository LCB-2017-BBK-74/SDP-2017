package impl;

import java.util.ArrayList;
import java.util.List;

/**
 * ControlUnit class to control Sensors.
 * HazardSensors have additional behaviour but extend Sensor.
 * SecuritySensors are only polled at night so are managed in a different class, SecurityControlUnit.
 * Set up a new SensorProvider to provide the sensors to the ControlUnit, so that these can change
 * independent of the class - but seems a bit elaborate ...
 * Should adding the sensors be in the Control Unit class?
 * How do we make sure that Hazard sensors can only be added to the Control UNit and security sensors to the SecurityControlUnit?
 * Does tieing the sensorList into the constructor create problems of preventing a motion sensors being used in the security list?
 *
 */

public class ControlUnit {

    private List<Sensor> configuredSensors = new ArrayList<>();

    public ControlUnit() {
    }

    public void addSensor(String location, String sensorType) throws NullPointerException, IllegalArgumentException {

        if ((location == null) || (sensorType == null)) {
            throw new NullPointerException("You must specify a location and sensor type");
        }
        if (sensorType == "Motion" || sensorType == "") {
            throw new IllegalArgumentException("Sensor must be a smoke sensor or fire sensor");

        } else if (sensorType == "Fire") {
            configuredSensors.add(new FireSensor(location));
        } else if (sensorType == "Smoke") {
            configuredSensors.add(new SmokeSensor(location));
        } else {
            System.out.println("You must add a sensor to configure the Control Unit. Please try again");
        }
    }

    public List<Sensor> getSensors() {
      return configuredSensors;
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

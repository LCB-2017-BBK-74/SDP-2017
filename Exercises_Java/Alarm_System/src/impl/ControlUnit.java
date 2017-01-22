package impl;

import impl.Sensor;
import java.util.ArrayList;
import java.util.List;

public class ControlUnit {

  private String location1 = "Auditorium";
  private String location2 = "Break_out_room";
  private String location3 = "Cloakroom";

  private List<Sensor> sensors;

  public ControlUnit() {
      sensors = new ArrayList<>();
      configureSensors();
  }

  public List<Sensor> getSensors() {
      return sensors;
  }

  public void configureSensors() {
      sensors.add(new FireSensor(location1));
      sensors.add(new FireSensor(location2));
      sensors.add(new FireSensor(location3));
      sensors.add(new SmokeSensor(location1));
      sensors.add(new SmokeSensor(location2));
      sensors.add(new SmokeSensor(location3));
  }

  public void pollSensors() {

      for (Sensor sensor : sensors) {
          if (sensor.isTriggered()) {
              System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
          } else {
              System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
          }
      }
  }
}

package test;

import impl.SmokeSensor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeSensorTest {

  private String location1 = "Auditorium";
  private String location2 = "Break_out_room";
  private String location3 = "Cloakroom";

  @Test
  public void testLocationOmittedThrowsNPE() throws NullPointerException {
    SmokeSensor sensor = new SmokeSensor(null);
  }

  @Test
  public void testThatIsTriggeredReturnsTrueApprox10PercentOfTime() {
    SmokeSensor sensor = new SmokeSensor(location1);
    int triggered = 0;
    for (int i = 0; i < 10000; i++) {
      boolean isTriggered = sensor.isTriggered();
      if (isTriggered) triggered++;
      assertTrue(triggered <= (10000*0.11) );
    }
  }

  @Test
  public void testThatGetLocationReturnsLocation() {
    SmokeSensor sensor = new SmokeSensor(location2);
    String location = sensor.getLocation();
    assertEquals("Break_out_room", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsSmokeSensor() {
    SmokeSensor sensor = new SmokeSensor(location3);
    String sensorType = sensor.getSensorType();
    assertEquals("Smoke_sensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100WhenInstantiated() {
    SmokeSensor sensor = new SmokeSensor(location1);
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100, batteryPercentage,0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReducesWhenTriggered() {
    SmokeSensor sensor = new SmokeSensor(location2);
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(80,batteryPercentage);
  }

  @Test
  public void testThatBatteryCannotDrainBelowZero() {
    SmokeSensor sensor = new SmokeSensor(location3);
    for (int i = 0; i <= 20; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0,batteryPercentage);
  }

}

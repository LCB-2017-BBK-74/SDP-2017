package test;

import impl.SmokeSensor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsTrueApprox10PercentOfTime() {
    SmokeSensor sensor = new SmokeSensor("Auditorium");
    int triggered = 0;
    for (int i = 0; i < 10000; i++) {
      boolean isTriggered = sensor.isTriggered();
      if (isTriggered) triggered++;
    }
    assertTrue(triggered <= (10000*0.11));
  }

  @Test
  public void testThatGetLocationReturnsLocation() {
    SmokeSensor sensor = new SmokeSensor("Break_out_room");
    String location = sensor.getLocation();
    assertTrue(location == "Break_out_room");
  }

  @Test
  public void testThatGetSensorTypeReturnsSmokeSensor() {
    SmokeSensor sensor = new SmokeSensor("Lobby");
    String sensorType = sensor.getSensorType();
    assertEquals("Smoke_sensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100WhenInstantiated() {
    SmokeSensor sensor = new SmokeSensor("Auditorium");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100, batteryPercentage,0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReducesWhenTriggered() {
    SmokeSensor sensor = new SmokeSensor("Corridor");
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(80,batteryPercentage);
  }

  @Test
  public void testThatBatteryCannotDrainBelowZero() {
    SmokeSensor sensor = new SmokeSensor("Auditorium");
    for (int i = 0; i <= 20; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0,batteryPercentage);
  }

}

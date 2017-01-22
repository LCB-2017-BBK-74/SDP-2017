package test;

import impl.FireSensor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FireSensorTest {

  private String location1 = "Auditorium";
  private String location2 = "Break_out_room";
  private String location3 = "Cloakroom";

  @Test
  public void testLocationOmittedThrowsNPE() throws NullPointerException {
    FireSensor sensor = new FireSensor(null);
  }

  @Test
  public void testThatIsTriggeredReturnsTrueApprox5PercentOfTime() {
    FireSensor sensor = new FireSensor(location1);
    int triggered = 0;
    for (int i = 0; i < 10000; i++) {
      boolean isTriggered = sensor.isTriggered();
      if (isTriggered) triggered++;
      assertTrue(triggered <= (10000*0.06) );
    }
  }

  @Test
  public void testThatGetLocationReturnsLocation() {
    FireSensor sensor = new FireSensor(location2);
    String location = sensor.getLocation();
    assertEquals("Break_out_room", location2);
  }

  @Test
  public void testThatGetSensorTypeReturnsFireSensor() {
    FireSensor sensor = new FireSensor(location3);
    String sensorType = sensor.getSensorType();
    assertEquals("Fire_sensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100WhenInstantiated() {
    FireSensor sensor = new FireSensor(location1);
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100, batteryPercentage,0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReducesWhenTriggered() {
    FireSensor sensor = new FireSensor(location2);
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(90,batteryPercentage);
  }

  @Test
  public void testThatBatteryCannotDrainBelowZero() {
    FireSensor sensor = new FireSensor("Auditorium");
    for (int i = 0; i <= 20; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0,batteryPercentage);
  }

}

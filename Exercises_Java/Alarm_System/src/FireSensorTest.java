import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FireSensorTest {

  @Test
  public void testLocationOmittedThrowsNPE() throws NullPointerException {
    FireSensor sensor = new FireSensor(null);
  }

  @Test
  public void testThatIsTriggeredReturnsTrueApprox5PercentOfTime() {
    FireSensor sensor = new FireSensor("Auditorium");
    int triggered = 0;
    for (int i = 0; i < 10000; i++) {
      boolean isTriggered = sensor.isTriggered();
      if (isTriggered) triggered++;
      assertTrue(triggered <= (10000*0.06) );
    }
  }

  @Test
  public void testThatGetLocationReturnsLocation() {
    FireSensor sensor = new FireSensor("Auditorium");
    String location = sensor.getLocation();
    assertEquals("Auditorium", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsFireSensor() {
    FireSensor sensor = new FireSensor("Auditorium");
    String sensorType = sensor.getSensorType();
    assertEquals("Fire_sensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100WhenInstantiated() {
    FireSensor sensor = new FireSensor("Auditorium");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100, batteryPercentage,0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReducesWhenTriggered() {
    FireSensor sensor = new FireSensor("Auditorium");
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

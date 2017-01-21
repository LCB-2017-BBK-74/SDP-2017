import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsTrueApprox5PercentOfTime() {
    FireSensor sensor = new FireSensor();
    int triggered = 0;
    for (int i = 0; i < 10000; i++) {
      boolean isTriggered = sensor.isTriggered();
      if (isTriggered) triggered++;
      assertTrue(triggered <= (10000*0.06) );
    }
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor();
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor();
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }
}

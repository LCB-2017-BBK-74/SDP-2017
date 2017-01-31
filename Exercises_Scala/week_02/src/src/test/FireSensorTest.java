package test;

import impl.FireSensor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FireSensorTest {

    @Test
    public void testThatIsTriggeredReturnsTrueApprox5PercentOfTime() {
        FireSensor sensor = new FireSensor("Auditorium");
        int triggered = 0;
        for (int i = 0; i < 10000; i++) {
            boolean isTriggered = sensor.isTriggered();
            if (isTriggered) triggered++;
        }
        assertTrue(triggered <= (10000*0.06));
    }

    @Test
    public void testThatGetLocationReturnsLocation() {
        FireSensor sensor = new FireSensor("Break_out_room");
        String location = sensor.getLocation();
        assertTrue(location == "Break_out_room");
    }

    @Test
    public void testThatGetSensorTypeReturnsFireSensor() {
        FireSensor sensor = new FireSensor("Lobby");
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
        FireSensor sensor = new FireSensor("Corridor");
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

package test;

/**
 * Created by lucieburgess on 22/01/2017.
 */

import impl.MotionSensor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MotionSensorTest {

    private String location1 = "Auditorium";
    private String location2 = "Break_out_room";
    private String location3 = "Cloakroom";

    @Test
    public void testLocationOmittedThrowsNPE() throws NullPointerException {
        MotionSensor sensor = new MotionSensor(null);
    }

    @Test
    public void testThatIsTriggeredReturnsTrueApprox20PercentOfTime() {
        MotionSensor sensor = new MotionSensor(location1);
        int triggered = 0;
        for (int i = 0; i < 10000; i++) {
            boolean isTriggered = sensor.isTriggered();
            if (isTriggered) triggered++;
            assertTrue(triggered <= (10000*0.21) );
        }
    }

    @Test
    public void testThatGetLocationReturnsLocation() {
        MotionSensor sensor = new MotionSensor(location2);
        String location = sensor.getLocation();
        assertEquals("Break_out_room", location2);
    }

    @Test
    public void testThatGetSensorTypeReturnsMotionSensor() {
        MotionSensor sensor = new MotionSensor(location3);
        String sensorType = sensor.getSensorType();
        assertEquals("Motion_sensor", sensorType);
    }


}

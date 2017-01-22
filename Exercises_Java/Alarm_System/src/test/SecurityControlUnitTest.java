package test;

import impl.MotionSensor;
import impl.Sensor;
import impl.SecurityControlUnit;
import impl.SecuritySensor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityControlUnitTest {

    protected String location1 = "Auditorium";
    protected String location2 = "Break_out_room";
    protected String location3 = "Cloakroom";

    private SecuritySensor ms1 = new MotionSensor(location1);
    private SecuritySensor ms2 = new MotionSensor(location2);
    private SecuritySensor ms3 = new MotionSensor(location3);

    List<Sensor> motionSensors = Arrays.asList(ms1, ms2, ms3);

    /**
     * Current setup of SecurityControlUnit does not lend itself easily to tests so this simply checks that
     * all 3 sensors are listed when either triggered or polled
     */
    @Test
    public void createSecurityNewControlUnitPrintsSomeText(){
        for (int i = 0; i < 20; i++) {
            System.out.println("This is test " + i);
            SecurityControlUnit scu = new SecurityControlUnit(motionSensors);
            scu.pollSensors();
        }
    }

    @Test
    public void constructorCreatesListOfSizeThree() {
        SecurityControlUnit scu = new SecurityControlUnit(motionSensors);
        assertEquals(3, scu.getSensors().size());
    }

    @Test
    public void getSensorsReturnsSensors() {
        SecurityControlUnit scu = new SecurityControlUnit(motionSensors);
        System.out.println(scu.getSensors().toString());
    }

    @Test
    public void timeCheckReturnsTrueIfInRange() {
        SecurityControlUnit scu = new SecurityControlUnit(motionSensors);
    }

    @Test
    public void timeCheckReturnsFalseIfOutsideRange() {
        // test not yet implemented
    }
}


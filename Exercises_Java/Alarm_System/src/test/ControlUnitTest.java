package test;

import impl.ControlUnit;
import impl.Sensor;
import impl.FireSensor;
import impl.SmokeSensor;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControlUnitTest {

    protected String location1 = "Auditorium";
    protected String location2 = "Break_out_room";
    protected String location3 = "Cloakroom";

    private FireSensor fs1 = new FireSensor(location1);
    private FireSensor fs2 = new FireSensor(location2);
    private FireSensor fs3 = new FireSensor(location3);
    private SmokeSensor ss1 = new SmokeSensor(location1);
    private SmokeSensor ss2 = new SmokeSensor(location1);
    private SmokeSensor ss3 = new SmokeSensor(location1);

    private List<Sensor> hazardSensors = Arrays.asList(fs1,fs2,fs3,ss1,ss2,ss3);

    /**
     * Current setup of ControlUnit does not lend itself easily to tests so this simply checks that all 6 sensors
     * are listed when either triggered or polled
     */
    @Test
    public void createNewControlUnitPrintsSomeText(){
        for (int i = 0; i < 20; i++) {
            System.out.println("This is test " + i);
            ControlUnit cu = new ControlUnit(hazardSensors);
            cu.pollSensors();
        }
    }

    @Test
    public void constructorCreatesListOfSizeSix() {
        ControlUnit cu = new ControlUnit(hazardSensors);
        assertEquals(6, cu.getSensors().size());
    }

    @Test
    public void getSensorsReturnsSensors() {
        ControlUnit cu = new ControlUnit(hazardSensors);
        System.out.println(cu.getSensors().toString());
    }

}

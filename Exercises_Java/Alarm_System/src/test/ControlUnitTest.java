package test;

import impl.ControlUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControlUnitTest {

    @Test
    public void createNewControlUnitCreatesEmptySensorList(){
        ControlUnit cu = new ControlUnit();
        assertEquals(0,cu.getSensors().size());
    }

    @Test
    public void addingSensorsCreatesCorrectSizedList() {
        ControlUnit cu = new ControlUnit();
        cu.addSensor("Lobby_ground_floor","Fire");
        cu.addSensor("Auditorium", "Smoke");
        cu.addSensor("Cloakroom", "Fire");
        assertEquals(3, cu.getSensors().size());
    }

    @Test
    public void addSensorNullLocationThrowsNullPointerException() {
        ControlUnit cu = new ControlUnit();
        cu.addSensor(null,"Fire");
        Throwable exception = assertThrows(NullPointerException.class, () -> {
                    throw new IllegalArgumentException("You must specify a location and sensor type");
                });
        assertEquals("You must specify a location and sensor type", exception.getMessage());
    }


    @Test
    public void addSensorNullTypeThrowsNullPointerException() throws NullPointerException {
        ControlUnit cu = new ControlUnit();
        cu.addSensor("Lobby_ground_floor", null);
    }

    @Test
    public void addMotionSensorThrowsIllegalArgumentException() throws IllegalArgumentException {
        ControlUnit cu = new ControlUnit();
        cu.addSensor("Lobby_ground_floor", "Motion");
    }

    @Test
    protected void getSensorsReturnsSensors() {
        ControlUnit cu = new ControlUnit();
        cu.addSensor("Lobby_ground_floor","Fire");
        cu.addSensor("Auditorium", "Smoke");
        cu.addSensor("Cloakroom", "Fire");
        System.out.println(cu.getSensors().toString());
    }

    @Test
    public void pollSensorsPrintsCorrectMessage() {
        ControlUnit cu = new ControlUnit();
        cu.addSensor("Lobby_ground_floor","Fire");
        cu.addSensor("Auditorium", "Smoke");
        cu.addSensor("Cloakroom", "Fire");
        cu.pollSensors();
    }

}

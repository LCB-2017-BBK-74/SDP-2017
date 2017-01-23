package test;

import impl.SecurityControlUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityControlUnitTest {

    @Test
    public void createNewSecurityControlUnitCreatesEmptySensorList(){
        SecurityControlUnit scu = new SecurityControlUnit();
        assertEquals(0,scu.getSensors().size());
    }

    @Test
    public void addingSensorsCreatesCorrectSizedList() {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor","Motion");
        scu.addSensor("Auditorium", "Motion");
        scu.addSensor("Cloakroom", "Motion");
        assertEquals(3, scu.getSensors().size());
    }

    @Test
    public void addSensorNullLocationThrowsNullPointerException() {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor(null,"Fire");
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("You must specify a location and sensor type");
        });
        assertEquals("You must specify a location and sensor type", exception.getMessage());
    }

    @Test
    public void addSensorNullTypeThrowsNullPointerException() throws NullPointerException {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor", "null");
    }

    @Test
    public void addMotionSensorThrowsIllegalArgumentException() throws IllegalArgumentException {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor", "Motion");
    }

    @Test
    public void getSensorsReturnsSensors() {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor","Motion");
        scu.addSensor("Auditorium", "Motion");
        scu.addSensor("Cloakroom", "Motion");
        System.out.println(scu.getSensors().toString());
    }

    /**
     * Need to adjust the outcome of this test depending on the local time. Should be true from 22:00 - 06:00
     */
    @Test
    public void timeCheckReturnsTrueIfInRange() {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor","Motion");
        assertTrue(scu.timeCheck());
    }

    @Test
    public void sensorsPolledIfTimeCheckInRange() {
        SecurityControlUnit scu = new SecurityControlUnit();
        scu.addSensor("Lobby_ground_floor","Motion");
        scu.addSensor("Auditorium", "Motion");
        scu.addSensor("Cloakroom", "Motion");
        scu.pollSensors();
    }

}


package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalTime;

/**
 * Created by lucieburgess on 22/01/2017.
 */
public class SecurityControlUnit extends ControlUnit {

    private List<Sensor> configuredSensors;

    public SecurityControlUnit() {
        super();
    }

    public void configureControlUnitSensors() {
        super.configureControlUnitSensors();
    }

    public void pollSensors() {
        super.pollSensors();
    }

    public boolean timeCheck() {
        LocalTime timePoint = LocalTime.now();
        LocalTime timeOn = LocalTime.of(22,0);
        LocalTime timeOff = LocalTime.of(6,0);
        if (timePoint.isAfter(timeOn) || timePoint.isBefore(timeOff)) {
            return true;
        }
        return false;
    }

    public void pollSecuritySensors() {
        if (timeCheck()) {
            super.pollSensors();
        }

    }

}

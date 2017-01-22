package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalTime;

/**
 * Created by lucieburgess on 22/01/2017.
 */
public class SecurityControlUnit extends ControlUnit {

    protected String location1 = "Auditorium";
    protected String location2 = "Break_out_room";
    protected String location3 = "Cloakroom";

    private SecuritySensor ms1 = new MotionSensor(location1);
    private SecuritySensor ms2 = new MotionSensor(location2);
    private SecuritySensor ms3 = new MotionSensor(location3);

    private List<Sensor> sensorList = Arrays.asList(ms1, ms2, ms3);

    public SecurityControlUnit(List<Sensor> sensorList) {
        super(sensorList);
    }
    // passes in the security sensors only through the parent constructor - surely in this case though we
    // now have 6 FireSensors rather than 3 motionSensors?
    // I think we need to somehow separate the list of sensors from the constructor - but I don't understand how else
    // we pass them in


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

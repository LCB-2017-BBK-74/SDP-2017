package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalTime;

/**
 * Created by lucieburgess on 22/01/2017.
 */
public class SecurityControlUnit extends ControlUnit {

   private List<Sensor> configuredSensors = new ArrayList<>();

    public SecurityControlUnit() {
        super();
    }

    @Override // method has different behaviour to ControlUnit
    public void addSensor(String location, String sensorType) throws IllegalArgumentException, NullPointerException {

        if (location == null || sensorType == null) {
            throw new NullPointerException("You must specify a location and sensor type");
        }
        if (sensorType == "Fire" || sensorType == "Smoke" || sensorType == "") {
            throw new IllegalArgumentException("Sensor type must be a security sensor, such as Motion");

        } else if (sensorType == "Motion") {
            configuredSensors.add(new MotionSensor(location));

        } else {
            System.out.println("You must add a sensor to configure the Control Unit. Please try again");
        }
    }

    public List<Sensor> getSensors() {
        return configuredSensors;
    }

    public boolean timeCheck() {
        LocalTime timePoint = LocalTime.now();
        LocalTime timeOn = LocalTime.of(22,0);
        LocalTime timeOff = LocalTime.of(6,0);
        return (timePoint.isAfter(timeOn) || timePoint.isBefore(timeOff));
    }

    @Override
    public void pollSensors() {
        if (timeCheck()) {
            super.pollSensors();
        }
    }

}

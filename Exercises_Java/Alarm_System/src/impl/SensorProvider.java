package impl;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by lucieburgess on 22/01/2017.
 * Class which provides a list of sensors to provide to either ControlUnit or SecurityControlUnit.
 */
public class SensorProvider {

//    private static String location1 = "Auditorium";
//    private static String location2 = "Break_out_room";
//    private static String location3 = "Cloakroom";
//
//    private static FireSensor fs1 = new FireSensor(location1);
//    private static FireSensor fs2 = new FireSensor(location2);
//    private static FireSensor fs3 = new FireSensor(location3);
//    private static SmokeSensor ss1 = new SmokeSensor(location1);
//    private static SmokeSensor ss2 = new SmokeSensor(location1);
//    private static SmokeSensor ss3 = new SmokeSensor(location1);
//
//    private static SecuritySensor ms1 = new MotionSensor(location1);
//    private static SecuritySensor ms2 = new MotionSensor(location2);
//    private static SecuritySensor ms3 = new MotionSensor(location3);

    private static List<Sensor> sensorList = new ArrayList<>(); //add more sensors here

//    private static List<Sensor> hazardSensors = Arrays.asList(fs1, fs2, fs3, ss1, ss2, ss3);

//    private static List<Sensor> securitySensors = Arrays.asList(ms1, ms2, ms3);

    public SensorProvider() {
    }

    public void addSensors() {
        // add a while loop to cover the situation where user must add sensors until 0 is entered.
        // could also do a ENUM or case statement here to cover different types of sensors
        String location = "";
        System.out.println("Please add a sensor location to the control unit");
        // text entered = location
        String sensorType = "";
        System.out.println("Please add a sensor type to the control unit - Fire, Smoke or Motion");
        if (sensorType == "Fire") {
            sensorList.add(new FireSensor(location));
        } else if (sensorType == "Smoke") {
            sensorList.add(new SmokeSensor(location));
        } else if (sensorType == "Motion") {
            sensorList.add(new MotionSensor(location));
        } else {
            System.out.println("You must add a sensor to configure the Control Unit. Please try again");
        }
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

}

package impl;

import java.util.Random;

/**
 * Created by lucieburgess on 21/01/2017.
 */
public class MotionSensor implements SecuritySensor {

    private String location;
    private String sensorType;
    private Random randomint;

    public MotionSensor(String location) {
        this.location = location;
        this.sensorType = "Motion_sensor";
        randomint = new Random();
        //randomint.setSeed(1); // not sure if I need this or not. Will give a consistent result?
    }

    /**
     * Raises an alarm 20% of the time it is called.
     *
     * @return true 20% of the time
     */
    @Override
    public boolean isTriggered() {
        return randomint.nextInt(100) <= 20;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return sensorType;
    }

}

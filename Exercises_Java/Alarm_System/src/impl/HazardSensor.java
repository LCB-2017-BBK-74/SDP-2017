package impl;

/**
 * Created by lucieburgess on 21/01/2017.
 */
public interface HazardSensor extends Sensor {

    /**
     * Additional method for HazardSensors, which run on batteries
     * @return the % of the battery left. Full batteries start at 100.
     */
    double getBatteryPercentage();
    // Returns a number between 1 and 100 where 0 is empty and 100 is fully charged
}

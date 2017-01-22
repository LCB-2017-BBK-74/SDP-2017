package impl;

import java.util.Random;

public class FireSensor implements HazardSensor {

  private String location;
  private String sensorType;
  private double batteryPercentage;
  private Random randomint;

  public FireSensor(String location) {
    this.location = location;
    this.sensorType = "Fire_sensor";
    this.batteryPercentage = 100;
    randomint = new Random();
    //randomint.setSeed(1); // not sure if I need this or not. Will give a consistent result?
  }

  /**
   * Raises an alarm 5% of the time it is called, and drains 10% battery between each poll
   *
   * @return true 5% of the time
   * Assume that the sensor can't be triggered if the battery percentage is zero
   */
  @Override
  public boolean isTriggered() {
    if (this.getBatteryPercentage() == 0) return false;
    else {
      batteryPercentage -= 10;
      return randomint.nextInt(100) <= 5;
    }
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public String getSensorType() {
    return sensorType;
  }

  @Override
  public double getBatteryPercentage() {
    return batteryPercentage;
  }

}
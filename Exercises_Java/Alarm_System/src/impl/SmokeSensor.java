package impl;

import java.util.Random;

public class SmokeSensor implements HazardSensor {

  private String location;
  private String sensorType;
  private double batteryPercentage;
  private Random randomint;

  public SmokeSensor(String location) {
    this.location = location;
    this.sensorType = "Smoke_sensor";
    this.batteryPercentage = 100;
    randomint = new Random();
    //randomint.setSeed(2);
  }

  /**
   * Raises an alarm 10% of the time it is called, and drains 20% battery between each poll
   *
   * @return true 10% of the time
   * Assume that the sensor can't be triggered if the battery percentage is zero
   */
  @Override
  public boolean isTriggered() {
    if (this.getBatteryPercentage() == 0) return false;
    else {
      batteryPercentage -= 20;
      return randomint.nextInt(100) <= 10;
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
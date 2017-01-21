import java.util.Random;

public class FireSensor implements Sensor {

  private String location;
  private String sensorType;
  private double batteryPercentage;
  private Random randomint;

  public FireSensor() {
    this.location = location;
    this.sensorType = "Fire sensor";
    this.batteryPercentage = 100;
    randomint = new Random();
    randomint.setSeed(1); // not sure if I need this or not. Will give a consistent result?
  }

  public void checkRandomNumber() {
    int count = 0;
    for (int i = 0; i < 1000; i++) {
      System.out.println(randomint.nextInt(100) <= 5);
    }
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
      //Random randomint = new Random();
      // randomint.setSeed(1); use for testing
      return randomint.nextInt(100) <= 5;
    }
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public String getSensorType() {
    return null;
  }

  @Override
  public double getBatteryPercentage() {
    return -1;
  }

  public static void main(String[] args) {
    FireSensor fireSensor = new FireSensor();
    fireSensor.checkRandomNumber();
  }

}
package impl;

import java.io.IOException;
import java.util.Scanner;

public class App {
  private static final String EXIT = "exit";
  private static final String POLL = "poll";
  
  public static void main(String[] args) throws IOException {
    ControlUnit controlUnit = new ControlUnit();

    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals(EXIT)) {
      System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
      input = scanner.nextLine();
      if (input.equals(POLL)) {
        controlUnit.pollSensors();
      }
    }
  }
}

/**
 * Q6. A new use case! The alarm system now consists of hazard sensors (fire and smoke) and security sensors (motion and heat)
 * Therefore we need a way to distinguish between the SecuritySensor sensor and the HazardSensor.
 * SecuritySensor inherits from the Sensor interface.
 * SecuritySensor types of sensor don't run on battery so now the getBatteryPercentage method is redundant for a whole set
 * of sensors, the SecuritySensors. Also, the isTriggered() method now needs to be changed too because this will break for
 * sensors without batteries (could be overridden).
 * This violates the O of SOLID (Open-Closed Principle), which states that code entities should be open for extension,
 * but closed for modification. In other words, we should write a class that does what it needs to do flawlessly
 * without assuming that people can come in and change it later. It should be closed for modification but can be
 * extended, by for example, inheriting from it or overriding methods and extending certain behaviours.
 *
 * Therefore we need a new interface: SecuritySensor and HazardSensor, which extend the Sensor interface
 * (remember Meeting, PastMeeting and FutureMeeting from ContactManager)
 * Take the getBatteryPercentage() method out of Sensor
 * then interface SecuritySensor extends Sensor; and classes MotionSensor and HeatSensor implement SecuritySensor
 * and interface HazardSensor extends Sensor; and classes FireSensor and SmokeSensor implement HazardSensor.
 * HazardSensor neeeds a new method compared to Sensor, which is getBatteryPercentage, and we'll take that method out
 * of interface Sensor
 */
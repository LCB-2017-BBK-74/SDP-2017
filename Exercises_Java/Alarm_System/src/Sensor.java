public interface Sensor {
  boolean isTriggered();
    // returns true/ false for whether the sensor is triggered or not.
    // Different sensors have different rules applied to them

  String getLocation();
    // returns a description of the location of the sensor such as Lobby 1st Floor or Auditorium

  String getSensorType();
    // returns a textual description of the sensor type such as "Fire sensor" or "Smoke sensor"

  double getBatteryPercentage();
    // Returns a number between 1 and 100 where 0 is empty and 100 is fully charged
}

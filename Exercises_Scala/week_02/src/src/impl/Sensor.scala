package impl

// Define trait Sensor with functions isTriggered, getLocation, getSensorType and getBatteryPercentage
// This trait will be extended by trait HazardSensor and SecuritySensor

trait Sensor {

  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

}

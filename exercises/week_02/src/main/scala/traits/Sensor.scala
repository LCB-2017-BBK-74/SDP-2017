package traits

/**
  * Created by lucieburgess on 14/05/2017.
  */
trait Sensor {

  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

}

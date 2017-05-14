package mediator

class Sensor {

  def checkTemperature(temp: Int): Boolean = {
    println(s"Temperature has reached $temp")
    println(s"Temperature is set to $temp")
    true
  }
}
package q6_anonymous

/**
  * Created by lucieburgess on 31/05/2017.
  */
object Temperature extends App {

  val between = (temp: Double, low: Double, high: Double) => (temp >= low && temp <= high)

  def checkTemp: Boolean = between(70.0, 80.0, 90.0)
  println(checkTemp.toString)

  def checkTempAgain: Boolean = between(70.0, 60.0, 90.0)
  println(checkTempAgain.toString)

}


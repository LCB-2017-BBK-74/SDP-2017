import java.io.IOException
import java.util.Scanner

import sensors.{FireSensor, SmokeSensor, MotionSensor}

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  val fs1 = new FireSensor("Auditorium")
  val fs2 = new FireSensor("Lobby")
  val ss1 = new SmokeSensor("Auditorium")
  val ss2 = new SmokeSensor("Lobby")
  val ms1 = new MotionSensor("Auditorium")
  val ms2 = new MotionSensor("Lobby")

  @throws[IOException]
  def main(args: Array[String]) {
    val cu = new ControlUnit
    cu.configureSensor(fs1)
    cu.configureSensor(fs2)
    cu.configureSensor(ss1)
    cu.configureSensor(ss2)

    val scu = new SecurityControlUnit
    scu.configureSensor(ms1)
    scu.configureSensor(ms2)

    val scanner = new Scanner(System.in)
    var input = ""
    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        cu.pollSensors()
        scu.pollSensors()
      }
    }
  }
}

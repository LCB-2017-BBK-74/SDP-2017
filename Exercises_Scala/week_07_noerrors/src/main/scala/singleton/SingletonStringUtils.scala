package singleton

/**
  * Created by lucieburgess on 14/04/2017.
  * From Scala Design Patterns by Ivan Nikolov
  */
class SingletonStringUtils {
}

object SingletonStringUtils {
  def countNumberOfSpaces(text: String) : Int = text.split("\\s+").length - 1
}

object SingletonStringUtilsMain {
  def main (args: Array[String]) :Unit = {
    val sentence = "Today is Good Friday and I'm learning some Scala"
    println(s"The number of spaces in the sentence is ${SingletonStringUtils.countNumberOfSpaces(sentence)}")
  }
}

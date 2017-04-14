import factory.{ConcreteDuckCreator, DuckCreator}
import scala.io.StdIn.readLine

/**
  * Created by lucieburgess on 14/04/2017.
  */
object DuckCreatorTest {

  def main (args: Array[String]) :Unit = {

    val duckFactory :DuckCreator = new ConcreteDuckCreator
    val input = readLine("Please enter the type of duck you wish to make M/R: ")

    if (input equals "M") {
      duckFactory.makeADuck("Mallard").duck
      println("Your duck has been made!")
    }
    else if (input equals "R") {
      duckFactory.makeADuck("RubberDuck").duck
      println("Your duck has been made!")
    }
    else println("Sorry,a duck of that type does not exist in this factory")
  }
}



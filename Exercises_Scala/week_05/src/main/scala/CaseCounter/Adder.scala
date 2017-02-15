package CaseCounter

/**
  * Created by lucieburgess on 14/02/2017.
  */
class Adder(amount: Int) {

  def add (in: Int) = amount + in

}

object Main extends App {
  var result = new Adder(9).add(3)
  println(result)
}


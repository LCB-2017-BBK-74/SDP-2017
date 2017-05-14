package CaseCounter

/**
  * Created by lucieburgess on 14/02/2017.
  */
class Adder(var amount: Int = 0) {

  def add (in: Int) = amount + in

}

object Main extends App {
  var res = new Adder().add(3)
  println(res) // should be 3
  var res2 = new Adder(9).add(3)
  println(res2) // should be 12
  var res3 = new Adder(5)
  println(res3) //should be 5
}


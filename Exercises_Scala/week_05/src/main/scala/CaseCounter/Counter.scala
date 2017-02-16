package CaseCounter

/**
  * Created by lucieburgess on 14/02/2017.
  * Case classes: constructor paramaters are val by default
  * Counter parameter count is val by default.
  */
case class Counter (val count: Int = 0) {

  def inc(interval: Int = 1) :Counter = {
    this.copy(count = count + interval) // copy gives a new instance of Counter so don't need to return new Counter
  }

  def dec(interval: Int = 1) :Counter = {
    this.copy(count = count - interval)
  }

  /**
    *  This method accepts an Adder and returns a new Counter with the results of applying Adder.add to count
    */
  def adjust(adder: Adder) :Counter = {
    this.copy(count = adder.add(count))
  }

}

object CounterMain extends App {
  val counter = Counter(10).inc().count
  println(counter) //should be 11
  val counter2 = Counter(10).inc(5).count
  println(counter2) // should be 15
  val counter3 = Counter().dec(5).count
  println(counter3) //should be -5
  val adder = new Adder(7)
  println(adder.amount)
  val counter4 = Counter().adjust(adder).count
  println(counter4) //should be 7
}


object AdderMain extends App {
  val adder: Adder = new Adder(7)
  var res = new Counter(10).inc().dec().inc().inc().adjust(adder).count
  println(res) // should be 19
}

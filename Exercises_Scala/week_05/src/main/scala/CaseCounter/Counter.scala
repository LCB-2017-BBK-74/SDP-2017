package CaseCounter

/**
  * Created by lucieburgess on 14/02/2017.
  */
case class Counter (var count: Int) {

  def inc(interval: Int = 1) :Counter = {
    this.copy(count = count + interval) //interval will be 1 by default?
    Counter(count)
  }

  def dec(interval: Int = 1) :Counter = {
    this.copy(count = count - interval) //interval will be 1 by default?
    Counter(count)
  }

  /**
    *  This method accepts an Adder and returns a Counter with the results of applying Adder to count
    */
  def adjust(adder: Adder, n: Int) :Counter = {
    var addedcount = adder.add(n)
    Counter(addedcount)
  }

}

object CounterMain extends App {
  val adder: Adder = new Adder(10)
  var res = new Counter(10).inc(0).dec(0).inc(0).inc(0).adjust(adder,2).count
  println(res)
}

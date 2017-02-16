package Counter

/**
  * Created by lucieburgess on 11/02/2017.
  */
class Counter(var count :Int = 0) {

  // NB. specifying the interval value has the effect of giving inc a default parameter of interval = 1.
  // But now we can also specify inc(2) or dec(3), for example.
  // To use the default value call inc()
  // Initialised Counter to a default value of zero

  def inc (interval: Int = 1) :Counter = {
    count = count + interval
    new Counter(count)
  }

  def dec (interval: Int = 1) :Counter = {
    count = count - interval
    new Counter(count)
  }

}

object Main extends App {
  var res = new Counter(10).inc(2).dec(2).inc(2).inc(2).count
  println(res) //should be 14
  var res2 = new Counter(4).inc(3).dec(2).inc(7).count
  println(res2) //should be 12
  var res3 = new Counter().inc(5).count// should be 5
  println(res3)
  var res4 = new Counter().inc().inc().count // should be 2
  println(res4)

}

/**
  * Created by lucieburgess on 11/02/2017.
  */
class Counter(var count :Int) {

  // NB. specifying the interval value has the effect of giving inc a default parameter of interval = 1.
  // But now we can also specify inc(2) or dec(3), for example.
  // To use the default value call inc()

  def inc (interval: Int = 1) :Counter = {
    count = count + interval
    new Counter(count)
  }

  def dec (interval: Int = 1) :Counter = {
    count = count - interval
    new Counter(count)
  }

}

object main extends App {
  var res = new Counter(10).inc(2).dec(2).inc(2).inc(2).count
  println(res)
}
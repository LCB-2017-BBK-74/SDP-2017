/**
  * Created by lucieburgess on 11/02/2017.
  */
class Counter(start :Int) {

  var count = start

  def inc :Counter = {
    count = count +1
    new Counter(count)
  }

  def dec :Counter = {
    count = count -1
    new Counter(count)
  }

}

object main extends App {
  var res = new Counter(10).inc.dec.inc.inc.count
  println(res)
}
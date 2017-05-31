package q2_simpletime

/**
  * Created by lucieburgess on 31/05/2017.
  */
class SimpleTime(val hours: Int, val minutes: Int) {

}

object simple_time extends App {
  val t = new SimpleTime(hours = 5, minutes = 30)

  println(t.hours)
  println(t.minutes)

}

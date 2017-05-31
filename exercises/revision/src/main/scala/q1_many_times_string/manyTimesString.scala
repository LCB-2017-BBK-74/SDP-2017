package q1_many_times_string

/**
  * Created by lucieburgess on 31/05/2017.
  */
object manyTimesString extends App {

  def manyTimesString(message: String, n:Int) :String = {
    if (n <= 0) ""
    else if (n == 1) message
    else message + manyTimesString(message, n-1)
  }

  val m1 = manyTimesString("abc",3)
  println(m1)
  assert("abcabcabc" == m1, "Your message here")

  val m2 = manyTimesString("123", 2)
  println(m2)
  assert("123123" == m2, "Your message here")

}

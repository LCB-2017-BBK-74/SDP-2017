package streams

/**
  * Created by lucieburgess on 05/06/2017.
  */
object StreamsApp extends App {

  def sumSquares(x:Int) :Int = {
    Stream.from(1) take x map (y=> y*y) reduce(_+_)
  }

  def squares(x: Int) :Stream[Int] = {
    (x * x) #:: squares(x + 1)
  }

  println("sum of squares to 10: " + sumSquares(10))

  squares(1) take 5 foreach println

  println(Stream.from(1) take 10 reduce(_+_))

}

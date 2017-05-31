package q7_reduce

/**
  * Created by lucieburgess on 31/05/2017.
  */
object Reduce extends App {

  def sumIt(ls: List[Int]) = {
    ls.reduce(_+_)
  }

  def sumItAgain(ls: List[String]) = {
    ls.reduce((x,y) => (x + y))
  }

  val ls: List[Int] = List(1,2,3)
  println(sumIt(List(1,2,3)))
  println(sumIt(List(45,45,45,60)))
  println(sumItAgain(List("Apple","Orange","Banana")))

}

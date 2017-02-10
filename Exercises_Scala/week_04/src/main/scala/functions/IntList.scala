package functions

/**
  * Created by lucieburgess on 09/02/2017.
  */
sealed trait IntList {

//  def length: Int =
//    this match {
//      case End => 0
//      case Pair(hd, tl) => 1 + tl.length //(1,tl.length)
//    }

  def length: Int = abstraction(0, (_, tl) => 1 + tl)

//  def product: Int =
//    this match {
//      case End => 1
//      case Pair(hd, tl) => hd * tl.product //(hd,tl.product)
//    }

  def product: Int = abstraction(1, (hd,tl) => (hd * tl))

//  def sum: Int =
//    this match {
//      case End => 0
//      case Pair(hd, tl) => hd + tl.sum // (hd,tl.sum)
//    }

  def sum: Int = abstraction (0, (hd,tl) => (hd + tl))


  def abstraction(end: Int, f: (Int,Int) => Int): Int = //(Int, Int) => Int
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.abstraction(end,f))
    }

  def double: IntList =
    this match {
      case End => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
}

final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

// val example = Pair(1, Pair(2, Pair(3, End)))
package q8_2016

import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 05/06/2017.
  * Q8 2016 from the exam paper
  */
object Functions {

  /**
    *
    * @param s  the string to check for in the list
    * @param xs the list to be checked
    * @return Some(list) where the string is not present in the argument list
    *         Take the list and append the values which are not s to a new list
    */
  def allExceptOption(s: String, xs: List[String]): Option[List[String]] = {
    xs match {
      case Nil => None // there is an empty list
      case h::t =>
        if (h == s) Some(t) // if the string is the head, return the tail
      //the string is not in the head but could be in the tail
        else allExceptOption(s, t) match {
        case None => None //the string is not in the list
        case Some(t) => Some(h :: t) // create a new list with the original head and the tail appended
      }
    }
  }

  def allExceptOption2(s:String, xs: List[String]): Option[List[String]] = {
    xs match {
      case Nil => None
      case x::xs =>
        if (x equals s) Some(xs)
        else {
          allExceptOption2(s, xs) match {
            case None => None
            case Some(y) => Some (x :: y)
          }
        }
    }
  }

//  /** Using filter - which the question says you can't do*/
//  def getSubstitutions0(s:String, substitutions: List[List[String]]): List[String] = (s, substitutions) match {
//    case (_, Nil) => List[String]()
//    case (s, substitutions) => {
//      val newList = List[String]()
//      substitutions.foldLeft(newList)(subs => allExceptOption(s, subs))
  //    substitutions.flatten.filter(x => !(x==s))
//    }
//  }


  def getSubstitutions1(s: String, substitutions: List[List[String]]): List[String] = substitutions match {
    case Nil => Nil
    case h::t => allExceptOption(s,h) match { //check the head first for the String. If not found, look in the tail.
      case None => getSubstitutions1(s,t)
      case Some(y) => y ++ getSubstitutions1(s,t)
    }
  }

}

object FunctionsMain extends App {

  val ls = List("Fred", "Knife", "Butter")
  println(Functions.allExceptOption("item", ls)).toString
  println(Functions.allExceptOption("Knife", ls)).toString

  val ls2 = List(List("Fred"),List("Fred", "Frederick"), List("Elizabeth, Betty"), List("Freddie", "Fred", "F"))

  println(Functions.getSubstitutions1("Fred",ls2))

}
package generics

/**
  * Created by lucieburgess on 24/05/2017.
  */
class ListFunctions {

  // length of a list of Ints
  def ilength(ls: List[Int]): Int = ls match {
    case Nil => 0
    case h :: t => 1 + ilength(t)
  }

  // length of a list of Strings
  def slength(ls: List[String]): Int = ls match {
    case Nil => 0
    case h :: t => 1 + slength(t)
  }

  //generic length of a list of Type[A]
  def length[A](ls: List[A]): Int = ls match {
    case Nil => 0
    case h :: t => 1 + length(t)
  }

  /**
    * Higher order functions on Lists: starting with map
    */

  // increments all the values in a list by 1
  def incrs(ls: List[Int]) :List[Int] = ls match {
      case Nil => Nil
      case h::t => h+1::incrs(t)
    }
  
  // calculates the length of each string in a list
  def slengths(ls: List[String]) :List[Int] = ls match {
    case Nil => Nil
    case h::t => h.length :: slengths(t)
  }
  
  //doubles all the numbers in a list
  def doubler(ls: List[Int]) :List[Int] = ls match {
    case Nil => Nil
    case h::t => h*2 :: doubler(t)
  }

  def negates(ls: List[Int]) :List[Int] = ls match {
    case Nil => Nil
    case h::t => -h :: negates(t)
  }
  
  // Each of these functions simply performs a different function on the head of the list
  // Make this generic:

  def f(n: Int): Int = n*2
  def doubles(ls: List[Int]) :List[Int] = ls match {
    case Nil => Nil
    case h::t => f(h) :: doubles(t)
  }

  //Refactoring the other functions:
  def func1(n:Int) :Int = n+1

  def func2(s:String) :Int = s.length

  def func3(n:Int) :Int = -n

  //Then we can apply each of these as a map:
  def map(f: Int => Int, ls: List[Int]): List[Int] = ls match {
    case Nil => Nil
    case h::t => f(h)::map(f,t)
  }

  // the n:Int style function doesn't work for the String version, func2. So we can parameterise out A=>B e.g. String=> Int:
  def map2[A,B] (f: A=> B, ls: List[A]) :List[B] = ls match {
    case Nil => Nil
    case h::t => f(h):: map2[A,B](f,t)
  }

  /**
    * Filtering. These functions are known as 'higher order functions' - they take other functions.
    */

  def filterEven(ls: List[Int]): List[Int] = ls match {
    case Nil => Nil
    case h::t => (h%2 == 0) match {
      case true => h :: filterEven(t)
      case false => filterEven(t)
    }
  }

  def filter[A](f: A => Boolean, ls: List[A]) : List[A] = ls match {
    case Nil => Nil
    case h::t => f(h) match {
      case true => h::filter(f,t)
      case false => filter(f,t)
    }
  }

}
  
package list_methods

import apple.laf.JRSUIConstants.NothingToScroll

/**
  * Created by lucieburgess on 05/06/2017.
  */
//sealed trait FuncsList[+A]
//case class Cons[+A](h: A, tail :FuncsList[A]) extends FuncsList[A]
//case object Nil extends FuncsList[Nothing]

/**
  * FuncsList companion object. Contains functions for creating and working with lists.
  */
object FuncsList {

  /** Appends list to the right of xs, returning FuncsList[A] */
  def append[A](xs: List[A], ys: List[A]) :List[A] = xs match {
    case Nil => ys
    case h::Nil => h::ys
    case h::t => h::append(t,ys)
  }

  /** returns the nth element of xs. Throws an exception if there is no element at that index
    * NB. need an error message rather than Nil as this function returns Nil
    */
  def apply[A](xs: List[A], n:Int) :A = xs match {
    case Nil => sys.error("Can't call apply on an empty list")
    case h::t => n match {
      case 0 => h
      case 1 => apply(t,0)
      case _ => apply(t,(n-1))
    }
  }

/** returns a List[A] that contains all elements from xs except the first n ones */
  def drop[A](xs: List[A], n:Int): List[A] = xs match {
    case Nil => Nil
    case h :: t => {
      if (n <= 0) h :: t
      if (n == 1) t
      if (n >= xs.length) Nil
      else drop(t, n - 1)
    }
  }

  /** returns all elements from xs that satisfy the predicate p as a List[A] */
  def filter[A](xs: List[A])(p:A => Boolean) :List[A] = xs match {
    case Nil => Nil
    case h::t => {
      if (p(h)) h :: filter(t)(p)
      else filter(t)(p)
    }
  }

  def filter2[A](xs: List[A])(p:A => Boolean) :List[A] = (xs, p) match {
    case (Nil, p) => Nil
    case (h::t, p) if p(h) => h::filter2(t)(p)
    case (h::t, p) if !p(h) => filter2(t)(p)
  }

  def map[A,B](xs: List[A])(f:A => B) :List[B] = (xs, f) match {
    case (Nil, f) => Nil
    case (h::t, f) => f(h)::map(t)(f)
  }

  def flatten[A](xs: List[A]) :List[Any] = xs match {
    case Nil => Nil
    case (h: List[_]) :: t => flatten(h) ++ flatten(t)
    case h :: t => h :: flatten(t)
  }

  def flatten2[A](xs: List[List[A]]) :List[A] = xs match {
    case Nil => Nil
    case h::t => h ::: flatten2(t)

  }

  def flatMap[A,B](xs: List[A])(f:A => B) :List[Any] = xs match {
    case Nil => Nil
    case h::t => flatten(map(xs)(f))
  }

  def zip[A,B](xs: List[A], ys: List[B]) :List[Any] = (xs, ys) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (hx::tx, hy::ty) => hx::hy :: zip(tx,ty)
  }

}


object ListMain extends App {

  val ls = List(1,2,3,4,5,6,7,8,9,10)
  val another = List(5,6,7,8)

  //test apply
  println(FuncsList.apply(ls,0))
  println(FuncsList.apply(ls,3))

  //test append
  val appendedList = FuncsList.append(ls,another)
  println(appendedList.toString)

  //test drop
  val res = FuncsList.drop(ls,4)
  println(res)

  //test filter
  val filteredList = FuncsList.filter(ls)(x => x%2 == 0)
  println(filteredList)

  val filteredList2 = FuncsList.filter2(ls)(x => x%2 == 0)
  println(filteredList)

  //test map
  val mappedList = FuncsList.map(ls)(x => x.toDouble)
  println(mappedList)

  //test flatten
  val listy = List(List(1,2,3), List(13,14,15))
  println(listy)

  println("This is a test")
  println(FuncsList.flatten2(listy))
  println(listy.flatten) //uses built-in flatten method, not FuncsList flatten


}


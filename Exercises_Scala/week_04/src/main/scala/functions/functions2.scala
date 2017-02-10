package functions

/**
  * Created by lucieburgess on 07/02/2017.
  */
object Funcs2 {

  sealed trait List[+A]

  // A data constructor for the empty list.
  // Nothing is a subtype of all types - so, Nil can be considered
  // a List[Int], List[String], etc. which is important for our
  // definition.
  case object Nil extends List[Nothing]

  // A data constructor for representing a non-empty list
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  //The list companion object.
  object List {

    /**
      * Helper method apply which is somehow needed to create a non-generic List/ Not sure why??
      * @param as
      * @tparam A
      * @return
      */
    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
    }

    /**
      * Helper method to calculate length of list
      *
      * @param ls
      * @tparam A
      * @return the length of the list as an Int
      */
    def length[A](ls: List[A]): Int = ls match {
      case Nil => 0
      case Cons(h, t) => 1 + length(t) //recursively call a function which calculates the simplelength of the list
    }

    /**
      * Helper method to create sum if list is a list of Ints
      *
      * @param ints
      * @return the sum of the list elements as an Int
      */
    def sumInt(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(h, t) => h + sumInt(t) //sum the list if A is a list of integers
    }

    /**
      * tail that takes a list and removes the first element, returning the rest
      * of the list (i.e. the tail)
      * Calling tail on an empty list throws an IllegalArgumentException.
      *
      * @param ls : List[A] the list to process
      * @return A list containing all but the first element of ls
      */

    def tail[A](ls: List[A]): List[A] = ls match {
      case Nil => throw new IllegalArgumentException
      case Cons(h, t) => t
    }

    /**
      * setHead replaces the first value in a list with a given value. If the
      * list is empty, it adds the value to the front of the list.
      *
      * @param ls : List[A] the list to be changed
      * @param a  : A the value that will replace the head of ls
      * @return a list whose head is 'a' and whose tail is all but the first
      *         element of ls.
      **/
    def setHead[A](ls: List[A], a: A): List[A] = ls match {
      case Nil => Cons(a, Nil)
      case Cons(h, t) => Cons(a, t)
    }

    /**
      * drop removes n elements from the given list. If n is greater than the
      * simplelength of the list, the function returns an empty list.
      *
      * @param ls : List[A] the list to be changed
      * @param n  : Int the number of elements to drop.
      * @return a list with the first n elements of ls removed, or an empty list.
      */
    def drop[A](ls: List[A], n: Int): List[A] = ls match {
      case Nil => throw new IllegalArgumentException("Can't call drop on an empty list")
      case Cons(h, t) => {
        if (n <= 0) Cons(h, t) else if (n > length(ls)) Nil else if (n == 1) t else drop(t, n - 1)
      }
    }

    /**
      * init takes a list and removes the last element.
      * Like tail, init(Nil) throws an IllegalArgumentException.
      * Implement this function recursively, preferably using match.
      *
      * @param ls : List[A] the list to be changed.
      * @return a list with the last element of ls removed.
      */
    def init[A](ls: List[A]): List[A] = ls match {
      case Nil => throw new IllegalArgumentException("Can't call init on an empty list")
      case Cons(h, t) =>
        if (length(ls) == 1) Nil
        else if (length(ls) == 2) Cons(h, Nil)
        else Cons(h, init(t))
    }

  }

  def main(args: Array[String]): Unit = {
    val test = List(1,2,3,4)
    List.tail(test)
  }

}
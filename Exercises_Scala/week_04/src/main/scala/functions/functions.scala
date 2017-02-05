package functions

import scala.annotation._

object Funcs {

  // FUNCTIONAL BASICS:


//  sealed trait List[+A]
//
//  // A data constructor for the empty list.
//  // Nothing is a subtype of all types - so, Nil can be considered
//  // a List[Int], List[String], etc. which is important for our
//  // definition.
//  case object Nil extends List[Nothing]
//
//  // A data constructor for representing a non-empty list.
//  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  // The list companion object.
  object List {

    def length[A](ls: List[A]): Int = ls match {
      case Nil => 0
      case h::t => 1 + length(t) //recursively call a function which calculates the simplelength of the list
    }

    def simpleSum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case h::t => h + simpleSum(t) //sum the list if A is a list of integers
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
      case h::t => t
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
    case Nil => a::Nil
    case h::t => a::t
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
    case h :: t => {
      if (n <= 0) h :: t else if (n > ls.length) Nil else if (n == 1) t else drop(t, n - 1)
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
    case h::t => if (ls.length eq 1) Nil else h::init(t)
    //case Cons(h,t) => if (simplelength(ls) == 2) Cons (h, Nil) else if (simplelength(ls) == 1) Nil else Cons (h, init(t))
  }

  // LIST FOLDING

  /*
   * foldLeft reduces a list down to a single value by iteratively applying a
   * function over the elements of the list and carrying the cumulative result
   * along. It starts from the head and moves to the tail.
   * We've provided the signature for foldLeft below.
   * @param ls: List[A] the list to be reduced.
   * @param z: B the initial value
   * @param f: (B, A) => B the binary function applied to the elements of the
   * list and the cumulative value.
   * @return the final value.
   */

  @tailrec def foldLeft[A, B](list: List[A], acc: B)(f: (A, B) => B): B = list match {
      case Nil => acc
      case h::t => foldLeft(t, f(h, acc))(f)
  }

  //Iterative version of foldLeft which does not use recursion
  def foldLeftIt[A, B] (list: List[A], z: B)(f: (A,B) => B): B = list match {
    case Nil => z
    case h::t => {
      var acc = z
      var remainder = list
      while (remainder.length ne 0) {
        acc = f(h, acc)
        remainder = tail(list)
      }
      acc
    }
  }

    /**
      * foldRight implementation: starts at the tail and moves to the head - just for fun, not required
      * @param ls the list to be acted on
      * @param z the accumulator, of type B
      * @param f the function to be applied to each element of the list
      * @tparam A the type of the List[A]
      * @tparam B the type of the accumulator[B]
      * @return
      */
    def foldRight[A, B](ls: List[A], z: B)(f: (A, B) => B): B = ls match {
      case Nil => z
      case h::t => f(h, foldRight(t,z)(f))
    }

    /**
    * Use your implementation of foldLeft to implement these functions:
    * - sum: Takes a List[Double] and produces the sum of all elements
    * - product: Takes a List[Double] and produces the product of all elements
    * - length: Takes a List[A] and finds the length of the list.
    * - reverse: Takes a List[A] and produces a new list with the elements of
    * the first list in reverse order. That is, reverse(List(1,2,3)) =
    * List(3,2,1).
    * - flatten: Takes a List[List[A]] and produces a List[A] by joining all
    * the sublists into one long list. For example, flatten(List(List(1,2,3),
    * List(4,5,6))) produces List(1,2,3,4,5,6).
    */
  def sum(ls: List[Double]): Double = foldLeft(ls,0.0)((x,y) => x + y)

  def product(ls: List[Double]): Double = foldLeft(ls,1.0)((x,y) => x * y)

  def length[A](ls: List[A]): Int = foldLeft(ls,0)((x,y) => 1)

  def reverse[A](ls: List[A]): List[A] = foldLeft(ls, List[A])((x,y) => y.::(List[A])) // why isn't :: operator working?

  def flatten[A](ls: List[List[A]]): List[A] = foldLeft(ls, List[A])((x,y) => x.::(List[A]) ) // add each list to an empty list, concatenating all the lists

  // MAP AND FILTER

  /**
    * map applies a function to a list, producing a new list of the functions'
    * values.
    * As with the other functions, implement this recursively.
    *
    * @param ls : List[A] the list to be changed.
    * @param f  : A => B the function to be applied to each element of the input.
    * @return the resulting list from applying f to each element of ls.
    */
  def map[A, B](ls: List[A])(f: A => B): List[B] = ls match {
    case Nil => throw new IllegalArgumentException("Can't call map on an empty list")
    //case Cons(h,t) => foldLeft(t, f(h, acc))(f)
      // case Cons(h,t => map(t,f(h))
    case h::t => {
      if (length(ls) eq 1) f(h)::Nil // again would like to use notation f(h)::Nil
      else map(t)(f)
    }
  }

  /**
    * filter removes all elements from a list for which a given predicate
    * returns false.
    * As usual, this should be recursive.
    *
    * @param ls : List[A] the list to be filtered.
    * @param f  : A => Boolean the predicate
    * @return the filtered list.
    */
  def filter[A](ls: List[A])(f: A => Boolean): List[A] = ls match {
    case Nil => throw new IllegalArgumentException("Can't call filter on an empty list")
    case h::t => {
      if (ls.length eq 1) {
        if (f(h)) h::Nil else drop(ls,1)
      }
      else filter(t)(f)
    }
  }

  /**
    * flatMap is very similar to map. However, the map function returns a List,
    * and flatMap flattens all of the resulting lists into one.
    *
    * @param ls : List[A] the list to be changed.
    * @param f  : A => List[B] the function to be applied.
    * @return a List[B] containing the flattened results of applying f to all
    *         elements of ls.
    */
  def flatMap[A, B](ls: List[A])(f: A => List[B]): List[B] = ls match {
    case Nil => throw new IllegalArgumentException("You cannot apply flatMap to an empty list")
    case h::t => foldLeft(map(ls)(f),List[A])((x,y) => x.::(List[A])) // maps ls using f then flattens by appending each element to an empty list
  }

  // COMBINING FUNCTIONS

  /**
    * maxAverage takes a List[(Double,Double)] (a list of pairs of real
    * numbers) and returns the average value of the largest value in each pair.
    * For example, the maxAverage of List((1,4), (8, 0)) is (8 + 4)/2 = 6.0.
    * You must use the methods you wrote above, particularly map and foldLeft.
    *
    * @param ls : List[(Double,Double)] a list of pairs of real numbers, whose
    *           simplelength is greater than 0.
    * @return the average value of the largest values in the pairs.
    */
  def maxAverage(ls: List[(Double, Double)]): Double = ???

  /**
    * variance takes a List[Double] and calculates the squared distance
    * of each value from the mean. This is the *variance*, as used in
    * statistics.
    * 1) Find the mean M of the input.
    *
    * 2) For each value V in the input, calculate (V - M)^2.
    * 3) Find the variance.
    * Which methods that we've already defined can you use? (At least one!)
    * @param ls     : List[Double] a list of values, whose simplelength is greater than 0.
    * @return the variance of the input.
    */
  def variance(ls: List[Double]): Double = ???

  }
}

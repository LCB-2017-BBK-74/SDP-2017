package basics

import scala.collection.JavaConverters._

/**
* packages are logical namespaces not physical namespaces. 
*/

/**
  * @author LucieCBurgess 26/01/2017
 * This is a singleton object containing the functions you need
 * to implement. Please make sure to read the documentation associated
 * with each function and provide a sensible implementation.
 */

object ScalaBasics {

  /**
   * Write a function called add that takes two Int parameters
   * and returns their sum.
   *
   * @param a operand a
   * @param b operand b
   * @return the sum
   */
  def add(a: Int, b: Int): Int = a + b
  
  /**
   * Write a function that returns the inclusive Range from start to end.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param start the start of the range
   * @param end the end of the range
   * @return the inclusive Range from start to end
   */
  def inRange(start: Int, end: Int): Range = {
    var inRange = start.to(end)
    inRange
  }

// ??? is like stubbing out a method

  /**
   * Write a function that returns a Range of n odd integers starting at 1.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param n the number of odd integers in the range
   * @return a Range of odd integers, including the last add integer
    *         NB. .until returns an exclusive range
   */
  def oddRange(n: Int): Range = 1.to(n).by(2)

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a while loop.
   * - You may use both immutable (val) and mutable (var) variables.
   * - You must use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minWhile(r: Array[Int]): Int = {
    var result: Int = r(0)
    // assign to zero element in the array
    var i: Int = 0
    while (i < r.length) {
      if (r(i) <= result) {
        result = r(i)
      }
      i+=1
    }
    result
  }

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop (not for comprehension).
   * - You may use both immutable (val) and mutable (var) variables.
   * - You may not use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minFor(r: Array[Int]): Int = {
    var min: Int = Int.MaxValue
    for(index <- 0 until r.length-1) {
      min = Math.min(r(index), min)
    }
    min
  }

  /**
   * Write a function called minRecursive that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might want to look at the Scaladoc for Array to see some
   * useful methods you can use to solve this.
    * My method works by creating a new array of the minimum of the first 2 numbers and the rest of the array
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minRecursive(r: Array[Int]): Int = {

    if (r.length < 2) r(0)
    else if (r.length <= 2) Math.min(r(0), r(1))

    else minRecursive(Array.concat(Array(Math.min(r(0),r(1))),r.slice(2,r.length)))
  }

  // Quicksort implementation picking the first number of the array - but uses a val declaration
  def minRecursive2(r: Array[Int]) : Int = {
    def sort(r: Array[Int]): Array[Int] = {
      if (r.length <= 1) r
      else {
        val pivot = r(r.length / 2)
        Array.concat(
          sort(r filter (pivot >)),
          r filter (pivot ==),
          sort(r filter (pivot <)))
      }
    }
    r(0)
  }


  // method should be to compare the first two numbers in the array. If the second number is larger than the first,
  // replace the 2nd element with the first element. Then call the function again on the 2nd and 3rd elements of the
  // array, etc.

  /**
   * Return the base 36 equivalent of the BigInt b.
   *
   * HINT: Poke around Scaladoc to find a way of doing this in Scala.
   *
   * @param b a big integer
   * @return the base 36 equivalent
   */
  def base36(b: BigInt): String = b.toString(36)

  /**
   * Splits the String s in half.
   *
   * This function returns a tuple (f, e), where the f is the first
   * half of the string and e is the last half of the string.
   *
   * For example,
   *   splitInHalf("abcdef") => ("abc", "def")
   *   splitInFalf("abcde")  => ("ab", "cde")
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use recursion.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might find something useful in the String and StringOps Scaladoc.
   *
   * @param s the string to split
   * @return the split string as a tuple
    *  dropRight
   */
  def splitInHalf(s: String): (String, String) = {
    if (s.length % 2 == 0) (s.take(s.length / 2), s.takeRight(s.length / 2))
    else (s.take((s.length/2)), s.takeRight((s.length / 2)+1))
  }

  /**
   * Determines if the given string s is a palindrome.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for comprehension.
   * - You may not use any other loops.
   * - You may not use any mutable (var) variables.
   *
   * You should normalize the string s before determining if
   * it is a palindrome. That is, you should not distinguish
   * between upper and lowercase, you should not consider
   * spaces, and you should eliminate the punctuation
   * characters . ? , ; ! - '.
   *
   * HINT: You should consult the Scaladoc for String and
   * StringOps to help you with your solution.
   *
   * @param s the potential palindrome
   * @return true if s is a palindrome; false otherwise
   */
  def isPalindrome(s: String): Boolean = {

    // val upper = for (c <- "hello, world") yield c.toUpper from Scala CookBook

    val normalString = for (c <- s if c.isLetter) yield c.toLower

    normalString equals normalString.reverse
  }


  /**
   * You don't have to complete this one as we've removed it from the list 
   * of required functions.
   *
   * Sum the characters (as integers) provided as arguments to this method.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop
   * - You may use any mutable (var) variables.
   *
   * @param cc 0 or more characters Char* means any number of chars including zero
   * @return the sum of the ASCII integers corresponding with the character.
   */
  def sumChars(cc: Char*): Int = {
    var result: Int = 0
    for (c <- cc) {
      result += c.toInt
    }
    result
  }

  // Using a for comprehension:
  // def sumChars(cc: Char*): Int = for (c <- cc) yield c.toInt.sum


  /**
   * Counts the number of space delimited words in the provided array of strings.
   *
   * This function takes an array of strings that represent lines in a text file.
   * This function must return a Map from String to Int where the String is a
   * word found across all lines and the Int is the number of times that word
   * was seen. For example:
   *
   * wordCount(Array("this is a sentence.", "this is a sentence too!"))
   *
   * would return
   *
   * Map("this" -> 2,
   *     "is" -> 2,
   *     "a" -> 2,
   *     "sentence." -> 1,
   *     "sentence" -> 1,
   *     "too!" -> 1)
   *
   * You may assume that all words are delimited by spaces. You need not worry
   * about punctuation. You can implement this however you wish.
   *
   * @param lines the lines of a text file
   * @return a map from words to the number of times that word was seen
   */
  def wordCounter(lines: Array[String]): Map[String, Int] = {

    lines.flatMap(_.split(" ")).groupBy(word => word).mapValues(_.length)
  }

  //NB. lines(_.split("\\W")) gets rid of the full stop at the end of 'sentence' putting the wrong value in the map

}

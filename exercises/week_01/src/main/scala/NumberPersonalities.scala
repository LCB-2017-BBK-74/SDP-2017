import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 01/02/2017.
  */
object NumberPersonalities {

  val limit = 100

  def main(args: Array[String]): Unit = {
    primeNumberGenerator(1000)
    for (i <- 1 to limit) {
      println(i)
    }

  }

  /**
    * You can test whether a number n is prime by dividing through the numbers 2 to n-1
    * If the modulo for one of these divisors is zero the number is not prime
    * A number which is not prime is called composite
    *
    * @param n the number to be checked whether prime or composite
    * @return true if the number is prime
    */
  def isPrime(n: Int): Boolean = {
    if (n == 1) true
    else if (n == 2) true
    else !(2 to (n - 1)).exists(x => n % x == 0)
  }

  def primeNumberGenerator(m: Int): Unit = {
    for (m <- 1 to m)
      if (isPrime(m)) println(s"$m is a prime!!!")
      else println(s"$m is not a prime number")
  }

  /**
    * Happy and unhappy numbers
    * Square the digits of the number and add the squares
    * If eventually you get to 1, then the number is happy
    * For example 19: 1^2 + 9^2 = 82; 8^2 +2^2 = 64; 6^2 +4^2 = 100; 1^2 +0^2 + 0^2 = 1
    * Every unhappy number eventually gets into the series: 4, 16, 37, 58, 89, 145, 42, 20, 4 ...
    * So if you get any one of these numbers, or 20 followed by 4, you can conclude that the number is unhappy
    * e.g. 4^2 = 16; 1^2 +6^2 = 37; 3^2+7^2 = 58 .....
    * To get the last digit of a number n, compute n % 10. i.e. 1024 % 10 == 4. You can subsequently discard the digit
    * by doing an integer division with 10
    * 1024 mod 10 = 4; 1024/10 = 102; 102 mod 10 = 2; 102/10 = 10; 10 mod 10 = 0; 10/10 = 1; 1%10 = 1; 1/10 = 0 (stop)
    */

}

  object happyNumbers extends App {

    def getDigits(n: Int): ListBuffer[Int] = {

      var buf = new ListBuffer[Int]()
      var number = n
      while (number > 0) {
        buf = (number % 10) +: buf
        number = number / 10
      }
      buf
    }

    // @test println(getDigits(1024).mkString(","))

    def squareDigits(digits: ListBuffer[Int]): Int = {
      var res = digits.map(x => x*x).sum //foldLeft(0)((x,y) => (x+y))
      res
    }

    // @test println(squareDigits(getDigits(1024)))

    def isHappy(n: Int): Boolean = {

      var res = -1
      if (n == 1) true
      else if (n == 4) false
      else {
        res = squareDigits(getDigits(n))
        isHappy(res)
      }
    }

    println(isHappy(19)) //should be true
    println(isHappy(1)) // should be true
    println(isHappy(4)) // should be false
    println(isHappy(1024)) // should be false: 21, 5, 25, 29, 85, 89, 145, ...
    println(isHappy(6)) //should be false
  }

/**
  * Triangular numbers get into the series: 1, 3, 6, 10, 15....
  * Programming note: A number is triangular if you subtract 1,2,3,4 ... and eventually get zero.
  */

object triangularNumbers extends App {

  def isTriangular(n: Int): Boolean = {
    n match {
      case n if n < 1 => false
      case n => triangle(n, 1, (counter: Int) => counter + 1 )
    }
  }

  def triangle(n:Int, counter:Int, f:Int => Int): Boolean = (n, counter) match {
    case _ if n-counter == 0 => true
    case _ if n-counter < 0 => false
    case _ => triangle(n-counter, f(counter), f)
  }

  println(isTriangular(1)) //should be true
  println(isTriangular(3)) //should be true
  println(isTriangular(6)) //should be true
  println(isTriangular(10)) //should be true
  println(isTriangular(15)) //should be true
  println(isTriangular(4)) // should be false
}

/**
  * This doesn't work and I don't understand why
  */
object triangularNumbers2 extends App {

  var counter = 1

  def isTriangular(n: Int, counter: Int): Boolean = { //10,1

    if (n == 0) true
    if (n < 0) false
    else if (n > 0 ) {
      var res = n - counter //4-4 = 0
      var increment = counter + 1 //5
      isTriangular(res,increment) //(0,5)
    }
    false
  }

  println(isTriangular(1,1)) //should be true
  println(isTriangular(3,1)) //should be true
  println(isTriangular(6,1)) //should be true
  println(isTriangular(10,1)) //should be true
  println(isTriangular(15,1)) //should be true
  println(isTriangular(4,1)) // should be false

}

/**
  * A number is square if you can do the following:
  * Subtract 1, 3, 5, 7 ... and get eventually to zero
  * If the series terminates to zero the number is square
  * If the series terminates to a negative number, the number is not square
  * Square numbers: 1,4,9,16,25 ...
  */


object squareNumbers extends App {

  def isSquare(n: Int): Boolean = {
    n match {
      case n if n < 0 => false
      case n => square(n, 1, (counter: Int) => counter + 2)
    }
  }

  def square(n: Int, counter: Int, f: Int => Int): Boolean = (n, counter) match {
    case _ if (n - counter) == 0 => true
    case _ if (n - counter) < 0  => false
    case _ => square(n - counter, f(counter), f)
  }

  println(isSquare(1)) //should be true
  println(isSquare(2)) // should be false
  println(isSquare(3)) //should be false
  println(isSquare(4)) // should be true
  println(isSquare(5)) //should be false
  println(isSquare(6)) // should be false


}





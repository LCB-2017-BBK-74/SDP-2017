// import Scala Collections List/ indexed sequence

/**
  * Created by lucieburgess on 01/02/2017.
  */
object NumberPersonalities extends App {

  /**
    * You can test whether a number n is prime by dividing through the numbers 2 to n-1
    * If the modulo for one of these divisors is zero the number is not prime
    * A number which is not prime is called composite
    * @param n the number to be checked whether prime or composite
    * @return true if the number is composite
    */
    def isPrime(n: Int) :Boolean = {
      var result :Boolean = true
      for (i <- 2 until n - 1) {
        if (n % i == 0) return false
      }
     true
    }

    def primeNumberGenerator(m: Int) :Unit = {
     for (m <- 1 to m)
       if (isPrime(m)) print(m+" ")
    }

  primeNumberGenerator(1000)


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

  def isHappy(n: Int) :Boolean = {
    var result = 0
    while (result != 1) {

    }
  }

  def getDigits(n: Int) :List[Int] = {
    var intz :List[Int] = null
    if (n == 0) return intz.add(0)
    else {
      intz.add(n % 10)
      intz.add = (n / 10)
      n = n / 10
    }
    getDigits(n)
    }




}

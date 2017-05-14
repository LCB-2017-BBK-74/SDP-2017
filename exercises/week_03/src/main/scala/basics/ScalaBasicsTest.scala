package basics

/**
  * Created by lucieburgess on 26/01/2017.
  * Running tests without using PublicScalaBasicsSuite
  */
object ScalaBasicsTest extends App {

    def oddRange(n: Int): Range = 1.to(n).by(2)
    oddRange(5)
    println(oddRange(5))
    println("Hello World")

    var r: Array[Int] = Array(2, 1, 3)
    println(r).toString

    var c: Array[Int] = Array(1, 3)
    println(c).toString

    c = c.drop(1)
    println(c).toString

    var result = minRecursive(r)

    def minRecursive(r: Array[Int]): Int = {

        if (r.length < 2) r(0)
        else if (r.length <= 2) Math.min(r(0), r(1))

        else minRecursive(Array.concat(Array(Math.min(r(0),r(1))),r.slice(2,r.length)))
    }

    println("Recursive min is " + result)

    def splitInHalf(s: String): (String, String) = {
        if (s.length % 2 == 0) (s.take(s.length / 2), s.takeRight(s.length / 2))
        else (s.take((s.length/2)), s.takeRight((s.length / 2)+1))
    }

    println(splitInHalf("Lucie"))



    def isPalindrome(s: String): Boolean = {

        // val upper = for (c <- "hello, world") yield c.toUpper from Scala CookBook

        val normalString = for (c <- s if c.isLetter) yield c.toLower
        normalString equals normalString.reverse
    }

    println(isPalindrome("01110"))

    def wordCounter(lines: Array[String]): Map[String, Int] = {
      val map = lines.flatMap(_.split("\\W")).groupBy(identity).mapValues(_.length)
      map
    }

    def wordCounter2(lines: Array[String]) :Map[String, Int] = {

    lines.flatMap(_.split(" "))
      .groupBy(word => word)
      .mapValues(_.length)
  }

    val lines = Array("this is a sentence.","this is a sentence too!")
    println(wordCounter2(lines))

}




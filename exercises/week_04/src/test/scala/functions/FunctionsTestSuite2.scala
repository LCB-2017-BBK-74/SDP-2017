package functions

import functions.Funcs2._
import org.scalatest.FunSuite
import scala.collection.Seq

/**
  * Created by lucieburgess on 07/02/2017.
  */
class FunctionsTestSuite2 extends FunSuite{

  test("[01] Tail removes the first element") {
    val ls = FuncsList.apply(1,2,3,4)
    assert(FuncsList.tail(ls).equals(FuncsList(2, 3, 4)))
  }

  test("[02] setHead changes the first element of the list") {
    val ls = FuncsList("A", "B", "C")
    assert(FuncsList.setHead(ls,"0").equals(FuncsList("0", "B", "C")))
  }

  test("[03] drop removes N elements from the front of the list") {
    val ls = FuncsList(1,2,3)
    assert(FuncsList.drop(ls, 2).equals(FuncsList(3)))
  }

  test("[04] init removes the last element") {
    val ls = FuncsList("A", "B", "C", "D")
    assert(FuncsList.init(ls).equals(FuncsList("A", "B", "C")))
  }

  // Folding
  test("[05] foldLeft computes the correct value") {
    val ls = FuncsList("H", "e", "l", "l", "o")
    assert(FuncsList.foldLeft(ls, "")(_ + _) == "Hello")
  }

//  // New test added
//  test("[06] foldRight computes the correct value") {
//    assert(foldRight(List("o", "l", "l", "e", "H"), "")(_ + _) == "Hello")
//  }
//
//  test("[07] sum produces the correct sum") {
//    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
//  }
//
//  test("[08] product produces the correct product") {
//    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
//  }
//
  test("[09] length calculates the length") {
    val ls = FuncsList("H", "e", "l", "l", "o")
    assert(FuncsList.length(ls) == 5)
  }
//
//  //  test("[10] reverse reverses the list") {
//  //    assert(reverse("Hello".toList) == "olleH".toList)
//  //  }
//
//  //  test("[11]flatten flattens the nested list") {
//  //    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
//  //  }
//
//  Map and Filter
  test("[12] map creates a new list of the correct values") {
    val ls = FuncsList(1,2,3,4,5,6,7,8,9,10)
    assert(FuncsList.map(ls)(_ + 1) == FuncsList((2,3,4,5,6,7,8,9,10,11)))
  }
//
//  test("[13] filter filters the list") {
//    assert(filter((-5 to 5).toList)(_ > 0) == (1 to 5).toList)
//  }
//
//  test("flatMap maps and flattens") {
//    assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
//      List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5))
//  }
//
//  // Combined
//
//  test("maxAverage calculates the max average") {
//    val list = List(1.0, 2.0, 3.0, 4.0, 5.0).map(x => (x, x + 10))
//    assert(maxAverage(list) == 13.0)
//  }
//
//  test("variance calculates the correct variance") {
//    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
//    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
//  }
}



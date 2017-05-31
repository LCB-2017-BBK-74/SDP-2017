package q28_sudoku

/**
  * Created by lucieburgess on 31/05/2017.
  * If there is a mistake in the Sudoku blocks the sum will not add up to 45  = (9 + 8 + 7 + .... +1)
  */
object Sudoku extends App {

  def checkBlock(matrix: Array[Array[Int]]): Boolean = {
    var ls: List[Int] = matrix.flatten.toList
    ls.sum == adder(9)
  }

  def adder(n: Int): Int = n match {
    case n if (n <= 0) => 0
    case _ => n + adder(n - 1)
  }

  val myMatrix = Array.ofDim[Int](3,3)
  myMatrix(0)(0) = 1
  myMatrix(0)(1) = 2
  myMatrix(0)(2) = 3
  myMatrix(1)(0) = 4
  myMatrix(1)(1) = 5
  myMatrix(1)(2) = 6
  myMatrix(2)(0) = 7
  myMatrix(2)(1) = 8
  myMatrix(2)(2) = 9
  println(checkBlock(myMatrix))

}


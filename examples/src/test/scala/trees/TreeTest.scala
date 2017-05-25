package trees

/**
  * Created by lucieburgess on 24/05/2017.
  */

import org.scalatest.FunSuite
import trees.BinTree._

class TreeTest extends FunSuite {

  /**
    * Check that after we we insert a value in a tree, we can find it again
    * Left insert, right insert, empty tree or root
    */

  val tree1 = SNode(SLeaf(), 300, "Apple", SLeaf())
  val emptyTree = SLeaf()

  test("01. Find value after right insert") {
    val tree2 = insert(500, "Book", tree1)
    assert(find(500,tree2) == "Book")
  }

  test("02. Find value after left insert") {
    val tree3 = insert(100, "Cook", tree1)
    assert(find(100,tree3) == "Cook")
  }

  test("03. Find value after replacement insert") {
    val tree4 = insert(300, "Afterlife", tree1)
    assert(find(300,tree4) == "Afterlife")
  }

  test("04. Find in an empty tree gives an error") {
    intercept[IllegalArgumentException] {
      find(2,emptyTree)
    }
  }

  /**
    * Inserting a key value into a binary tree produces a tree which is one bigger, unless replacing the root
    */

  test("05. insert increases size rhs") {
    assert(check(500,"B",tree1))
  }

  test("06. insert increases size lhs") {
    assert(check(200,"B",tree1))
  }

  test("07. insert increases size replacement") {
    assert(check(300,"B",tree1))
  }

}

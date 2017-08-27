package trees

/**
  * Created by lucieburgess on 05/06/2017.
  * Final tree revision to do a search and calculate average.
  * Thanks to samaj89!
  */

import scala.annotation.tailrec

sealed trait Tree
final case class Node(val left: Tree, val elem: Int, val right: Tree) extends Tree
final case object Empty extends Tree // same as a Leaf

object TreeOps extends App {

  def insert(n:Int, t:Tree) :Tree = t match {
    case Empty => Node(Empty, n, Empty) //becomes the root of the tree
    case Node(left, v, right) if (n == v) => Node(left, v, right) //no need to do anything, as Node already exists
    case Node(left, v, right) if (n < v) => Node(insert(n, left), v, right)
    case Node(left, v, right) if (n > v) => Node(left, v, insert(n, right))
  }

  def size(t: Tree): Int = t match {
    case Empty => 0
    case Node(left, _, right) => 1 + size(left) + size(right)
  }

  def sizeTailRec(t: Tree) :Int = {
    @tailrec
    def sizeHelper(treeList: List[Tree], accum: Int) :Int = treeList match {
      case Nil => accum
      case Empty :: t => sizeHelper(t,accum)
      case Node(left, _, right) :: t => sizeHelper(left :: right :: t, accum + 1)
    }
    sizeHelper(List(t),0)
  }

  @tailrec
  def isPresent(n: Int, t: Tree): Boolean = t match {
    case Empty => false
    case Node (left, v, _) if n < v => isPresent (n, left)
    case Node(_, v, right) if (n > v) => isPresent(n, right)
    case Node (_, v, _) if (n == v) => true
  }

  /** PreOrder traversal which returns a list of values in the nodes: Root, Left, Right */
  def preOrderTraversal (t: Tree) :List[Int] = t match {
    case Empty => Nil
    case Node (left, v, right) => v :: preOrderTraversal(left) ::: preOrderTraversal(right)
  }

  /** Inorder traversal which returns a list of the values in the nodes: Left, Root, Right */
  def inOrderTraversal (t:Tree) :List[Int] = t match {
    case Empty => Nil
    case Node(left, v, right) => inOrderTraversal(left) ::: List(v) ::: inOrderTraversal(right)
  }

  /** PostOrder traversal which returns a list of values in the nodes: Left, Right, Root */
  def postOrderTraversal (t: Tree) :List[Int] = t match {
    case Empty => Nil
    case Node(left, v, right) => postOrderTraversal(left) ::: postOrderTraversal(right) ::: List(v)
  }

  /** Average size of the tree, calculated depth first (equivalent to post-order traversal) */
  def average(t: Tree) :Double = {
    val ls = inOrderTraversal(t)
    val average = ls.sum/ sizeTailRec(t)
    average
  }

  /** depth-first average - equivalent to PostOrder*/
  def depthAverage (t: Tree) :Double = {
    @tailrec
    def aveHelper(list: List[Tree], acc:Int, count:Int): (Int, Int) = list match {
      case Nil => (acc, count)
      case h::t => h match {
        case Empty => aveHelper(t, acc, count) //sends the function to the tree
        case Node(left, v, right) => aveHelper(left :: right :: t, acc + v, count + 1) //ads the tree nodes to a list, adds the node values to the accumulator and counts the nodes
      }
    }
    val (sum: Int, count: Int) = aveHelper(List(t),0,0)
    sum/count
  }


}

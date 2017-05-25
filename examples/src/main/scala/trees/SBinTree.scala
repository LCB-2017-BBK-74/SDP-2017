package trees

/**
  * Created by lucieburgess on 24/05/2017.
  * Type definition for a binary search tree, where keys are integers and values are strings
  * There are two kinds of binary trees. empty trees or SLeaf(); non empty trees or SNode(...)
  */
sealed trait SBinTree
case class SLeaf() extends SBinTree
case class SNode(lhs: SBinTree, key: Int, value: String, rhs: SBinTree) extends SBinTree


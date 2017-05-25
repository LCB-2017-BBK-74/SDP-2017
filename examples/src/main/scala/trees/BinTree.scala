package trees

/**
  * Created by lucieburgess on 24/05/2017.
  */
object BinTree {
  def find(k: Int, t:SBinTree) :String = t match {
    case SLeaf() => throw new IllegalArgumentException("value not found")
    case SNode(_, key, value, _) if k == key => value
    case SNode(lhs, key, _, _) if k < key => find(k, lhs)
    case SNode(_,key,_,rhs) if k > key => find(k, rhs)
  }

  def insert(k: Int, v: String, t:SBinTree) :SBinTree = t match {
    case SLeaf() => SNode(SLeaf(), k, v, SLeaf()) // in the case of a empty tree make v the root
    case SNode(lhs, key, _, rhs) if k == key => SNode(lhs, key, v, rhs) // case where value is at root
    case SNode(lhs, key, value, rhs) if k <= key => SNode(insert(k, v, lhs), key, value, rhs)
    case SNode(lhs, key, value, rhs) if k >key => SNode(lhs, key, value, insert(k,v,rhs))
  }

  def size(t: SBinTree):Int = t match {
    case SLeaf() => 0
    case SNode(lhs, key, value, rhs) => size(lhs) + size(rhs) + 1
  }

  def check(k: Int, v: String, t: SBinTree): Boolean = {
    if (size(insert(k,v,t)) == size(t) + 1) true
    else try {
      val r = find(k,t)
      true
    } catch {
      case exc: Exception => false
    }
  }
}

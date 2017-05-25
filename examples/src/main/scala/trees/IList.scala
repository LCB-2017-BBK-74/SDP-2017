package trees

/**
  * Created by lucieburgess on 24/05/2017.
  */
sealed trait IList
case class INil() extends IList
case class ICons(head:Int, tail: IList) extends IList

object IList {

  /**
    * Add n to every number in a list
    * @param n
    * @param ls
    * @return
    */
  def add(n: Int, ls:IList) :IList = ls match {
    case INil() => INil()
    case ICons(head, tail) => ICons(head + n, add(n, tail))
  }

  /**
    * Add list ls2 to an existing list ls1
    * @param ls1
    * @param ls2
    * @return
    */
  def append(ls1: IList, ls2: IList) :IList = ls1 match {
    case INil() => ls2
    case ICons(head, tail) => ICons(head, append(tail, ls2))
  }
}

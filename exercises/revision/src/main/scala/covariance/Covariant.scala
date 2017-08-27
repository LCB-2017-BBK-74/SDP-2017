package covariance

/**
  * Created by lucieburgess on 05/06/2017.
  */

trait Ax
trait Bx extends Ax
case class C()
case class D()

case class Covariant[+A]()
case class Contravariant[-A]()
case class Invariant[A]()


object Variance extends App {

}



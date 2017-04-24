package interpreter

import scala.collection.immutable.Vector

object ExpressionUtils {

  private val operators: Vector[String] = Vector("+","-","*","/")

  def isOperator(s: String): Boolean = {

    var isOperator: Boolean = false
    for (o <- operators) {
      if (o.equals(s)) isOperator.equals(true)
    }
    isOperator
  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = s match {
      case "+" => new Add(left, right)
      case "-" => new Subtract(left, right)
      case "*" => new Product(left, right)
      case "/" => new Divide(left, right)
  }
}
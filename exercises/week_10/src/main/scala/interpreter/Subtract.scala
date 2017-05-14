package interpreter

/**
  * Created by lucieburgess on 24/04/2017.
  */
class Subtract (private val leftExpression: Expression,
                private val rightExpression: Expression)
  extends Expression {

  override def interpret(): Int =
    leftExpression.interpret() - rightExpression.interpret()
}

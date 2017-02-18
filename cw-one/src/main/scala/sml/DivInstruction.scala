package sml

/**
  * Turned this into a case class so that factory methods can be used later on
  * @param label, the label of the operation to be acted upon
  * @param op the operation/instruction to be performed (add/sub/mul/div/out/lin/bnz/null)
  * @param result the register in which the result is stored
  * @param op1 the operand in register s1
  * @param op2 the operand in register s2
  */
case class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 / value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " / " + op2 + " to " + result
  }
}

object DivInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new DivInstruction(label, "div", result, op1, op2)
}



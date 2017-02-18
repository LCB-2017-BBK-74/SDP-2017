package sml

/**
  * @param label
  * @param opcode
  * @param register
  * @param next, the label of the next instruction if the contents of register op1 are zero
  */
case class BnzInstruction(label: String, opcode: String, register: Int, next: String)
  extends Instruction(label, opcode) {

  override def execute(m: Machine) {
    val value = m.regs(register)
    if (value != 0) m.labels.add(next)
  }

  override def toString(): String = {
    super.toString + " if register "  + register + "is not zero then branch to " + next + "\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, next: String) =
    new BnzInstruction(label, "bnz", register, next)
}

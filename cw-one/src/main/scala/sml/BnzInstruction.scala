package sml

/**
  * @param label
  * @param opcode
  * @param register
  * @param next, the label of the next instruction if the contents of register op1 are zero
  */
case class BnzInstruction(label: String, opcode: String, register: Int, next: String)
  extends Instruction(label, opcode) {

  /**
    * Branch instruction. If the value of the register is not zero, sets the program counter to the index of the vector
    * prog which contains the labels of the instructions and finds the correct branch instruction
    * Assumes that all the labels of the instructions are unique
    * @param m
    */
  override def execute(m: Machine) {
    val value = m.regs(register) //contents of the registers at the location specified by 'register'
    if (value != 0) {
      m.pc = m.prog.indexOf(m.labels.labels.contains(next))
    }
  }

  override def toString(): String = {
    super.toString + " if register "  + register + "is not zero then branch to " + next + "\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, next: String) =
    new BnzInstruction(label, "bnz", register, next)
}

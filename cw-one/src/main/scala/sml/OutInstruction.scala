package sml

/**
  * Case class for a Out instruction, which prints the register contents to the console
  * @param label
  * @param opcode
  * @param register
  */
case class OutInstruction(label: String, opcode: String, register: Int) extends Instruction(label, opcode) {

  override def execute(m: Machine) =
    println(m.regs(register).toString() + "\n")

  override def toString(): String = {
    super.toString + s" final result register is $register \n"
  }
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}


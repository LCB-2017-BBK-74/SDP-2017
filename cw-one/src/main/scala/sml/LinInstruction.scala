package sml

/**
  * Case class for a Lin instruction, which puts the operand value into a register
  * @param label
  * @param opcode
  * @param register
  * @param value
  */
case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  override def execute(m: Machine) =
    m.regs(register) = value

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int) =
    new LinInstruction(label, "lin", register, value)
}
package sml

abstract class Instruction(label: String, opcode: String) {

  override def toString(): String = label + ": " + opcode.toUpperCase

  def execute(m: Machine): Unit

}

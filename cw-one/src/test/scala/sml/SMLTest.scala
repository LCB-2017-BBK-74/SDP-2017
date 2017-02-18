package sml

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite, Matchers}

/**
  * Created by lucieburgess on 18/02/2017.
  * // NB need to test toString() and apply() methods
  */

class SMLTest extends FlatSpec with BeforeAndAfter {

    val mAdd: Machine = new Machine(Labels(),Vector())
    val mSixf: Machine = new Machine(Labels(),Vector())

    val l1: LinInstruction = new LinInstruction("L1", "lin", 10, 66) // label, opcode, register, value
    val l2: AddInstruction = new AddInstruction("L2","add",10,10,10) //label, opcode, register, value, value
    val l3: LinInstruction = new LinInstruction("L3","lin",11,3) // loads int = 3 to register 11
    val l4: DivInstruction = new DivInstruction("L4","div",12,10,11) // div reg 10(132) by reg 11(3) and load to reg 12 (44)

    val f0: LinInstruction = new LinInstruction("F0", "lin", 20, 6) // load 6 into register 20
    val f1: LinInstruction = new LinInstruction("F1", "lin", 21, 1) // load 1 into register 21
    val f2: LinInstruction = new LinInstruction("F2", "lin", 22, 1) // load 1 into register 22
    val f3: MulInstruction = new MulInstruction("F3","mul",21,21,20) // mul 6 * 1 and load into register 21
    val f4: SubInstruction = new SubInstruction("F4","sub",20,20,22) // 6 - 1 and load into register 20
    val f5: BnzInstruction = new BnzInstruction("F5","bnz",20,"F3")
    //val f6: OutInstruction = new OutInstruction("F6","out",21)


  behavior of "Lin instruction"

  it should "Have a label of L1" in {
    assert(l1.label.equals("L1"))
  }

  it should "Have an opcode of lin" in {
    assert(l1.opcode.equals("lin"))
  }

  it should "Have a result register of 10" in {
    assert(l1.register == 10)
  }

  it should "Have an operand value of 66" in {
    assert(l1.value == 66)
  }

  it should "Change the value of the register when executed" in {
    l1.execute(mAdd)
    assert(mAdd.regs(10) == 66)
  }

  behavior of "Add instruction"

  it should "Have a label of L2" in {
    assert(l2.label.equals("L2"))
  }

  it should "Have an opcode of add" in {
    assert(l2.op.equals("add"))
  }

  it should "Have a result register of 10" in {
    assert(l2.result == 10)
  }

  it should "Have an operand op1 value of 10" in {
    assert(l2.op1 == 10)
  }

  it should "Have an operand op2 value of 10" in {
    assert(l2.op2 == 10)
  }

  it should "Have a register value of 132 when L2 add is executed" in {
    l2.execute(mAdd)
    assert(mAdd.regs(10) == 132)
  }

  behavior of "Div instruction"

  it should "Have a label of L4" in {
    assert(l4.label.equals("L4"))
  }

  it should "Have an opcode of div" in {
    assert(l4.op.equals("div"))
  }

  it should "Have a result register of 12" in {
    assert(l4.result == 12)
  }

  it should "Have an operand op1 value of 10" in {
    assert(l4.op1 == 10)
  }

  it should "Have an operand op2 value of 11" in {
    assert(l4.op2 == 11)
  }

  it should "Have a register value of 44 when L4 add is executed" in {
    l3.execute(mAdd)
    l4.execute(mAdd)
    assert(mAdd.regs(12) == 44)
  }

  behavior of "Mul instruction"

  it should "Have a label of F3" in {
    assert(f3.label.equals("F3"))
  }

  it should "Have an opcode of mul" in {
    assert(f3.op.equals("mul"))
  }

  it should "Have a result register of 21" in {
    assert(f3.result == 21)
  }

  it should "Have an operand op1 value of 21" in {
    assert(f3.op1 == 21)
  }

  it should "Have an operand op2 value of 20" in {
    assert(f3.op2 == 20)
  }

  it should "Have a register value of 6 when F3 mul is executed" in {
    f0.execute(mSixf)
    f1.execute(mSixf)
    f2.execute(mSixf)
    f3.execute(mSixf)
    assert(mSixf.regs(21) == 6)
  }

  behavior of "Sub instruction"

  it should "Have a label of F4" in {
    assert(f4.label.equals("F4"))
  }

  it should "Have an opcode of sub" in {
    assert(f4.op.equals("sub"))
  }

  it should "Have a result register of 20" in {
    assert(f4.result == 20)
  }

  it should "Have an operand op1 value of 20" in {
    assert(f4.op1 == 20)
  }

  it should "Have an operand op2 value of 22" in {
    assert(f4.op2 == 22)
  }

  it should "Have a register value of 5 when F4 sub is executed" in {
    f4.execute(mSixf)
    assert(mSixf.regs(20) == 5)
  }

  behavior of "Bnz instruction" // these tests don't pass yet

  it should "Jump to next register stated when reg value is zero" in {
    fail()
    //f5.execute(mSixf) //next instruction should be F3 as register 20 value is 5
    //assert(mSixf.labels.labels.indexOf(mSixf.pc) == "F3")
  }

  it should "Print correct string when executed" in {
    fail()
    //assertResult(f5.toString().equals("F5: if register 20 is not zero then branch to F3"))
  }




}

package sml

import org.scalatest.{BeforeAndAfter, FlatSpec}

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

  it should "Print the correct instruction via its fields when toString() is called" in {
    assertResult("L1: lin register 10 value is 66 \n"){ l1.toString() }
  }

  it should "Create a new instance of LinInstruction when calling apply" in {
    val lin = LinInstruction("L4",4,72)
    assert(lin.isInstanceOf[LinInstruction])
  }

  it should "Change the value of the register when executed" in {
    l1.execute(mAdd)
    assert(mAdd.regs(10) == 66)
  }

  behavior of "Add instruction"

  it should "Print the correct instruction via its fields when toString() is called" in {
    assertResult("L2: add register 10 + register 10 to register 10 \n"){ l2.toString() }
  }

  it should "Create a new instance of AddInstruction when calling apply" in {
    val add = AddInstruction("L5",31,5,6)
    assert(add.isInstanceOf[AddInstruction])
  }

  it should "Have a register value of 132 when L2 add is executed" in {
    l2.execute(mAdd)
    assert(mAdd.regs(10) == 132)
  }

  behavior of "Div instruction"

  it should "Print the correct instruction via its fields when toString() is called" in {
    assertResult("L4: div register 10 / register 11 to register 12 \n") {l4.toString()}
  }

  it should "Create a new instance of DivInstriction when calling apply" in {
    val div = DivInstruction("L6",24,25,27)
    assert(div.isInstanceOf[DivInstruction])
  }

  it should "Have a register value of 44 when L4 div is executed" in {
    l3.execute(mAdd)
    l4.execute(mAdd)
    assert(mAdd.regs(12) == 44)
  }

  behavior of "Mul instruction"

  it should "Print the correct instruction via its fields when toString() is called" in {
    assertResult("F3: mul register 21 * register 20 to register 21 \n") {f3.toString()}
  }

  it should "Create a new instance of MulInstriction when calling apply" in {
    val mul = MulInstruction("F3",21,21,20)
    assert(mul.isInstanceOf[MulInstruction])
  }

  it should "Have a register value of 6 when F3 mul is executed" in {
    f0.execute(mSixf)
    f1.execute(mSixf)
    f2.execute(mSixf)
    f3.execute(mSixf)
    assert(mSixf.regs(21) == 6)
  }

  behavior of "Sub instruction"

  it should "Print the correct instruction via its fields when toString() is called" in {
    assertResult("F4: sub register 20 - register 22 to register 20 \n") {f4.toString()}
  }

  it should "Create a new instance of SubInstriction when calling apply" in {
    val sub = SubInstruction("F4",20,20,22)
    assert(sub.isInstanceOf[SubInstruction])
  }

  it should "Have a register value of 5 when F4 sub is executed" in {
    f4.execute(mSixf)
    assert(mSixf.regs(20) == 5)
  }

}

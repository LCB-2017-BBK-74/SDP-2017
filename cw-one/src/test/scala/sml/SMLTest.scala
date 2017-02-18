package sml

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite, Matchers}

/**
  * Created by lucieburgess on 18/02/2017.
  */

class SMLTest extends FlatSpec with BeforeAndAfter {

  //before {


    val l1: LinInstruction = new LinInstruction("L1", "lin", 10, 66) //label, opcode, register, value
    val l2: AddInstruction = new AddInstruction("L2","add",10,10,10) //label, opcode, register, value, value

  //}

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


}

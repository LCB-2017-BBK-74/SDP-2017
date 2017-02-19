package sml

import org.scalatest.{BeforeAndAfter, FunSpec, GivenWhenThen}
import scala.collection.immutable.Vector

/**
  * Created by lucieburgess on 19/02/2017.
  * Trying out BDD using FunSpec and GivenWhenThen. See alvinalexander.com/scala/scalatest-bdd-examples-describe-given-when-then-assert
  */
class FurtherSMLTests extends FunSpec with BeforeAndAfter with GivenWhenThen {

  val instr0 = LinInstruction("F0",20,6) // load 6 into register 20
  val instr1 = LinInstruction("F1",21,1) // load 1 into register 21
  val instr2 = LinInstruction("F2",22,1) // load 1 into register 22
  val instr3 = MulInstruction("F3",21,21,20) // mul 6*1 and put in register 21. 2nd time round should multiply 6*5 = 30 and put in register 21, etc
  val instr4 = SubInstruction("F4",20,20,22) // 6-1 and put in register 20

  var labels: Labels = _
  val bnz = "F5"
  val next = "F3"
  val result = 20 //int identifier of the register that the bnz instruction will check
  val out = "F6"

  before {
    labels = Labels()
    labels.add("F0")
    labels.add("F1")
    labels.add("F2")
    labels.add(next) //F3
    labels.add("F4")
    labels.add(bnz) //F5
  }

  describe ("Bnz instruction") {

    it("Should print the correct string with the correct fields") {
    Given("A new BnzInstruction")
      var instr5: BnzInstruction = new BnzInstruction(bnz,"bnz",result,next)

    When("calling toString() it prints correctly using fields")
        assertResult(s"F5: bnz if register $result is not zero then branch to $next \n"){instr5.toString()}
    }

    it("Should create a new BnzInstruction when using apply()") {
      Given("A BnzInstruction created using apply()")
        var instr6 = BnzInstruction(bnz,result,next)

      When("It is created it creates an instance of BnzInstruction")
        assert(instr6.isInstanceOf[BnzInstruction])

      When("toString() is called it prints like a BnzInstruction")
        assertResult(s"F5: bnz if register $result is not zero then branch to $next \n"){instr6.toString()}
    }

    it("Should jump to next instruction stated when value of register is not zero") {
      Given("A new SML machine with a set of instructions including a BnzInstruction")
      var prog: Vector[Instruction] = Vector.empty
      var instr5: BnzInstruction = new BnzInstruction(bnz,"bnz",result,next)
      prog = prog :+ instr0 :+ instr1 :+ instr2 :+ instr3 :+instr4 :+instr5
      val m: Machine = new Machine(labels,prog)

      When("calling the SML Machine to execute the program")
      m.execute()

      Then("the value of register 21 should be 720 when the program completes")
      assert(m.regs(21)===720) // 6!
    }
  }

  describe ("Out instruction") {

    it ("Should print the correct string with the correct fields") {
      Given("A new OutInstruction")
      var instr6: OutInstruction = new OutInstruction(out,"out",result)

      When("calling toString() it prints correctly using fields")
      assertResult(s"F6: out final result register is $result \n"){instr6.toString()}
    }

    it("Should create a new OutInstruction when using apply()") {
      Given("A OutInstruction created using apply()")
      var instr6 = OutInstruction(out,result)

      When("It is created it creates an instance of OutInstruction")
      assert(instr6.isInstanceOf[OutInstruction])

      When("toString() is called it prints like an OutInstruction")
      assertResult(s"F6: out final result register is $result \n"){instr6.toString()}
    }

  }

}



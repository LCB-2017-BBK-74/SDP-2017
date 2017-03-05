package sml

import org.scalatest.{BeforeAndAfter, FunSpec, GivenWhenThen}

/**
  * Created by lucieburgess on 22/02/2017.
  */
class InstructionFactoryTest extends FunSpec with BeforeAndAfter with GivenWhenThen {

  var fields = Array("F3", "mul", "21", "25", "7")

  describe ("A method to generate a class from an opcode") {

    it ("Should print the correct string from the opcode") {
      Given("A new Instruction Factory")
      var instrFact = new InstructionFactory

      When("Calling generateClass the correct class is generated")
      var test = instrFact.generateClass(fields)

      Then("calling generateClass() generates the correct class from the opcode")
      assert(test.equals(MulInstruction.getClass()))
    }
  }
}

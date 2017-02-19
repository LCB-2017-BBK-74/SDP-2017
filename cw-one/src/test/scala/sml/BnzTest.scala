package sml

import org.scalatest.{BeforeAndAfter, FunSpec, GivenWhenThen}

/**
  * Created by lucieburgess on 19/02/2017.
  * Trying out BDD using FunSpec and GivenWhenThen. See alvinalexander.com/scala/scalatest-bdd-examples-describe-given-when-then-assert
  */
class BnzTest extends FunSpec with BeforeAndAfter with GivenWhenThen {


  describe ("Bnz instruction") {

    it("Should jump to next instruction stated when value of register is not zero") {
      fail()
      //f5.execute(mSixf) //next instruction should be F3 as register 20 value is 5
      //assert(mSixf.labels.labels.indexOf(mSixf.pc) == "F3")
    }

    it("Should print the correct string with the correct fields") {
      fail()
      //assertResult(f5.toString().equals("F5: if register 20 is not zero then branch to F3"))
    }
  }
}



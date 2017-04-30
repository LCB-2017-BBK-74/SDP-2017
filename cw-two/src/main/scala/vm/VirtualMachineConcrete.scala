package vm

import bc.ByteCode

import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 28/04/2017.
  * Your virtual machine implementation should use some internal representation for a stack and
  * provide the correct operations defined by the vm.VirtualMachine trait.
  * The stack is just a stack of the ints from the bytecode instructions that will be added, subtracted, etc.
  * Stack is deprecated in Scala so I'm using a Vector.
  */
class VirtualMachineConcrete extends VirtualMachine {

  var stack: Vector[Int] = Vector[Int]()

  /**
    * Executes a vector of bytecodes.
    * Note, that this is an "immutable" object. That is, it will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  def execute(bc: Vector[ByteCode]): VirtualMachine = {
    for (b <- bc) {
      this.executeOne(bc)
    }
    this
  }

  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]) :(Vector[ByteCode], VirtualMachine) = {

    val newVM = new VirtualMachineConcrete
    if (bc.nonEmpty) {
      bc.head.execute(this) //executes a bytecode instruction e.g. Add
      newVM.stack = this.stack
      (bc.tail, newVM)
    }
    else (bc,this)
  }

  /**
    * Pushes an integer value onto the virtual machine stack.
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    stack = stack :+ value
    val newVM = new VirtualMachineConcrete
    newVM.stack = this.stack
    newVM
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    * @return (i, vm), where i is the integer popped and vm is the new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("Cannot pop from an empty stack")
    else {
      val head = stack.head
      stack = stack.drop(1)
      val newVM = new VirtualMachineConcrete
      newVM.stack = this.stack
      (head, newVM)
    }
  }

  override def state: Vector[Int] = this.stack

}

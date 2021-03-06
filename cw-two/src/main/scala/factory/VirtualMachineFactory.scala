package factory

import bc.{ByteCodeFactory, ByteCodeParser, ByteCodeParserConcrete}
import vendor.{ProgramParser, ProgramParserConcrete}
import vm.{VirtualMachine, VirtualMachineConcrete, VirtualMachineParserConcrete}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  * @author LucieCBurgess 17/04/2017, MattBostock
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryConcrete

  def vendorParser: ProgramParser = new ProgramParserConcrete

  def byteCodeParser: ByteCodeParser = new ByteCodeParserConcrete

  def virtualMachineParser: VirtualMachineParserConcrete = new VirtualMachineParserConcrete

  def virtualMachine: VirtualMachine = new VirtualMachineConcrete
}

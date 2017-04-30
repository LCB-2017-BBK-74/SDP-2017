package vm

import bc.{ByteCode, ByteCodeParserConcrete, ByteCodeValues, InvalidBytecodeException}
import vendor.{Instruction, ProgramParserConcrete}

import scala.collection.immutable.Vector
import scala.util.control.NonFatal

/**
  * Created by lucieburgess on 28/04/2017.
  * A `VirtualMachineParser` is used to parse a file of bytecode instructions (as defined by [[vendor.ProgramParser]]).
  * Note, we will use the vendor's parser to parse a file and use the adapter design pattern to write an adapter that will
  * translate a vector of [[vendor.Instruction]] into a vector [[bc.ByteCode]].
  * From the vendor.Instruction class: "The vendor views an instruction as a (`String`, `Vector[Int]`) pair"
  * Whereas a ByteCode is a class which has a method execute and a val code; none of the methods have parameters/ arguments
  * apart from Const, which takes an int (class Const (val num: Int) extends ByteCode
  * val code = Vector(bytecode("iconst"), 4.toByte, bytecode("iconst"), 5.toByte, bytecode("iadd"), bytecode("print"))
    val bc = bcp.parse(code)
  */
class VirtualMachineParserConcrete extends VirtualMachineParser with ByteCodeValues {

  val ppc = new ProgramParserConcrete
  val bcp = new ByteCodeParserConcrete

  /**
    * We use vendor.ProgramParser to parse the file of instructions and translate a vector of
    * [[vendor.Instruction]] into a vector [[bc.ByteCode]]. Returns a vector of [[bc.ByteCode]].
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String) :Vector[ByteCode] = {

    val instrs = ppc.parse(file)
    var bytes: Vector[Byte] = Vector[Byte]()
    try {
      bytes = adapter(instrs)
    } catch {
      case ex: InvalidBytecodeException => ex.printStackTrace()
    }
    bcp.parse(bytes)
  }

  /**
    *
    * @param str a string containing a program
    * @return a vector of ByteCodes
    */
  override def parseString(str: String) :Vector [ByteCode] = {

    val instrs = ppc.parseString(str)
    var bytes: Vector[Byte] = Vector[Byte]()
    try {
      bytes = adapter(instrs)
    } catch {
      case NonFatal(ex) => throw new InvalidBytecodeException(ex.toString)
    }
    bcp.parse(bytes)
  }

  /**
    * Private method which adapts a vector of instructions to a vector of Bytes to give to the ByteCodeParser.
    * @param instrs
    * @return bytes, a vector of [Byte] which can then be parsed using the ByteCodeParser.
    */
  private def adapter(instrs: Vector[Instruction]): Vector[Byte] = {
    var bytes: Vector[Byte] = Vector[Byte]()
    for (i <- instrs) {
      if (!bytecode.contains(i.name)) {
        throw new InvalidBytecodeException("Invalid bytecode")
      } else {
        bytes = bytes :+ bytecode(i.name)
        if (i.args.length > 0) bytes = bytes :+ i.args(0).toByte
      }
    }
    bytes
  }

}

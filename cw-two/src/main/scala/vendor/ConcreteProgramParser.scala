package vendor

/**
  * Created by LucieCBurgess on 17/04/2017.
  */
class ConcreteProgramParser extends ProgramParser {

  override type InstructionList = Vector[Instruction]

  /**
    * From Trait ProgramParser definition, parses a file representation of a bytecode program into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  def parse(file: String): InstructionList = {

    import scala.io.Source
    val lines = Source.fromFile(file).getLines
    for (l <- lines) {
      val instrs = l.split("\n")

  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  def parseString(string: String): InstructionList = ???

}

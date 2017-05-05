package sml

import scala.util.Success
import scala.util.Try

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val DIV = "div"
  private final val OUT = "out"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ") // fields is an array of Strings - the array contains one instruction

      if (fields.length > 0) {
        labels.add(fields(0))
        val name = fields(1)

        //Java code - see InstructionFactory.java
        //        val instrfactory = new InstructionFactory()
        //        program = program :+ instrfactory.generateInstruction(fields)
        //      }

        //Scala code
        try {
          val className = "sml.".concat(name.capitalize).concat("Instruction")
          val realClass = Class.forName(className)
          val cons = realClass.getConstructors()(0)
          var args = new Array[Object](fields.length)
          for (i <- 0 until fields.length) {
            Try(fields(i).toInt) match {
              case Success(j) => args(i) = new Integer(j)
              case _ => args(i) = fields(i)
            }
          }
          val instruction = cons.newInstance(args: _*).asInstanceOf[Instruction]
          program = program :+ instruction
        } catch {
          case ex: ClassNotFoundException =>
            println(s"This instruction {$name} doesn't make sense")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}

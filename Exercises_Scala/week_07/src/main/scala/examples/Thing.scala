import scala.io.StdIn._

trait Instruction { // no constructor as it's a trait
    def action(name:String*): String
}

trait Add extends Instruction
trait Sub extends Instruction

case class AddImpl(s: String, i:Int) extends Add {
    def action(name: String*): String = s"Executing an instruction $name"
}

object FooMain extends App {
    print("Enter a class name: ")
    val name = readLine 
    try {
        Class.forName(name)
        val className = name + "Impl"
        try {
            val actualClass = Class.forName(className)
            var args: Array[Object] = Array("this is a string",new Integer(3)) // have to wrap int 3 in an object wrapper AnyVal vs. AnyRef
            var cons = actualClass.getConstructors
            val con = cons(0)
            val params = con.getParameterTypes // need to loop through the args and if it's a String fine but if it's an int you need to box it
            val foo = actualClass.newInstance.asInstanceOf[Instruction]
            println(foo)
            println(foo.action("Crash the machine!"))
        }
        catch {
            case ex: ClassNotFoundException =>
                println(s"No implementation for [$name] found")
        }
    }
    catch {
        case ex: ClassNotFoundException => 
            println(s"No class of instruction [$name]")
    }
}

// newInstance(Object ... initargs) the bit in the middle is a variable argument list
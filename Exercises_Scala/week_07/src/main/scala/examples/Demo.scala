class Demo(first: String, second: String, third: Int) {
    println(s"I've received a $first and $second with third $third")

    def meth() = println(s"first = $first")
}

object Demo {
    def apply(arg: String) = {
        val args = arg.split(" ")
        new Demo(args(0),args(1), args(2).toInt)        
    }
}

object Foo extends App {
    //new Demo("a","b",3).meth()
    Demo("fred betty 34")
}
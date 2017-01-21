/**
  * Created by lucieburgess on 20/01/2017.
  */
  // http://stackoverflow.com/questions/4437373/use-of-def-val-and-var-in-scala

  object example1 extends App {
    println("Please enter a number in the console")
    val number=scala.io.StdIn.readDouble()
    println("Number is a Double of value " + number)
    val halfNumber = number/2
    println("The value of half the number is "+ halfNumber)
    if(number>=100)
      println("That's a big number")
    else
      println("That's a small number")
  }


  object example2 extends App {
    println("Check whether two objects can sit in the same object")
  }

  object example3 extends App {

    def pow2(y: Double) = y * y

    var x:Double = -1

    while (x != 0) {
      println("Please enter a number in the console")
      x = scala.io.StdIn.readDouble()
      println("You entered the number " + x)
      println("... and the number squared is " + {pow2(x)})
    }
  }

  // need to get this to quit as soon as zero is entered

  object example4 extends App {

    def pow2(y: Int) = y * y
    def pow3(y: Int) = y * y * y

    var(x: Int) = 0

    for (x <- 1 to 25)
      println(x + " " + pow2(x) + " " + pow3(x))
  }

  object example5 extends App {

    def isEven(y: Int) = y % 2 == 0

    var x = 0

    for (x <- 1 to 10)
      if (isEven(x)) println("Yes the number " + x +  " is even")
      else println ("No the number " + {x} +  " is odd")
  }

  object example6 extends App {

    def isEven(y: Int) :Unit = {
      var result:Boolean = false
      if (y % 2 == 0) {
        result = true
      }
    }
  }


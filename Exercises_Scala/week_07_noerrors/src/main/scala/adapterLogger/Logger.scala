package adapterLogger

/**
  * Created by lucieburgess on 15/04/2017.
  * From Ivan Nikolov, Design Patterns in Scala
  * This is the new code that we want to use: a logger which shows the severity of the warning and the error message
  */
class Logger {

  def log(message: String, severity: String) :Unit = {
    println(s"${severity.toUpperCase} :$message")
  }
}


package adapterLogger

/**
  * Created by lucieburgess on 15/04/2017.
  * Example from Scala design patterns by Ivan Nikolov
  */
class AppLogger extends Logger with Log {

  override def info(message: String) = log(message,"Info") // log(message: String, severity: String) - prints the severity in upper case followed by the message

  override def debug(message: String) = log(message,"Debug")

  override def warning(message: String) = log(message, "Warning")

  override def error(message: String) = log(message, "Error")

}

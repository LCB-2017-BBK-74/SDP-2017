package adapterLogger

/**
  * Created by lucieburgess on 15/04/2017.
  * From Ivan Nikolov, design patterns
  * All the code we currently have, expects methods info, debug, warning and error that take the error message
  * and automatically set the right level of severity
  * Of course we cannot edit the library code so we have to use the adapter design pattern to adapt the original code
  * to work with the new specification
  * Useful in cases after the code is designed and written. Allows otherwise incompatible interfaces to work together.
  * Fairly straightforward to implement and use.
  */
trait Log {

  def info(message: String)
  def debug (message: String)
  def warning (message: String)
  def error(message: String)

}

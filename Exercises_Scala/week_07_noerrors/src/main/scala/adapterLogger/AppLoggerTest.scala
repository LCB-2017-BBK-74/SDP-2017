package adapterLogger

/**
  * Created by lucieburgess on 15/04/2017.
  */
class AppLoggerTest {
}

object AppLoggerTest {
  def main(args: Array[String]): Unit = {
    val logger = new AppLogger
    logger.info("Here is some information about the log")
    logger.debug("Debug the app here")
    logger.error("This is an error message")
    logger.warning("Warning!")
    logger.info("About to finish - bye!")
  }

}

// Output is as follows:
// INFO :Here is some information about the log
// DEBUG :Debug the app here
// ERROR :This is an error message
// WARNING :Warning!
// INFO :About to finish - bye!
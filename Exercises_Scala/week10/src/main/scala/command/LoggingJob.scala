package command

class LoggingJob extends Job {

  var aLogging: Logging = null

  def setLogging(logging: Logging): Unit = {
    this.aLogging = logging
  }

  override def run(): Unit = aLogging.log
}
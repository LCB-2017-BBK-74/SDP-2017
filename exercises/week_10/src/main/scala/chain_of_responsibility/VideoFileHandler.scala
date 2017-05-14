package chain

case class VideoFileHandler(s: String) extends Handler {

  var next: Handler = null

  override def setHandler(handler: Handler): Unit = {
    next = handler
  }

  override def process(file: File): Unit = {
    if (file.fileType equals "video") println(s"Process and saving video file by ... ${this.getHandlerName}")
    else if (next != null) {
      println(s"${this.getHandlerName} forwards request to ${next.getHandlerName}")
      next.process(file)
    }
    else println ("File not supported")
  }

  override def getHandlerName(): String = s
}

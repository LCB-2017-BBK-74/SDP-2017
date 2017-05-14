package chain

case class TextFileHandler(s: String) extends Handler {

  var next: Handler = null

  override def setHandler(handler: Handler): Unit = {
    next = handler
  }

  override def process(file: File): Unit = {
    if (file.fileType equals "text") println(s"Process and saving text file by ... ${this.getHandlerName}")
    else if (next != null) {
      println(s"${this.getHandlerName} forwards request to ${next.getHandlerName}")
      next.process(file)
    }
    else println ("File not supported")
  }

  override def getHandlerName(): String = s

}

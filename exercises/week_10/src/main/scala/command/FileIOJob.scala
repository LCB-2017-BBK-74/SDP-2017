package command

class FileIOJob extends Job {

  var aFileIO: FileIO = null

  def setFileIO(fileIO: FileIO): Unit = {
    this.aFileIO = fileIO
  }

  override def run(): Unit = aFileIO.execute
}
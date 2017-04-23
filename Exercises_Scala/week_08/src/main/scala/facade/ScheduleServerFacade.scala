package facadepattern

case class ScheduleServerFacade(scheduleServer: ScheduleServer) {

  def startServer: Unit = {
    scheduleServer.startBooting
    scheduleServer.readSystemConfigFile
    scheduleServer.init
    scheduleServer.initializeContext
    scheduleServer.initializeListeners
    scheduleServer.createSystemObjects
  }

  def stopServer = {
    scheduleServer.releaseProcesses
    scheduleServer.destroy
    scheduleServer.destroySystemObjects
    scheduleServer.destroyListeners
    scheduleServer.destroyContext
    scheduleServer.shutdown
  }

}

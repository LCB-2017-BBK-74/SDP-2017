package facadepattern

/**
  * @author LucieCBurgess
  */

case class ScheduleServerImpl() extends ScheduleServer {

  override def startBooting: Unit = println("Booting ...")

  override def readSystemConfigFile: Unit = println("Reading system config file ...")

  override def init: Unit = println("Initialising ...")

  override def initializeContext: Unit = println("Initialising context ...")

  override def initializeListeners: Unit = println("Initialising listeners ...")

  override def createSystemObjects: Unit = println("Creating system objects ...")

  override def releaseProcesses: Unit = println("Releasing processes ...")

  override def destroy: Unit = println("Destroying old files ...")

  override def destroySystemObjects: Unit = println("Destroying system objects ...")

  override def destroyListeners: Unit = println("Destroying listeners ...")

  override def destroyContext: Unit = println("Destroying context ...")

  override def shutdown: Unit = println("Shutting down")
}

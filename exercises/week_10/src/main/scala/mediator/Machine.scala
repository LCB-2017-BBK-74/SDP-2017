package mediator

class Machine extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = {
    this.mediator = mediator
  }

  def setTemp(mediator: MachineMediator): Int = {
    var temp = 0
    if (mediator.isInstanceOf[CottonMediator]) temp = 40
    else if (mediator.isInstanceOf[DenimMediator]) temp = 30
    temp
  }

  def start(): Unit = {
    mediator.open
    mediator.closed
    mediator.on
    mediator.checkTemperature(setTemp(mediator))
    mediator.off
  }

  def wash(): Unit = mediator.wash
}
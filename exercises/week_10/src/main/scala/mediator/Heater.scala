package mediator

class Heater extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = {
    this.mediator = mediator
  }

  def on(temp: Int): Unit = {
    println("Heater is on...")
  }

  def off(): Unit = {
    println("Heater is off...")
  }
}
package observer

/**
  * Trait Observer
  * Defines an updating interface for objects that should be notified of changes in a subject(channel)
  * All observers need to implement this trait
  * The trait has a method update(desc: String), which gets called when Subject's state changes
  */

trait Observer {

  def update(desc: String)

  def subscribe()

  def unSubscribe()
}

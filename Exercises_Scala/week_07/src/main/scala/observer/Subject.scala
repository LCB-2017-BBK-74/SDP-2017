package observer

/**
  * Trait which is used to register observers. Objects use this interface to subscribe to being observers and to remove themselves
  * from being observers
  * Subject is like a package or channel that users can subscribe to
  */

trait Subject {

  def subscribeObserver(observer: Observer)

  def unSubscribeObserver(observer: Observer)

  def notifyObservers()

  def subjectDetails: String
}

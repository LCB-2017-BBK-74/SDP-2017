package observer

/**
  * Class ConcreteObserver (previously SMSUsers) maintains a reference to a ConcreteSubjectCommentary object
  * and implements the Observer interface
  * Each ConcreteObserver registers with a concrete subject to receive updates to the subject
  * @param s, the reference to a ConcreteSubjectCommentary object
  * @param msg
  */

class ConcreteObserver(s: Subject, msg: String) extends Observer {

  def update(desc: String) = {
    println(msg)
    println(desc)
  }

  def subscribe() = s.subscribeObserver(this)

  def unSubscribe() = s.unSubscribeObserver(this)
}

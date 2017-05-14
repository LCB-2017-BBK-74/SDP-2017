package observer

import scala.collection.mutable.ListBuffer

/**
  * The class ConcreteSubjectCommentary (previously CommentaryObject) stores the state of interest to ConcreteObserver
  * This is essentially the channel of commentary to which the user subscribes
  * @param subscribers - a list of Observers held in a ListBuffer
  * @param title
  */

class ConcreteSubjectCommentary(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {

  var commentary: String = "Nothing happening"

  def subscribeObserver(observer: Observer) = subscribers append observer

  def unSubscribeObserver(observer: Observer) = {
    val indexToDelete = subscribers.indexOf(observer)
    if (indexToDelete >= 0) subscribers.remove(indexToDelete)
  }

  def notifyObservers() = {
    for (o <- subscribers) o.update(subjectDetails)
  }

  def subjectDetails: String = title + commentary

  def setDesc(desc: String) = {
    commentary = desc
    notifyObservers()
  }
}

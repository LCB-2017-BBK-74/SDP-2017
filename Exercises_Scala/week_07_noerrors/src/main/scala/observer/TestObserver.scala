package observer

import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 16/04/2017.
  */
object TestObserver extends App {

  val subject: Subject = new ConcreteSubjectCommentary(ListBuffer[Observer](), "Soccer Match [2014Aug24]")

  val observer: Observer = new ConcreteObserver(subject, "Lucie Burgess [Aylesbury]")

  observer.subscribe
  println()

  val observer2: Observer = new ConcreteObserver(subject, "Sarah Smurph [Bristol]")
  observer2.subscribe()

  val commentary: Commentary = subject.asInstanceOf[Commentary]

  commentary.setDesc("Welcome to the live soccer match!")
  commentary.setDesc("Play is about to begin!")
  commentary.setDesc("For those of you just joining, the score is 0-0")
  println()

  observer2.unSubscribe()
  println()

  commentary.setDesc("It's a goal!")
  commentary.setDesc("Score is now 1-0")
  println()

  val observer3: Observer = new ConcreteObserver(subject, "Aimee Eds, [London]")
  observer3.subscribe()
  println()

  commentary.setDesc("There's another goal!")
  commentary.setDesc("Half time score is 2-0")

}

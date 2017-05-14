/**
  * Created by lucieburgess on 13/05/2017.
  * See doc.akka.io/docs/akka/2.02/intro/getting-started-first-scaka.html
  * NB. This uses an old version of the API so I've updated the import statements and some of the logic may need
  * updating to, to akka v2.5.1.
  * We need four different messages flowing in the system to calculate Pi.
  * Calculate - sent to the Master actor to start the calculation
  * Work - sent from the Worker actors to the Master actor containing the result from the worker's calculation
  * PiApproximation - sent from the Master actor to the Listener actor containing the final pi result and how
  * long the calculation took
  */

import akka.actor._
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}
import scala.concurrent.duration._
import scala.concurrent.duration.Duration

sealed trait PiMessage

case object Calculate extends PiMessage

case class Work(start: Int, nuElements: Int) extends PiMessage

case class Result(value: Double) extends PiMessage

case class PiApproximation (pi: Double, duration: Duration)









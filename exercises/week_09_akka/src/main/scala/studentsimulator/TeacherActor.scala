package studentsimulator

/**
  * Created by lucieburgess on 25/05/2017.
  * TeacherActor class in the student simulator tutorial.
  * Class could use refinement by way of ActorLogging which uses the EventBus of the Actor framework.
  */
import scala.util.Random
import akka.actor.{Actor, ActorLogging}
import studentsimulator.TeacherProtocol.{QuoteRequest, QuoteResponse}

class TeacherActor extends Actor with ActorLogging {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try",
    "Always remember to say please and thankyou",
    "Smiling will get you everywhere")

  def receive = {

    case QuoteRequest => {
      //get a random quote from the list and construct a response
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString)
    }
  }

  def quoteList = quotes
}

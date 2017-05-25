package studentsimulator

/**
  * Created by lucieburgess on 25/05/2017.
  * Recommended practice to wrap messages in a nice object for easier organisation
  */
object TeacherProtocol {

  case class QuoteRequest()
  case class QuoteResponse(quoteString: String)

}

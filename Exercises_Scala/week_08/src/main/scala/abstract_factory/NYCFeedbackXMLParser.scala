package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class NYCFeedbackXMLParser extends XMLParser {

  override def parse :String = {
    println("NYC Parsing feedback XML...")
    "NYC Feedback XML Message"
  }

}

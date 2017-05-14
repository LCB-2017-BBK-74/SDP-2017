package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class LondonFeedbackXMLParser extends XMLParser {

    override def parse :String = {
      println("London Parsing feedback XML...")
      "London Feedback XML Message"
    }

}

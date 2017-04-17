package abstract_factory

import abstractfactory.AbstractParserFactory

/**
  * Created by lucieburgess on 17/04/2017.
  */

class NYCParserFactory extends AbstractParserFactory {

  override def getParserInstance(parserType: String) = parserType match {
    case "NYCERROR" => new NYCErrorXMLParser
    case "NYCFEEDBACK" => new NYCFeedbackXMLParser
    case "NYCORDER" => new NYCOrderXMLParser
    case "NYCRESPONSE" => new NYCResponseXMLParser
  }

}


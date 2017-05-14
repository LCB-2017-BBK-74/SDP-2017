package abstract_factory

import abstractfactory.AbstractParserFactory

/**
  * Created by lucieburgess on 17/04/2017.
  */
class LondonParserFactory extends AbstractParserFactory{

  override def getParserInstance(parserType: String) = parserType match {
    case "LondonERROR" => new LondonErrorXMLParser
    case "LondonFEEDBACK" => new LondonFeedbackXMLParser
    case "LondonORDER" => new LondonOrderXMLParser
    case "LondonRESPONSE" => new LondonResponseXMLParser
  }

}

package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class NYCResponseXMLParser extends XMLParser {

  override def parse :String = {
    println("NYC Parsing response XML...")
    "NYC Response XML Message"
  }

}

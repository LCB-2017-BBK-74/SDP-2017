package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class LondonResponseXMLParser extends XMLParser {

    override def parse :String = {
      println("London Parsing response XML...")
      "London Response XML Message"
    }

}

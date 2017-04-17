package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class LondonErrorXMLParser extends XMLParser {

    override def parse :String = {
      println("London Parsing error XML...")
      "London Error XML Message"
    }
}

package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class LondonOrderXMLParser extends XMLParser {

    override def parse :String = {
      println("London Parsing order XML...")
      "London Order XML Message"
    }
}

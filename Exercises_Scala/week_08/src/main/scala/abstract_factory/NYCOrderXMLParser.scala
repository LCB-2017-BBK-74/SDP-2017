package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class NYCOrderXMLParser extends XMLParser {

  override def parse :String = {
    println("NYC Parsing order XML...")
    "NYC Order XML Message"
  }
}

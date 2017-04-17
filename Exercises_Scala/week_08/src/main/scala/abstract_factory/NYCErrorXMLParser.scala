package abstract_factory

import abstractfactory.XMLParser

/**
  * Created by lucieburgess on 17/04/2017.
  */
class NYCErrorXMLParser extends XMLParser {

  override def parse :String = {
    println("NYC Parsing error XML...")
    "NYC Error XML Message"
  }

}

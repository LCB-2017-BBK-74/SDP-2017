package abstractfactory

trait XMLParser {

  def parse: String
}

// according to the test class, var msg: String, msg = parser.parse therefore parse must return a String
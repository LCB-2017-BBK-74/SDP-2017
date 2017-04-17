package strategy

/**
  * CapTextFormatter is tightly coupled to the TextFormatter
  * @author LucieCBurgess
  */

case class CapTextFormatter() extends TextFormatter {

  override def format(text: String): Unit = println(text.toUpperCase)

}

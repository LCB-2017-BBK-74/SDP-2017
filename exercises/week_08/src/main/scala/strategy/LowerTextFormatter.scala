package strategy

/**
  * @author LucieCBurgess
  */

case class LowerTextFormatter() extends TextFormatter {

  override def format(text: String): Unit = println(text.toLowerCase)
}

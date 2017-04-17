package strategy

/**
  * @author LucieCBurgess
  * @param formatter, the text format application to be chosen at runtime
  */

case class TextEditor(formatter: TextFormatter) {

  def publishText(s: String) = formatter.format(s)
}

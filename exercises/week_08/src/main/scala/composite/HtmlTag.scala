package composite

import scala.collection.mutable.ListBuffer


abstract class HtmlTag(var tagName: String) {

  var tagBody: String = ""
  var startTag: String = ""
  var endTag: String = ""

  def getTagName: String = tagName

  def setStartTag(tag: String) = {
    startTag = tag
  }

  def setEndTag(tag: String) = {
    endTag = tag
  }

  def setTagBody(tag: String) = {
    tagBody = tag
  }

  def addChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException

  def removeChildTag(htmlTag: HtmlTag) :Unit = throw new UnsupportedOperationException

  def getChildren: ListBuffer[HtmlTag] = throw new UnsupportedOperationException

  def generateHtml = println(s"$startTag $tagBody $endTag")
}
package composite

import scala.collection.mutable.ListBuffer

case class HtmlParentElement(s: String) extends HtmlTag(s) {

  private val children = ListBuffer.empty[HtmlTag]

  override def setStartTag(tag: String): Unit = {
    startTag = tag
  }

  override def setEndTag(tag: String): Unit = {
    endTag = tag
  }

  override def addChildTag(htmlTag: HtmlTag) = {
    children += htmlTag
  }

  override def removeChildTag(htmlTag: HtmlTag) = {
    val index = children.indexOf(htmlTag)
    if (children.nonEmpty) children.remove(index)
  }

  override def getChildren: ListBuffer[HtmlTag] = children

  override def generateHtml: Unit = {
    println(startTag)
    val element: HtmlTag = children.iterator.next()
    element.generateHtml
    println(endTag)
  }
}

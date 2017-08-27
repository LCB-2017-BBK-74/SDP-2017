package q13_Library


import scala.collection.mutable.ListBuffer

/**
  * Created by lucieburgess on 01/06/2017.
  * I'm not sure what needs to be done to the UML diagram. We have a Library which extends LibraryItem (cf. Node in the
  * case of a tree). The Article is a child of
  */
sealed trait LibraryItem

/** A book is a leaf node of the tree */
case class Book(author: String, title: String, pages: Int) extends LibraryItem

/** An article is a lead node of the tree */
case class Article(author: String, title: String, pages: Int) extends LibraryItem

/** A magazine is has children, articles */
case class Magazine(title: String, articles: List[Article]) extends LibraryItem

object Library extends LibraryItem {

  val authorList :ListBuffer[String] = ListBuffer[String]()
  val library :ListBuffer[LibraryItem] = ListBuffer[LibraryItem]()

  def printPages (library: ListBuffer[LibraryItem]) = {
    library.foreach(print(_))
  }

  def print(l: LibraryItem) :Unit = l match {
    case Book(author, title, pages) => println(title) // in reality we would also need a class for pages
    case Article(author, title, pages) => println(title)
    case Magazine(title, articles) => articles.foreach(print(_))
  }

  def printAuthors(library: ListBuffer[LibraryItem]) = {
    library.foreach(addAuthor(_))
    library.foreach(println(_))
  }

  def addAuthor(l: LibraryItem) :Unit = l match {
    case Book(author, title,pages) => authorList += author
    case Article(author,title, pages) => authorList += author
    case Magazine(title, articles) => articles.foreach(addAuthor(_))
  }

  def addLibraryItem(l: LibraryItem):Unit = l match {
    case Book(author,title,pages) => library :+ Book
    case Article(author,title, pages) => library :+ Article
    case Magazine(title, articles) => articles.foreach(addLibraryItem(_))
  }

}

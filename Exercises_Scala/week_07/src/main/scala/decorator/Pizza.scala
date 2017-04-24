package decorator

/**
  * The main aim of the Decorator design pattern is to attach additional responsibilities to an object dynamically
  * Decorators provide a flexible alternative to sub-classing for extending functionality
  * The Decorator prevents the proliferation of sub-classes leading to less complexity and confusion
  * The decorator wraps the object whose functionality needs to be increased, so it needs to implement the same interface
  * An abstract decorator class will then be extended by all concrete decorator classes
  */

trait Pizza {

  def getDesc: String

  def getPrice: Double
}

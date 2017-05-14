package iterator

/**
  * Modified the Iterator
  * This is not quite working but I really don't know why ...
  * @param shapes
  */

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  private var index = 0

  override def hasNext(): Boolean = {
    index < shapes.length-1
  }

  override def next(): Shape = {
    if (hasNext) {
      val nextShape :Shape = shapes(index + 1)
      index += 1
      nextShape
    }
    else null
  }

  def remove(): Unit = shapes.filter(s => s.id != index)

}
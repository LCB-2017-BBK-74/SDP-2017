package q4_constructors

/**
  * Created by lucieburgess on 31/05/2017.
  */
class ClothesWasher (val modelName: String, val capacity: Double) {

  // one-arg auxiliary constructor for modelName
  def this(modelName: String) {
    this(modelName, capacity = ClothesWasher.DEFAULT_CAPACITY)
  }

  // one-arg auxiliary constructor
  def this(capacity: Double) {
    this(modelName = ClothesWasher.DEFAULT_MODEL_NAME, capacity)
  }

  // zero-arg auxiliary constructor
  def this() {
    this(ClothesWasher.DEFAULT_MODEL_NAME, ClothesWasher.DEFAULT_CAPACITY)
  }
  override def toString = s"A $modelName type of washing machine with a ${capacity}L capacity"
}

object ClothesWasher {
  val DEFAULT_MODEL_NAME = "Zanussi"
  val DEFAULT_CAPACITY = 7.0
}

object Main extends App {
  val bigWasher = new ClothesWasher("Hoover", 10.0)
  println(bigWasher.toString)

  val defaultWasher = new ClothesWasher()
  println(defaultWasher.toString)

  val defaultModelWasher = new ClothesWasher(8.0)
  println(defaultModelWasher.toString)

  val defaultCapacityWasher = new ClothesWasher("HotPoint")
  println(defaultCapacityWasher.toString)

}


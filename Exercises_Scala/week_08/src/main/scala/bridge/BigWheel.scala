package bridge

/**
  * @author LucieCBurgess 23.04.2017
  * @param product - Central Locking System or Gear Locking System
  * @param s model type which is xz or lm
  */

case class BigWheel(product: Product, s: String) extends Car(product, s) {

  override def assemble: Unit = println(s"Assembling ${product.productName} for $s")

  override def produceProduct: Unit = {
    product.produce
    println(s"Modifying product ${product.productName} according to $s")
  }

  override def printDetails: Unit = println(s"Car: $s, Product: ${product.productName}")
}

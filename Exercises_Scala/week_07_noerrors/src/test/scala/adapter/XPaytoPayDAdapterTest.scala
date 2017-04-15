package adapter

/**
  * Created by lucieburgess on 15/04/2017.
  */
object XPaytoPayDAdapterTest extends App {

  val xpayObject = new XpayImpl

  xpayObject.setCustomerName("Lucie Burgess")
  xpayObject.setCreditCardNo("1234567891011121")
  xpayObject.setCardExpMonth("April")
  xpayObject.setCardExpYear("2019")
  xpayObject.setCardCVVNo(345)
  xpayObject.setAmount(425.0)

  println("using the XPay interface: ")

  println(xpayObject.getCustomerName)
  println(xpayObject.getCreditCardNo)
  println(xpayObject.getCardExpMonth)
  println(xpayObject.getCardExpYear)
  println(xpayObject.getCardCVVNo)
  println(xpayObject.getAmount)

  println("Now using the payD interface ")
  println("By converting an xPay object to a payD object using the XpayToPayDAdapter")

  val payDobject = new XpayToPayDAdapter(xpayObject)

  println(payDobject.getCardOwnerName)
  println(payDobject.getCustCardNo)
  println(payDobject.getCardExpDate)
  println(payDobject.getCVVNo)
  println(payDobject.getTotalAmount)

}
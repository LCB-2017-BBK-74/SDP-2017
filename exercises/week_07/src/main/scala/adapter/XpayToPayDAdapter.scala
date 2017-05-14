package adapter

/**
  * Created by lucieburgess on 15/04/2017.
  * Adapters help incompatible interfaces work together without modifying their source code
  * Idea is to set up a class which mediates between the old and the new interfaces, so that this class is compatible with the new interface
  * Therefore it override the PayD methods i.e. has to implement the methods defined in the NEW trait
  *
  * The Logger example uses the old methods to come up with the new methods, but actually it makes more logical sense
  * to take an xPay object and use it to create a payD object, therefore implementing the payD methods
  * Doesn't seem possible to do this using an interface only
  *
  */

class XpayToPayDAdapter (xpayObject: Xpay) extends PayD {

  override def getCustCardNo: String = xpayObject.getCreditCardNo

  override def setCustCardNo(custCardNo: String): Unit = xpayObject.setCreditCardNo(custCardNo)

  override def getCardOwnerName = xpayObject.getCustomerName

  override def setCardOwnerName(cardOwnerName: String): Unit = xpayObject.setCustomerName(cardOwnerName)

  override def getCardExpDate = xpayObject.getCardExpMonth + " " + xpayObject.getCardExpYear

  override def setCardExpDate(cardExpDate: String) = {
    val date = cardExpDate.split(" ")
    val month = date(0)
    val year = date(1)
    xpayObject.setCardExpMonth(month)
    xpayObject.setCardExpYear(year)
  }

  override def getCVVNo = xpayObject.getCardCVVNo.toInt

  override def setCVVNo(cVVNo: Integer) =  xpayObject.setCardCVVNo(cVVNo.toShort) //have to convert Integer to Short

  override def getTotalAmount = xpayObject.getAmount

  override def setTotalAmount(totalAmount: Double) = xpayObject.setAmount(totalAmount)

}
package adapter

/**
  * Created by Keith Mannock
  * Trait for the X-pay payment gateway, which is to be replaced by the PayD payment gateway
  */

trait Xpay {
  def getCreditCardNo: String

  def setCreditCardNo(creditCardNo: String)

  def getCustomerName: String

  def setCustomerName(customerName: String)

  def getCardExpMonth: String

  def setCardExpMonth(cardExpMonth: String)

  def getCardExpYear: String

  def setCardExpYear(cardExpYear: String)

  def getCardCVVNo: Short

  def setCardCVVNo(cardCVVNo: Short)

  def getAmount: Double

  def setAmount(amount: Double)
}

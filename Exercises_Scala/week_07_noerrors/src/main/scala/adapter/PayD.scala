package adapter

/**
  * Created by Keith Mannock
  * PayD trait which defines the PayD payment gateway
  */

trait PayD {
  def getCustCardNo: String

  def setCustCardNo(custCardNo: String)

  def getCardOwnerName: String

  def setCardOwnerName(cardOwnerName: String)

  def getCardExpDate: String

  def setCardExpDate(cardExpDate: String)

  def getCVVNo: Integer

  def setCVVNo(cVVNo: Integer)

  def getTotalAmount: Double

  def setTotalAmount(totalAmount: Double)
}

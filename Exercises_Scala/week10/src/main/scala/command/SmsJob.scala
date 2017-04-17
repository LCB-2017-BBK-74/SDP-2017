package command

class SmsJob extends Job {

  var anSms: Sms = null

  def setSms(sms: Sms): Unit = {
    this.anSms = sms
  }

  override def run(): Unit = anSms.sendSms
}
package command

class EmailJob extends Job {

  var anEmail: Email = null

  def setEmail(email: Email): Unit = {
    this.anEmail = email
  }

  override def run(): Unit = anEmail.sendEmail
}
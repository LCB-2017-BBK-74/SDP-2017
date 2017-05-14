package prototype

class User(var userName: String, var level: String, var accessControl: AccessControl) {

  override def toString() = s"Name: $userName, Level: $level, Access Control Level: " +
    s"${accessControl.controlLevel}, Access: ${accessControl.access}"
}

package prototype

import scala.collection.mutable.HashMap

object AccessControlProvider {

  private var map = new HashMap[String, AccessControl]

  println("Fetching data from external resources and creating access control objects...")

  map += ("USER" -> new AccessControl("USER", "DO_WORK"))

  map += ("ADMIN" -> new AccessControl("ADMIN", "ADD/REMOVE USERS"))

  map += ("MANAGER" -> new AccessControl("MANAGER", "GENERATE/READ REPORTS"))

  map += ("VP" -> new AccessControl("VP", "MODIFY REPORTS"))

  def getAccessControlObject(controlLevel: String): AccessControl = {
    //map.getOrElse(controlLevel, new AccessControl ("USER","Not found"))
    map.apply(controlLevel)
  }

}
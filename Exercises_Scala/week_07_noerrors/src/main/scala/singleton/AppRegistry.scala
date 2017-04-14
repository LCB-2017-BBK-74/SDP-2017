package singleton

import scala.collection.concurrent.{TrieMap,Map}

/**
  * Created by lucieburgess on 14/04/2017.
  * Code example from Scala Design Patterns by Ivan Nikolov
  * A TrieMap is a concurrent thread-safe lock-free implementation of a hash array mapped trie, used to implement a concurrent hashmap abstraction
  * collection.map(_._2) just means map the 2nd tuple in the collection that is being operated on:
  * see http://stackoverflow.com/questions/29246440/apache-spark-what-is-map-2-shorthand-for
  * I made id an Int rather than a String
  */
class AppRegistry (var id: Int, var name: String) {
}

object AppRegistry {
  println("Registry initialisation block called.")
  val users: Map[Int, String] = TrieMap.empty

  def addUser(id: Int, name: String) :Unit = {
    users.put(id,name)
  }

  def removeUser(id: Int) :Unit = {
    users.remove(id)
  }

  def isUserRegistered(id: Int) : Boolean = users.contains(id)

  def getAllUserNames(): List[String] = users.map(_._2).toList // see explanation above

}

object AppRegistryExample {
  def main(args: Array[String]) :Unit = {
    println("Sleeping for 5 seconds")
    Thread.sleep(5000)
    println("I woke up!")
    AppRegistry.addUser(1, "Lucie")
    AppRegistry.addUser(2, "Matilda")
    AppRegistry.addUser(3, "Noah")
    println(s"Is user with id=1 registered? ${AppRegistry.isUserRegistered(1)}")
    println("Removing user with id=2")
    AppRegistry.removeUser(2)
    println(s"Is user with id=2 registered? ${AppRegistry.isUserRegistered(2)}")
    println("printing all registered users")
    println(s"Registered users are ${AppRegistry.getAllUserNames().mkString(",")}") // prints the names separated by commas
  }
}

// In this case the Singleton example is a global state - the app registry state is a single instance and is acessible
// by classes in the application while the instance is running
// Again there is a single instance of the object (the app registry) but it is mutable

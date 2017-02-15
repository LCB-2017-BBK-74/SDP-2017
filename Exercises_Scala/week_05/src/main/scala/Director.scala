/**
  * Created by lucieburgess on 14/02/2017.
  * Director should contain:
  * a field firstName of type String
  * a field lastName of type String
  * a field yearOfBirth of type Int
  * a method called name that accepts no parameters and returns the full name
  * Need to specify the fields as var or val. If they are not specified, the visibility of the field becomes
  * very restricted. See Scala cookbook p.106
  * With var, accessors and mutators are automatically generated
  */

class Director(var firstName: String, var lastName: String, var yearOfBirth: Int) {

    def name = firstName + " " + lastName

}

object DirectorMain extends App {
  var dir = new Director("Stephen","Spielberg",1952)
  println(dir.firstName)
  println(dir.lastName)
  println(dir.name)
}
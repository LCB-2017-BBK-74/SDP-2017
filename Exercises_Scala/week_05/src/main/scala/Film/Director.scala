package Film

/**
  * Created by lucieburgess on 14/02/2017.
  * Need to specify the fields in the class definition (essentially the constructor) as var or val.
  * If they are not specified, the visibility of the field becomes very restricted. See Scala cookbook p.106
  * With var, accessors and mutators are automatically generated
  * With val, an accessor is generated but not a mutator
  * Defining the class as a case class automatically generates an apply()method which means you don't have to call new to
  * create a new instance of Director
  * With case classes, fields are automatically val by default
  * With use of the case class, you don't need the apply() method; it is automatically generated
  */

class Director(var firstName: String, var lastName: String, var yearOfBirth: Int) {

  def name = firstName + " " + lastName

}

/**
  * The apply() method is not required if we use a case class rather than a class
  */

object Director {

  def apply(firstName: String, lastName: String, yearOfBirth: Int) = new Director(firstName,lastName,yearOfBirth)

  def older(dir1: Director, dir2: Director) = if (dir1.yearOfBirth < dir2.yearOfBirth) dir1 else dir2

}

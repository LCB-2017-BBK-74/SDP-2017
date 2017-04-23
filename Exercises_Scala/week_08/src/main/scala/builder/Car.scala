package builder

/**
  * Created by lucieburgess on 23/04/2017.
  */
case class Car
  (var carType: String,
   var bodyStyle: String = "",
   var power: String = "",
   var engine: String = "",
   var brakes: String = "",
   var seats: String = "",
   var windows: String = "",
   var fuelType: String = "") {

  override def toString: String = {
    val sb: StringBuilder = new StringBuilder
    sb.append(s"----------------- $carType -------------------\n")
    sb.append(" Body: ")
    sb.append(bodyStyle)
    sb.append("\n Power: ")
    sb.append(power)
    sb.append("\n Brakes: ")
    sb.append(brakes)
    sb.append("\n Seats: ")
    sb.append(seats)
    sb.append("\n Windows: ")
    sb.append(windows)
    sb.append("\n Fuel Type: ")
    sb.append(fuelType)
    sb.toString()
  }

}

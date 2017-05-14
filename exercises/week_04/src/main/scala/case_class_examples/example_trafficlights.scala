package case_class_examples

/**
  * Created by lucieburgess on 09/02/2017.
  */
class example_trafficlights extends App {

  sealed trait TrafficLight {
    def next: TrafficLight = this match {
      case Red => Amber
      case Amber => Green
      case Green => Red
    }
  }


  final case object Red extends TrafficLight
    //def next = Amber

  final case object Green extends TrafficLight
    //def next = Red

  final case object Amber extends TrafficLight
    //def next = Green

  // write a method next() which takes the colour from Red -> Amber -> Green -> Red
  // use polymorphism
  // use pattern matching

//    def next(col: TrafficLight): TrafficLight = col match {
//      case Red => Amber
//      case Amber => Green
//      case Green => Red
//    }

    //next(Green)

}

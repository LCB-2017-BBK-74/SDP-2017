package factory

/**
  * Created by lucieburgess on 23/02/2017.
  * This defines the interface of objects the factory method creates
  * Could be fields, but I've defined these as methods as a proof of concept
  */
trait DuckProduct {

  def sound: Unit
  def colour: Unit
  def food: Unit
  def wings: Int

}

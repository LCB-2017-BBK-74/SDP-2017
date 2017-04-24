package factory

/**
  * Created by lucieburgess on 14/04/2017.
  */
class ConcreteDuckCreator extends DuckCreator {

  var newDuck: DuckProduct = null

  override def makeADuck(duckType: String) :DuckProduct = {
    if (duckType equals "Mallard") newDuck = new Mallard
    else if (duckType equals "RubberDuck") newDuck = new RubberDuck
    return newDuck
  }

}

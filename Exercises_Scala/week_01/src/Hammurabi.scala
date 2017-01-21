/**
  * Created by lucieburgess on 20/01/2017.
  */
import scala.util.Random
import scala.util.control.Breaks._

/**
  * Created by lucieburgess on 16/01/2017.
  */
object Hammurabi extends App {

  hammurabi

  def hammurabi = {

    var starved = 0
    var immigrants = 5
    var population = 100
    var harvest = 3000
    var bushelsPerAcre = 3
    var rats_ate = 200
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19
    var plagueDeaths = 0

    printIntroductoryMessage()

    for (y <- 1 to 10) {
      println("The year is " + y)
      println("O great Hammurabi! You are in year " + y + " of your ten year rule. ")
      println("In the previous year " + starved + " people starved to death.")
      println("In the previous year " + immigrants + " people entered the kingdom.")
      println("The population is now " + population + ".")
      println("We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.")
      println("Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + " bushels in storage.")
      println("The city owns " + acresOwned + " acres of land.")
      println("Land is currently worth " + pricePerAcre + " bushels per acre.")
      println("There were " + plagueDeaths + " deaths from the plague. ")

      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned += acresToBuy
      bushelsInStorage = bushelsInStorage - (acresToBuy * pricePerAcre)

      /**
        * This function is only called if the player is not buying land
        */
      var acresToSell = 0
      if (acresToBuy == 0) {
        acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned -= acresToSell
        bushelsInStorage += acresToSell*pricePerAcre
      }

      var grainToFeed = askHowMuchGrainToFeedPeople(bushelsInStorage)
      bushelsInStorage -= grainToFeed

      /**
        * Each acre needs 2 bushels of grain to plant it
        */
      var acresToPlant = askHowManyAcresToPlant(acresOwned, bushelsInStorage)
      bushelsInStorage -= (acresToPlant * 2)

      println("Acres to buy stated by Hammurabi is " + acresToBuy)
      println("Acres to sell stated by Hammurabi is " + acresToSell)
      println("Grain to feed stated by Hammurabi is " + grainToFeed)
      println("Acres to plant stated by Hammurabi is" + acresToPlant)

      population = plagueEpidemic(population)

      population -= howManyStarve(population,grainToFeed)


    }

  }

  def printIntroductoryMessage() :Unit = {
    println("""Congratulations, you are the newest ruler of ancient Samaria, elected for a ten year term of office.
      Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.
      Watch out for rat infestations and the plague!
      Grain is the general currency, measured in bushels.
      The following will help you in your decisions:
	    * Each person needs at least 20 bushels of grain per year to survive.
	    * Each person can farm at most 10 acres of land.
	    * It takes 2 bushels of grain to farm an acre of land.
	    * The market price for land fluctuates yearly.
	    Rule wisely and you will be showered with appreciation at the end of your term.
	    Rule poorly and you will be kicked out of office!
	    ==================================================================================================
	    """)
  }

  /**
    * A function which reads user input from the console, prompted by a message. Prevents incorrect characters being entered
    * @param message the question to ask the user
    * @return an int, which has been entered by the user.
    */
  def readNumberFromConsole(message: String) :Int = {
    println(message)
    try
      scala.io.StdIn.readLine().toInt
    catch {
      case _: Throwable =>
        println("That's not an integer, dummy! Please type an integer into the console")
        readNumberFromConsole(message)
    }
  }

  /**
    * A function which asks Hammurabi how much land to buy.
    * acresToBuy cannot be <0 or > bushelsInStorage/price per acre
    * @param bushels, the number of bushels in storage
    * @param price. the market price of land, measured in bushels per acre
    */
  def askHowMuchLandToBuy(bushels:Int, price:Int) :Int = {
    var acresToBuy = readNumberFromConsole("O great Hammurabi, how much land will you buy?")
    while (acresToBuy < 0 || acresToBuy*price > bushels) {
      println("O great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readNumberFromConsole("O great Hammurabi, how much land will you buy?")
    }
    acresToBuy
  }

  /**
    * A function which asks Hammurabi how much land to sell. This function cannot be called if the player is buying
    * land, i.e. if acresToBuy != 0
    * @param acres, the number of acres owned
    */
  def askHowMuchLandToSell(acres:Int) :Int = {
    var acresToSell:Int = readNumberFromConsole("O great Hammurabi, how much land will you sell?")
    while (acresToSell < 0 || acresToSell > acres) {
      println("O great Hammurabi, but we only have " + acres + "available to sell!")
      println("O great Hammurabi please try again!")
      acresToSell = readNumberFromConsole("O great Hammurabi, how much land will you sell?")
    }
    acresToSell
  }

  /**
    * A function which asks Hammurabi how much grain to feed to the people, in bushels
    * This number must be subtracted off bushelsInStorage in the hammurabi function
    * @param bushels, the number of bushels in storage
    * @return
    */
  def askHowMuchGrainToFeedPeople(bushels:Int) :Int = {
    var grainToFeed:Int = readNumberFromConsole("O great Hammurabi, how much grain will you feed to the people?")
    while (grainToFeed < 0 || grainToFeed > bushels) {
      println("O great Hammurabi, there are not enough bushels in storage! You asked for " + bushels + " !")
      println("O great Hammurabi, please try again!")
      grainToFeed = readNumberFromConsole("O great Hammurabi, how much grain will you feed to the people?")
    }
    grainToFeed
  }

  /**
    * A function which asks Hammurabi how many acres to plant, in acres
    * This number * 2 must then be subtracted off bushelsInStorage
    * @param acres, the number of acres already owned
    * @param bushels, the number of bushels of grain in storage. It takes 2 bushels to farm an acre
    * @return acresToPlant, the number of acres to plant with seed
    */
  def askHowManyAcresToPlant(acres:Int, bushels:Int) :Int = {
    var acresToPlant:Int = readNumberFromConsole("O great Hammurabi, how many acres will you plant with seed?")
    while (acresToPlant < 0 || acresToPlant > acres || acresToPlant*2 > bushels) {
      if (acresToPlant > acres)
        println("O great Hammurabi, but there are only " + acres + "acres to plant with seed!")
      else if (acresToPlant*2 > bushels)
        println("O great Hammurabi, but there are only " + bushels + "bushels of grain in storage and you need 2 bushels per acre!")
      else if (acresToPlant < 0)
        println("O great Hammurabi, I'm terribly sorry but it is not possible to enter less than 0 acres to plant!")
      acresToPlant = readNumberFromConsole("O great Hammurabi, how many acres will you plant with seed?")
    }
    acresToPlant
  }

  /**
    * A function which kills 50% of the people of the plague 15% of the time
    * @param currentPopulation, the current population of the kingdom
    */
  def plagueEpidemic(currentPopulation:Int) :Int = {
    var newPopulation:Int = currentPopulation
    if (Random.nextInt(100) < 15) {
      newPopulation = currentPopulation/2
    }
    newPopulation
  }


  /**
    *
    * A function which calculates how many people starve
    * Each person needs 20 bushels of grain to survive. Feeding them more than this, the grain is wasted
    * If more than 45% of people starve you will be immediately thrown out of office and the game ends
    *
    * @param currentPopulation
    * @param grainToFeed
    * @return
    */
  def howManyStarve(currentPopulation:Int, grainToFeed:Int) :Int = {
    var grainRequired:Int = 20*currentPopulation
    var starving = 0
    val peopleFed:Int = grainToFeed / 20
    if (grainToFeed >= grainRequired) return 0 // nobody starves
    else
      starving = currentPopulation - peopleFed
    if (starving > 0.45* currentPopulation) {
      println("O Great Hummurabi your people are starving! Loser! Your rule is OVER!")
      println("GAME OVER =============== GAME OVER ===================== GAME OVER")
      System.exit(0)
    }
    starving
  }

} // Hammurabi
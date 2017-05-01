
/**
  * Created by lucieburgess on 16/01/2017. Updated on 01/05/2017.
  * Program runs fine but some of the logic of the calculations isn't quite right.
  */

import scala.util.Random

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
      println(s"The year is $y")
      println(s"O great Hammurabi! You are in year $y of your ten year rule. ")
      println(s"In the previous year $starved people starved to death.")
      println(s"In the previous year $immigrants people entered the kingdom.")
      println(s"The population is now $population.")
      println(s"We harvested $harvest bushels at $bushelsPerAcre bushels per acre.")
      println(s"Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.")
      println(s"The city owns $acresOwned acres of land.")
      println(s"Land is currently worth $pricePerAcre bushels per acre.")
      println(s"There were $plagueDeaths deaths from the plague.")

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
        bushelsInStorage += acresToSell * pricePerAcre
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

      population -= howManyDiedOfPlague(population)

      starved = howManyStarve(population, bushelsInStorage, harvest)

      population -= starved

      immigrants += immigration(acresOwned, bushelsInStorage, population, starved)

      population += immigrants

      harvest += yearlyHarvest(acresToPlant)

      rats_ate += ratInfestation(bushelsInStorage)

      bushelsInStorage += rats_ate

      pricePerAcre = priceOfLand

    }

    printFinalSummary(starved,immigrants,population,harvest,bushelsPerAcre,rats_ate,bushelsInStorage,acresOwned,pricePerAcre,plagueDeaths)

  } //end of main hammurabi function

    // Helper methods used in the main program

    def printIntroductoryMessage(): Unit = {
      println(
        """Congratulations, you are the newest ruler of ancient Samaria, elected for a ten year term of office.
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
      *
      * @param message the question to ask the user
      * @return an int, which has been entered by the user.
      */
    def readNumberFromConsole(message: String): Int = {
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
      *
      * @param bushels , the number of bushels in storage
      * @param price   . the market price of land, measured in bushels per acre
      */
    def askHowMuchLandToBuy(bushels: Int, price: Int): Int = {
      var acresToBuy = readNumberFromConsole("O great Hammurabi, how much land will you buy?")
      while (acresToBuy < 0 || acresToBuy * price > bushels) {
        println("O great Hammurabi, we have but " + bushels + " bushels of grain!")
        acresToBuy = readNumberFromConsole("O great Hammurabi, how much land will you buy?")
      }
      acresToBuy
    }

    /**
      * A function which asks Hammurabi how much land to sell. This function cannot be called if the player is buying
      * land, i.e. if acresToBuy != 0
      *
      * @param acres , the number of acres owned
      */
    def askHowMuchLandToSell(acres: Int): Int = {
      var acresToSell: Int = readNumberFromConsole("O great Hammurabi, how much land will you sell?")
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
      *
      * @param bushels , the number of bushels in storage
      * @return
      */
    def askHowMuchGrainToFeedPeople(bushels: Int): Int = {
      var grainToFeed: Int = readNumberFromConsole("O great Hammurabi, how much grain will you feed to the people?")
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
      *
      * @param acres   , the number of acres already owned
      * @param bushels , the number of bushels of grain in storage. It takes 2 bushels to farm an acre
      * @return acresToPlant, the number of acres to plant with seed
      */
    def askHowManyAcresToPlant(acres: Int, bushels: Int): Int = {
      var acresToPlant: Int = readNumberFromConsole("O great Hammurabi, how many acres will you plant with seed?")
      while (acresToPlant < 0 || acresToPlant > acres || acresToPlant * 2 > bushels) {
        if (acresToPlant > acres)
          println("O great Hammurabi, but there are only " + acres + "acres to plant with seed!")
        else if (acresToPlant * 2 > bushels)
          println("O great Hammurabi, but there are only " + bushels + "bushels of grain in storage and you need 2 bushels per acre!")
        else if (acresToPlant < 0)
          println("O great Hammurabi, I'm terribly sorry but it is not possible to enter less than 0 acres to plant!")
        acresToPlant = readNumberFromConsole("O great Hammurabi, how many acres will you plant with seed?")
      }
      acresToPlant
    }

    /**
      * A function which kills 50% of the people of the plague 15% of the time
      *
      * @param population, the current population of the kingdom
      */
    def howManyDiedOfPlague(population: Int): Int = {
      var died: Int = 0
      if (Random.nextInt(100) < 15) {
        died = population / 2
      }
      died
    }

    /**
      *
      * A function which calculates how many people starve
      * Each person needs 20 bushels of grain to survive. Feeding them more than this, the grain is wasted
      * If more than 45% of people starve you will be immediately thrown out of office and the game ends
      *
      * @param population, the population at any point in time
      * @param bushels, the number of bushels in storage
      * @return
      */
    def howManyStarve(population: Int, bushels: Int, harvest: Int): Int = {
      var starved = 0
      var grainRequired: Int = 20 * population
      var grainHeld = bushels + harvest
      if (grainHeld >= grainRequired) 0 // nobody starves
      else
        starved += population - (grainHeld/20) //grainHeld/20 is the number of people fed
      if (starved > 0.45 * population) {
        println("O Great Hummurabi your people are starving! Loser! Your rule is OVER!")
        println("GAME OVER =============== GAME OVER ===================== GAME OVER")
        System.exit(0)
      }
      starved
    }

    /**
      *
      * @param acres, the number of acres of land owned
      * @param bushels, the number of bushels in storage
      * @param population, the current population
      * @return
      */
    def immigration(acres: Int, bushels: Int, population: Int, starving: Int): Int = {
      var immigrants = 0
      if (starving == 0) immigrants = 0
      else immigrants = (20 * acres + bushels)/(100 * population) + 1
      immigrants
    }

    def yearlyHarvest(acres: Int): Int = {
      var annualYield = 0
      var random = Random.nextInt(9)
      annualYield = acres*random
      annualYield
    }

    def ratInfestation(bushels: Int): Int  = {
      var ratsEat:Int = 0
      if (Random.nextInt(100) < 40 ) {
        if (Random.nextInt(100) < 20) {
          ratsEat = bushels
        }
      }
      ratsEat
    }

    def priceOfLand: Int = {
      val start = 17
      val end = 23
      val price = start + Random.nextInt(end-start+1)
      price
    }

    def printFinalSummary(starved: Int, immigrants: Int, population: Int, harvest: Int, bushelsPerAcre: Int,
                          rats_ate:Int, bushelsInStorage: Int, acresOwned: Int, pricePerAcre: Int, plagueDeaths: Int): Unit = {
      println(s"O great Hammurabi! You are in year 10 of your ten year rule. ")
      println(s"In the previous year $starved people starved to death.")
      println(s"In the previous year $immigrants people entered the kingdom.")
      println(s"The population is now $population.")
      println(s"We harvested $harvest bushels at $bushelsPerAcre bushels per acre.")
      println(s"Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.")
      println(s"The city owns $acresOwned acres of land.")
      println(s"Land is currently worth $pricePerAcre bushels per acre.")
      println(s"There were $plagueDeaths deaths from the plague.")
      if ((starved < 100) && (acresOwned > 2000)) println("Hammurabi you are a wondrous ruler!")
      else println("Hammurabi you are a loser! You are banished from the Kingdom!")
      println("******************* GAME OVER *********************")

    }




} //Hammurabi

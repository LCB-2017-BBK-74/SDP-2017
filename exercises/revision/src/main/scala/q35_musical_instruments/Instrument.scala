package q35_musical_instruments

/**
  * Created by lucieburgess on 01/06/2017.
  */
sealed trait Instrument {

  val minPitch: Double
  val maxPitch: Double
  def play: String

}

sealed trait StringInstrument extends Instrument {

  val numStrings: Int = 4

  def tune: Boolean = this match {
    case Violin() => true
    case DoubleBass() => true
    case Harp() => true
    case Guitar() => true
    case StringPercussionThing() => false
  }
  override def play: String = this match {
    case Violin() => "Melodic orchestral violin sounds"
    case DoubleBass() => "Deep bassy double bass sounds"
    case Harp() => "Tinkly harp sounds"
    case Guitar() => "Spanish guitar riffs"
  }

}

sealed trait PercussionInstrument extends Instrument {

  val playsSinglePitch: Boolean = true
  val playedLikeDrum: Boolean = false
  val playedUsingStick: Boolean = false

  override def play: String = this match {
    case Xylophone() => "Christmassey glockenspiel sounds"
    case Marimba() => "Wooden xylophone sounds"
    case SnareDrum() => "Funky drum sounds"
    case Castanets() => "Castanet sounds"
    case Tambourine() => "Hey Mr Tambourine Man play a song for me"
  }

}



final case class Violin() extends StringInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 20.0
}

final case class DoubleBass() extends StringInstrument {
  override val minPitch: Double = 2.0
  override val maxPitch: Double = 10.0
}

final case class Harp() extends StringInstrument {
  override val minPitch: Double = 12.0
  override val maxPitch: Double = 30.0
  override val numStrings: Int = 50
}

final case class Guitar() extends StringInstrument {
  override val minPitch: Double = 5.0
  override val maxPitch: Double = 15.0
  override val numStrings: Int = 6
}

final case class Xylophone() extends PercussionInstrument {
  override val minPitch: Double = 5.0
  override val maxPitch: Double = 25.0
  override val playsSinglePitch: Boolean = false
  override val playedLikeDrum: Boolean = false
  override val playedUsingStick: Boolean = true
}

final case class Marimba() extends PercussionInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 20.0
  override val playsSinglePitch: Boolean = false
  override val playedLikeDrum: Boolean = false
  override val playedUsingStick: Boolean = true
}

final case class SnareDrum() extends PercussionInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 10.0
  override val playsSinglePitch: Boolean = true
  override val playedLikeDrum: Boolean = true
  override val playedUsingStick: Boolean = true
}

final case class Castanets() extends PercussionInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 12.0
  override val playsSinglePitch: Boolean = false
  override val playedLikeDrum: Boolean = false
  override val playedUsingStick: Boolean = false
}

final case class Tambourine() extends PercussionInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 12.0
  override val playsSinglePitch: Boolean = false
  override val playedLikeDrum: Boolean = true
  override val playedUsingStick: Boolean = false
}

final case class StringPercussionThing() extends StringInstrument with PercussionInstrument {
  override val minPitch: Double = 10.0
  override val maxPitch: Double = 12.0
  override val playsSinglePitch: Boolean = true
  override val playedLikeDrum: Boolean = true
  override val playedUsingStick: Boolean = false
  override val numStrings: Int = 1

  override def play: String = "Doesn't play like a string or percussion instrument"
}

// Problem here is that we need it to extend both Traits, which it can do
// It needs to implement the def tune method, which is part of the String trait
// But we will have it implement the play method, which is both in String and Percussion, so we'll do that
// as part of the case class
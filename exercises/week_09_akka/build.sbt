name := "week_09_akka"

version := "1.0"

scalaVersion := "2.12.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

lazy val akkaVersion = "2.5.2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
libraryDependencies += "ch.qos.logback" %% "logback-classic" % "1.0.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Add this for error logging - provides default logger
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.22"

// Need to pull this in for reflective capabilities.
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
    
import sbt._
import sbt.Keys._

object Scalabase62Build extends Build {

  lazy val scalabase62 = Project(
    id = "scala-base62",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-base62",
      organization := "com.github.tototoshi",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      scalacOptions := Seq("-feature"),
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "1.9.1" % "test"
      ),
      initialCommands += "import com.github.tototoshi.base62._"
    )
  )
}

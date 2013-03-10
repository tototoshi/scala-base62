import sbt._
import sbt.Keys._

object Scalabase62Build extends Build {

  lazy val scalabase62 = Project(
    id = "scala-base62",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-base62",
      organization := "com.github.tototoshi",
      version := "0.1.0",
      scalaVersion := "2.10.0",
      scalacOptions <<= scalaVersion.map { sv =>
        if (sv.startsWith("2.10.0")) {
          Seq(
            "-deprecation",
            "-language:dynamics",
            "-language:postfixOps",
            "-language:reflectiveCalls",
            "-language:implicitConversions",
            "-language:higherKinds",
            "-language:existentials",
            "-language:reflectiveCalls",
            "-language:experimental.macros"
          )
        } else {
          Seq("-deprecation")
        }
      },
      crossScalaVersions ++= Seq("2.9.0", "2.9.1", "2.9.2", "2.10.0"),
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "1.9.1" % "test"
      ),
      initialCommands += "import com.github.tototoshi.base62._"
    ) ++ publishingSettings
  )

  val publishingSettings = Seq(
    publishMavenStyle := true,
    publishTo <<= version { (v: String) => _publishTo(v) },
    publishArtifact in Test := false,
    pomExtra := _pomExtra
  )

  def _publishTo(v: String) = {
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }

  val _pomExtra =
    <url>http://github.com/tototoshi/scala-base62</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:tototoshi/scala-base62.git</url>
      <connection>scm:git:git@github.com:tototoshi/scala-base62.git</connection>
    </scm>
    <developers>
      <developer>
        <id>tototoshi</id>
        <name>Toshiyuki Takahashi</name>
        <url>http://tototoshi.github.com</url>
      </developer>
    </developers>

}

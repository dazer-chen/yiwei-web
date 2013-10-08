import sbt._

object ProjectBuild extends Build {

  val appName = "yiwei"
  val appVersion = "1.0-SNAPSHOT"

  lazy val testDependencies = Seq(
    "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
    "junit" % "junit" % "4.7" % "test"
  )

  val coreDependencies = Seq(
    "com.jolbox" % "bonecp" % "0.8.0-rc3",
    "org.springframework" % "spring-beans" % "3.2.4.RELEASE",
    "org.springframework" % "spring-jdbc" % "3.2.4.RELEASE"
  )

  //  common lib
  val common = play.Project(
    appName + "-common", appVersion, path = file("common")
  )

  //  jdbc
  val core = play.Project(
    appName + "-core", appVersion, coreDependencies, path = file("core")
  ).dependsOn(common)

  //  web app
  val web = play.Project(
    appName + "-web", appVersion, path = file(".")
  ).dependsOn(core)

}
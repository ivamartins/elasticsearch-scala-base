name := "elasticsearch-scala-base"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.14"

libraryDependencies ++= Seq(
  "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "7.17.21",
  "org.elasticsearch.client" % "elasticsearch-rest-client" % "7.17.21",
  // Test
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)

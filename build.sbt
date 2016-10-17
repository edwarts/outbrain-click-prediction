name := "kaggle-outbrain-comp"

version := "1.0"

scalaVersion := "2.10.4"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// protocol buffer support
// additional libraries
libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.0",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.apache.spark" % "spark-streaming_2.10" % "2.0.1" % "provided",
  "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.2",
  "org.apache.spark" % "spark-core_2.10" % "2.0.1" % "provided",
  "org.apache.spark" %% "spark-sql" % "2.0.1" % "provided",
  "org.apache.spark" %% "spark-hive" % "2.0.1" % "provided",
  "org.apache.commons" % "commons-lang3" % "3.0" % "provided",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.3.3" % "provided",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.3.3" % "provided",
  "com.hadoop.gplcompression" % "hadoop-lzo" % "0.4.17" % "provided",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "com.holdenkarau" %% "spark-testing-base" % "0.0.1" % "test",
  "com.databricks" %% "spark-avro" % "1.0.0" % "provided",
  "com.typesafe" % "config" % "1.3.0",
  "org.specs2" % "specs2_2.10" % "2.4.17" % "test",
  "joda-time" % "joda-time" % "2.8.1",
  "com.databricks" % "spark-csv_2.10" % "1.2.0",
  "org.apache.httpcomponents" % "httpclient" % "4.5.1",
  "com.github.nscala-time" %% "nscala-time" % "1.8.0"

)

resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  Resolver.sonatypeRepo("public")
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) => {
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.startsWith("META-INF") => MergeStrategy.discard
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
  case PathList("org", "apache", xs@_*) => MergeStrategy.first
  case PathList("org", "jboss", xs@_*) => MergeStrategy.first
  case "about.html" => MergeStrategy.rename
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}
}
    
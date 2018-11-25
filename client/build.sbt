name := "client-grpc"

version := "1.0"

scalaVersion := "2.12.6"

lazy val akkaVersion = "2.5.18"
lazy val akkaGrpcVersion = "0.4"

enablePlugins(AkkaGrpcPlugin)
akkaGrpcGeneratedSources := Seq(AkkaGrpc.Client)

// Allow console input in `sbt run`
connectInput in run := true

inConfig(Compile)(Seq(
  PB.protoSources += baseDirectory.value / ".." / "protocol"
))

// ALPN agent
enablePlugins(JavaAgent)
javaAgents += "org.mortbay.jetty.alpn" % "jetty-alpn-agent" % "2.0.7" % "runtime;test"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

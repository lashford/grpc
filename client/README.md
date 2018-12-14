# Greeting Client

The Client is written in Scala using the Akka gRPC libraries for generating the `Scala` client objects .

The protocol definition is located in the following idl `../protocol/greeting.proto`

# Prerequisites

You will need the following core applications installed to build and run the applications, 

* Java JDK 8+
* Sbt / Scala

# Building the code

The Client Greeter objects are generated at compile time using the `AkkaGrpcPlugin` plugin, ths plugin attaches to the compile phase in SBT and puts the compiled Scala classes into the target directory.

```sh
sbt compile
```

Then you can run the client and interact with the console to send messages to the `Greeter Server` 

```sh
sbt run
```

Example of the client running in SBT.

```sh
sbt:client-grpc> run
[info] Running (fork) com.acme.client.GreeterClient
[info] Greeter Client started
[info] ...
[info] Enter your name / or type quit :
alex
[info] Hello alex
quit
[success] Total time: 45 s, completed 14-Dec-2018 16:44:40
```

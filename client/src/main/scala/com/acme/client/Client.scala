package com.acme.client

import scala.concurrent.duration._
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success

import akka.Done
import akka.NotUsed
import akka.actor.ActorSystem
import akka.grpc.GrpcClientSettings
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

import com.acme.generated.greeter._

object GreeterClient extends App {

    implicit val sys = ActorSystem("GreeterClient")
    implicit val mat = ActorMaterializer()
    implicit val ec = sys.dispatcher

    val client = new GreeterServiceClient(GrpcClientSettings.fromConfig("GreeterService"))

    println("Greeter Client started")
    println("...")
    println("Enter your name / or type quit : ")
     // Take console input and send single request to grpc Impl.
    var done = false
    while(!done) {
      val name = readLine()
      if(name.equals("quit")) {
        done=true
      } else {
        makeHelloRequest(name).onComplete {
          case Success(res) =>
            println(res.message)
            println("Enter your name  / or type quit : ")
          case Failure(e) =>
            println(s"Error: $e")
            println("Enter your name  / or type quit : ")
        }
      }
    }

    // shut down the ActorSystem
    sys.terminate

    def makeHelloRequest(name: String) = client.sayHello(HelloRequest(name))
}

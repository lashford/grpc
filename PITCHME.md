
# GRPC

What is good for ...

---

### What is it?

gRPC is a transport mechanism for request/response and (non-persistent) streaming use cases. It is a schema-first RPC framework, where the protocol is declared in a protobuf IDL descriptor and requests / responses will be streamed over an HTTP/2 connection.

---

## The Pro's 

* Schema-first design for `Messages` and `Services`
* Protobuf allows for compatible schema evolution
* Efficient use of HTTP/2, allows multiplexing of data streams
* Language agnostic providing interoperability
* Streaming is a first-class citizen

---

## The Con's

* Increased Develpoment Effort
* Tooling still improving
* Generated code
* Synchronous Communication

---

## gRPC all the things!!!

*  If there is a `Well` definied connection between internal services
*  If you reqire a Structured way to serve data to a front-end
*  To encapusulate a specialist bit of code in a different language

---

## Old News

* CORBA
  * Can pass Object reference!!!!!!
  * Built on GIOP/IIOP - TCP based protocol

---

## Clean me up

** Is this not just SOAP **

Although SOAP allows you to define a structure and message for communication between Client / Server, as well as generate implementations in various langugaes, there is no ability to evolve the definition without creating new routes or wsdl versions. The Transport mechanism is also built upon TCP/IP compaired with HTTP/2 in gRPC.

---

## Get on the BUS

Whilst gRPC is built on an efficient non-blocking implementation, gRPC is still `synchronous` in the sense that it requires both client and server to be available at the same time.

* Kafka
 * Decoupled Intergration
 * Structured Messages using Protobuf
 * High latency

---

## Magical Unicorn Scenario

Imagine you have a magical highly performant function that is embedded in the DotNet Framework and you need to expose that functionality to a set of services in your micro-service architecture. 

** gRPC to the rescue!!! **

---

## Demo Time
```asci
             +---------+                  +--------+
+-----+      |         |                  |        |
|  C  |      |  Scala  |   gRPC (HTTP/2)  | Dotnet |
|  O  |      |  (jvm)  +------------------+  Core  |
|  N  |      |         |                  |        |
|  S  +------>         |   HelloRequest   |        |
|  O  |      |         +------------------>        |
|  L  |      |         |                  |        |
|  E  |      |         |   HelloResponse  |        |
+-----+      |         <------------------+        |
             +---------+                  +--------+
```



# Protocol Definitions

gRPC uses the Protobuf .proto file format to define your messages, services and some aspects of the code generation. Protobuf provides a schema for defiing communication between services which provides structure and improtantly schema evolution.

You can define both `Messages` & `Services` within the Proto files, for example:

```
// The request message containing the user's name.
message HelloRequest {
    string name = 1;
}
```

```
// The response message containing the greetings
message HelloReply {
    string message = 1;
}
```

```
// The greeting service definition.
service GreeterService {
    // Sends a greeting
    rpc SayHello (HelloRequest) returns (HelloReply) {}
}
```

These `proto` files can then be used to generate `client` and `server` services as well as the models required for all calls, there are genrerators in a multitude of languages.  

### The Smelly bits..

As with all code generation there can be problems we the generated code, Proto offers some customisation options for the generation,

i.e
```
option java_multiple_files = true;
option java_package = "example.myapp.helloworld.grpc";
option java_outer_classname = "HelloWorldProto";
```

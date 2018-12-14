# Greeting Server

The Server is written in DotNet Core 2.1 and uses the offical GRPC libraries for generating the C# bindings.

The protocol definition is located in the following idl `../protocol/greeting.proto`

# Prerequisites

You will need the DotNet Core runtime installed 

```sh
https://docs.microsoft.com/en-us/dotnet/core/macos-prerequisites?tabs=netcore2x
```

# Setup Instructions

Download all the required dependancies
```sh
dotnet restore
```

Generate the C# files from the proto definitions, these will be created in the `Generated` folder.
```sh
./generateProto.sh
```

Compile and Package the Source
```
dotnet build
```

Run the Server app
```
dotnet run --framework netcoreapp2.1
```

Example of the running server
```
Acme.GreeterServer git:(master) dotnet run --framework netcoreapp2.1

Greeter Server listening on 127.0.0.1:50051
Press any key to stop the server...

Received Msg from : alex responding with -> Hello alex
```

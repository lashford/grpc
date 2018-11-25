# Greeting Server

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

#!/bin/bash

PROTODIR=../../protocol
PROTOFILE=../../protocol/greeting.proto
PROTOC=~/.nuget/packages/Google.Protobuf.Tools/3.6.1/tools/macosx_x64/protoc
PLUGIN=~/.nuget/packages/grpc.tools/1.14.1/tools/macosx_x64/grpc_csharp_plugin

$PROTOC -I$PROTODIR --csharp_out Generated $PROTOFILE --grpc_out Generated --plugin=protoc-gen-grpc=$PLUGIN 


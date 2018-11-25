using System;
using System.Threading.Tasks;
using Grpc.Core;
using Greeting;

namespace Acme.GreeterServer
{
    class GreeterImpl : GreeterService.GreeterServiceBase
    {
        // Server side handler of the SayHello RPC
        public override Task<HelloReply> SayHello(
            HelloRequest request, ServerCallContext context)
        {
            var msg = "Hello " + request.Name; 
            Console.WriteLine("Received Msg from : " + request.Name + " responding with -> " + msg);
            return Task.FromResult(new HelloReply { Message = msg});
        }
    }

    class GreeterServer
    {
        const int Port = 50051;
        const string Address = "127.0.0.1";

        public static void Main(string[] args)
        {
            Server server = new Server
            {
                Services = { GreeterService.BindService(new GreeterImpl()) },
                Ports = { new ServerPort(Address, Port, ServerCredentials.Insecure) }
            };
            server.Start();
            Console.WriteLine("\nGreeter Server listening on " + Address + ":" + Port);
            Console.WriteLine("Press any key to stop the server...\n");
            Console.ReadKey();
            server.ShutdownAsync().Wait();
        }
    }
}
import com.trungtin.grpc.HelloRequest;
import com.trungtin.grpc.HelloResponse;
import com.trungtin.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Trung")
                .setLastName("Tin")
                .build());

        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}

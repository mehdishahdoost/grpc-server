package com.github.mehdishahdoost;

import com.github.mehdishahdoost.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author Mehdi Shahdoost
 */
public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
        server.start();
        System.out.printf("Server start with port: %d", server.getPort());
        server.awaitTermination();
    }
}

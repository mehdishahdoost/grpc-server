package com.github.mehdishahdoost.user;

import com.github.mehdishahdoost.grpc.User;
import com.github.mehdishahdoost.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author Mehdi Shahdoost
 */
public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");
        String username = request.getUsername();
        String password = request.getPassword();
        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if (username.equals(password)) {
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        } else {
            response.setResponseCode(100).setResponseMessage("FAILED");
        }
        responseObserver.onNext(response.build());
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}

package com.example.weatherdemoapplication.service.impl;

import com.example.weatherdemoapplication.auth.AuthProtos;
import com.example.weatherdemoapplication.auth.AuthServiceGrpc;
import com.example.weatherdemoapplication.exception.UnauthorizedException;
import com.example.weatherdemoapplication.service.AuthService;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public void checkAccess(String username) {

        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
        AuthProtos.LoginResponse login = stub.login(AuthProtos.LoginRequest.newBuilder().setUsername(username).build());
        if (!login.getOk()) {
            throw new UnauthorizedException();
        }
        log.info("{} successfully login", username);
    }
}

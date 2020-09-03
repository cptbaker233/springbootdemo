package com.pactera.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    @Value("${server.port}")
    int port;

    public int getPort() {
        return port;
    }
}
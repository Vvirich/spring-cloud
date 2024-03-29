package com.training.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudServerApplication.class, args);
    }
}

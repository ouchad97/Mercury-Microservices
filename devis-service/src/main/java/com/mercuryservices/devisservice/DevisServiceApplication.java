package com.mercuryservices.devisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaServer
public class DevisServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(DevisServiceApplication.class, args);
    }
}

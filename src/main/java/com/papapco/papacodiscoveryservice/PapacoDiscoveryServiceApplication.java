package com.papapco.papacodiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PapacoDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapacoDiscoveryServiceApplication.class, args);
    }

}

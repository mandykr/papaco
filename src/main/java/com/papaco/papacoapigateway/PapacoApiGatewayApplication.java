package com.papaco.papacoapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PapacoApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapacoApiGatewayApplication.class, args);
    }

}

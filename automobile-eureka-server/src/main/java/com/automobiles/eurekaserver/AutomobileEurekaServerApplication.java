package com.automobiles.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AutomobileEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomobileEurekaServerApplication.class, args);
	}

}

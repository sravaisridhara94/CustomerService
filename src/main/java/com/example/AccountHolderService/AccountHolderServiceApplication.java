package com.example.AccountHolderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountHolderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountHolderServiceApplication.class, args);
	}

}

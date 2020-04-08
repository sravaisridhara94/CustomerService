package com.example.customerservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Customer Service Controller
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@SpringBootApplication
@EnableEurekaClient
public class AccountHolderServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountHolderServiceApplication.class, args);
	}

}

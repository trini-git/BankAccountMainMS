package com.bankaccountmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankAccountMainMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountMainMsApplication.class, args);
	}

}

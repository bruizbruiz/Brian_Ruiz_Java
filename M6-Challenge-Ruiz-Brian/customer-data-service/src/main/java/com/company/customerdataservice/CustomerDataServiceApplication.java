package com.company.customerdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller", "model", "repository"})
public class CustomerDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDataServiceApplication.class, args);
	}

}

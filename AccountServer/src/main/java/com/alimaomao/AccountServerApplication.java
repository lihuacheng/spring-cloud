package com.alimaomao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServerApplication.class, args);
	}
}

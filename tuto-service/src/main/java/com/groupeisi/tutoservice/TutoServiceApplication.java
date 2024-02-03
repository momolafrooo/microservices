package com.groupeisi.tutoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TutoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoServiceApplication.class, args);
	}

}

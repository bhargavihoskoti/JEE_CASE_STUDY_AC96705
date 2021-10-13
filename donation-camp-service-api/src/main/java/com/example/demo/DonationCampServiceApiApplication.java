package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info =@Info(title="Blood Camp Management Service",version="1.0"))
public class DonationCampServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationCampServiceApiApplication.class, args);
	}

}

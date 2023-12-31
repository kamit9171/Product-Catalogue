package com.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@EnableAutoConfiguration
@EnableJpaRepositories
public class ProductCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueApplication.class, args);
		System.out.println("The Product Application is Running on 8080");
	}

}

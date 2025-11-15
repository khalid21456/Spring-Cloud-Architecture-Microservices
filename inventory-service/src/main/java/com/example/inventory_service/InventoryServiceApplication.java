package com.example.inventory_service;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	//@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder()
					.name("Pc").price(500.5).quantity(5).build());
			productRepository.save(Product.builder()
					.name("Iphon").price(5000.5).quantity(9).build());
		};
	}
}

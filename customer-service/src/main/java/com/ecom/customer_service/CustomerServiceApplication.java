package com.ecom.customer_service;

import com.ecom.customer_service.entities.Customer;
import com.ecom.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
					.name("Khalid").email("khalid@gmail.com").build());
			customerRepository.save(Customer.builder()
					.name("hamza").email("hamza@gmail.com").build());
			customerRepository.save(Customer.builder()
					.name("amine").email("amine@gmail.com").build());
		};
	}
}

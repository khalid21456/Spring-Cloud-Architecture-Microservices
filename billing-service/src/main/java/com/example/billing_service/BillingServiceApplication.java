package com.example.billing_service;

import com.example.billing_service.entities.Bill;
import com.example.billing_service.entities.ProductItem;
import com.example.billing_service.models.Product;
import com.example.billing_service.repository.BillRepository;
import com.example.billing_service.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	//@Bean
	public CommandLineRunner commandLineRunner(BillRepository billRepository,
											   ProductItemRepository productItemRepository) {
		return args -> {
			List<UUID> customersId = List.of(UUID.fromString("eeeeb11f-6e02-4480-a949-1519e1aadd28"),
											UUID.fromString("37476d9f-c42c-4234-a190-3752799cd397"),
											UUID.fromString("10f37337-c403-43b0-aaa5-04660208cf59"));
			List<UUID> productIds = List.of(UUID.fromString("9366f252-ca59-4b55-a99b-7e4bc332c566"),
											UUID.fromString("6f598e65-d606-47d6-affa-5914286514c7"),
											UUID.fromString("0a896206-6856-4df3-b789-dad9c86d5cb6"));
			customersId.forEach(clientId -> {
				Bill bill = new Bill();
				bill.setBillingDate(new Date());
				bill.setCustomerId(clientId);
				billRepository.save(bill);
				productIds.forEach(productId ->{
					ProductItem productItem = new ProductItem();
					productItem.setPrice(1000*Math.random()*600);
					productItem.setQuantity(1+new Random().nextInt(20));
					productItem.setProductId(productId);
					productItem.setBill(bill);
					productItemRepository.save(productItem);
				});
			});
		};
	}
}

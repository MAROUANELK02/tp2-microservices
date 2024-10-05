package com.marouaneLK.inventory_service;

import com.marouaneLK.inventory_service.entities.Product;
import com.marouaneLK.inventory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("TV").price(1500.0).quantity(15).build(),
					Product.builder().name("Mobile").price(2500.0).quantity(10).build(),
					Product.builder().name("Fridge").price(3500.0).quantity(5).build()
			));
		};
	}

}

package com.marouaneLK.customer_service;

import com.marouaneLK.customer_service.entities.Customer;
import com.marouaneLK.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Hamid").email("hamdi@mail.com").build(),
					Customer.builder().name("Said").email("said@mail.com").build(),
					Customer.builder().name("Hanane").email("hanane@mail.com").build()
			));
		};
	}
}

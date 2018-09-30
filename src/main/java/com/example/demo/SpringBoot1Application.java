package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.Address;
import com.example.demo.dao.Card;
import com.example.demo.dao.Customer;
import com.example.demo.service.CustomerService;


@SpringBootApplication
public class SpringBoot1Application {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBoot1Application.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerService cs){
		return (args) -> {
			Customer c = new Customer();
			c.setName("Neha");
			Address a1 = new Address();
			a1.setAddressLine1("test");
			a1.setAddressLine2("test2");
			a1.setPostCode("AB1224");
			c.setAddress(a1);
			Card c1 = new Card();
			c1.setCardNumber("1234-5678-9123");
			List<Card> l = new ArrayList();
			l.add(c1);
			c.setCard(l);
			cs.addCustomer(c);
			
			
			// fetch all customers
						log.info("Customers found with findAll():");
						log.info("-------------------------------");
						System.out.println("Total number of customers"+ cs.getAllCustomers().size());
						cs.getAllCustomers().forEach(System.out::println);
		};
	}
	
	/*
	@Bean
	public CommandLineRunner demo(Customer1Repository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer1("Jack", "Bauer"));
			repository.save(new Customer1("Chloe", "O'Brian"));
			repository.save(new Customer1("Kim", "Bauer"));
			repository.save(new Customer1("David", "Palmer"));
			repository.save(new Customer1("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer1 customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	*/
}

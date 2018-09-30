package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.Address;
import com.example.demo.dao.Card;
import com.example.demo.dao.Customer;
import com.example.demo.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void whenFindByName_thenReturnCustomer(){
		Customer c = new Customer();
		c.setName("Test");
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
		
		entityManager.persist(c);
		entityManager.flush();
		
		Optional<Customer> found = customerRepository.findById(1L);
		assertTrue(found.isPresent());
		assertTrue(found.get().getName().equals("Test"));
	}
 
}

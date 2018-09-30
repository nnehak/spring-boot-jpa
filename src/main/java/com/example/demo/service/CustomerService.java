package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<String> getAllCustomers(){
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers.stream().map(Customer::getName).collect(Collectors.toList());
	}
	
	public Customer addCustomer(Customer c){
		return customerRepository.save(c);
	}

}

package com.example.demo.repository;

import java.util.List;

import com.example.demo.dao.Customer1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer1Repository extends CrudRepository<Customer1, Long> {
	List<Customer1> findByLastName(String lastName);

}

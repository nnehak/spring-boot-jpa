package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}

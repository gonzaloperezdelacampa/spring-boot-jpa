package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

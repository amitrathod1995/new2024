package com.edusol.Delivery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.Delivery.module.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	List<Customer> findByCity(String city);

	List<Customer> findByName(String name);
}

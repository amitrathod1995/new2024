package com.edusol.Delivery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusol.Delivery.module.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer>{

	List<Product>findById(int id);
	List<Product>findByCategory(String category);
	List<Product>findByPrice(float price);
	List<Product>findByPriceAndCategory(float price,String category);
	List<Product>findByPriceBetween(float min,float max);
	List<Product>findByPriceBetweenAndCategory(float min,float max,String category);
	List<Product>findByCustomerId(int id);
}

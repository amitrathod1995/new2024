package com.edusol.Productss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.Productss.model.Productss;

public interface ProductssRepository extends JpaRepository<Productss ,Integer>{

	List<Productss> findByCategory(String category);

	List<Productss> findByPrice(float price);

	List<Productss> findByPriceAndCategory(float price, String category);

	List<Productss> findByPriceBetween(float min, float max);

	List<Productss> findByPriceBetweenAndCategory(float min, float max, String category);


}

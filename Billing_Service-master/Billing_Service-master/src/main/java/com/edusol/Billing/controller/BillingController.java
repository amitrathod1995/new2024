package com.edusol.Billing.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.Billing.model.Product;
import com.edusol.Billing.service.BillingService;

@RestController
@RequestMapping("/Billing")
public class BillingController {
	
	@Autowired
	BillingService billingservice;

	@GetMapping("/get-products")
	public ResponseEntity<Product[]> getProducts() {
		
		return billingservice.getProducts();	
	}
	
	@GetMapping("/get-product-by-id")
	public ResponseEntity<Product[]> getProductById(@RequestParam int id){
		
	return billingservice.getProductById(id);
	}
	
	@GetMapping("get-product-by-category")
	public ResponseEntity<Product[]> getProductByCategory(@RequestParam String category){
		
		return billingservice.getProductByCategory(category);
		}
	
	@GetMapping("/get-product-by-price")
	public ResponseEntity<Product[]> getProductByPrice(@RequestParam float price) {
		
		return billingservice.getProductByPrice(price);
		
	}
	
	@GetMapping("/get-products-by-price-and-category")
	public ResponseEntity<Product[]> getProductByPriceAndCategory(@RequestParam float price,@RequestParam String category) {
		
	return billingservice.getProductByPriceAndCategory(price,category);
	}
	
	
	@GetMapping("/get-products-by-price-range")
	public ResponseEntity<Product[]> getProductByPricerange(@RequestParam float min,@RequestParam float max) {
		
	return billingservice.getProductByPriceRange(min,max);
	}
	
	@GetMapping("/get-products-by-pricerange-and-category")
	public ResponseEntity<Product[]> getProductByPricerangeAndCategory(@RequestParam float min,@RequestParam float max,@RequestParam String category) {
		
	return billingservice.getProductByPricerangeAndCategory(min,max,category);
	}
	@PostMapping("/save-record")
	public String saveRecord(@RequestBody Product p) {
		return billingservice.saveRecord (p);
	}
	
	@PutMapping("/update-record")
	public String updateRecord(@RequestBody Product p) {
		return billingservice.updateRecord (p);
	}
	
	@DeleteMapping("/delete-record")
	public String deleteRecord(@RequestParam int id) {
		return billingservice.deleteRecord (id);
		
		
	}
	
	
	}


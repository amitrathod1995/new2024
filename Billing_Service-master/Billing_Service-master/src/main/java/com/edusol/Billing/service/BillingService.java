package com.edusol.Billing.service;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.Billing.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BillingService {

	
	@Autowired
	RestTemplate template;
	public ResponseEntity<Product[]> getProducts() {
	
		final String url = "http://localhost:8181/products/get-products";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);
		
		List<Product> products =Arrays.asList(response.getBody());
		
		System.out.println(products.toString());
		
		return response;
	}
	
	public ResponseEntity<Product[]> getProductById(int id) {
		
		final String url = "http://localhost:8181/products/get-products-by-id?id="+id;

		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

		//Product products = response.getBody();
		List<Product> products =Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}

	public ResponseEntity<Product[]> getProductByCategory(String category) {
		
		final String url = "http://localhost:8181/products/get-products-by-category?category="+category;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

		List<Product> products =Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}

	public ResponseEntity<Product[]> getProductByPrice(float price) {
		
		final String url = "http://localhost:8181/products/get-products-price?price="+price;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);
		
		List<Product> products =Arrays.asList(response.getBody());
		
		System.out.println(products.toString());
		
		return response;
	}

	public ResponseEntity<Product[]> getProductByPriceAndCategory(float price,String category) {
		
		
		final String url="http://localhost:8181/products/get-products-by-price-and-category?price="+price+"&category="+category;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

		List<Product> products =Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}

	public ResponseEntity<Product[]> getProductByPriceRange(float min, float max) {

		final String url="http://localhost:8181/products/get-products-by-price-range?min="+min+"&max="+max;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

		List<Product> products =Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}
	
	public ResponseEntity<Product[]> getProductByPricerangeAndCategory(float min, float max, String category) {

		final String url="http://localhost:8181/products/get-products-by-price-rangeand-category?min="+min+"&max="+max+"&category="+category;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

		List<Product> products =Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}
	
	@HystrixCommand(fallbackMethod = "showResponse", commandProperties = {
			@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
	//@HystrixCommand(fallbackMethod = "showResponse")
	public String saveRecord(Product p) {

		final String url ="http://localhost:8181/products/add-products";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(p, headers);
				
		return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	public String showResponse(Product p) {
		return "Request fails. It takes long time to response";
		}
	
	public String updateRecord(Product p) {
		
		final String url ="http://localhost:8181/products/update-products";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(p, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
	}

	public String deleteRecord(int id) {
		
		final String url ="http://localhost:8181/products/delete-products?id="+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

	
	}


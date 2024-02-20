package com.example.DeliveryDetails.Service;

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
import com.example.DeliveryDetails.model.Customer;
import com.example.DeliveryDetails.model.Product;

@Service
public class DeliveryDetailsService {

	@Autowired
	RestTemplate template;
	
	public ResponseEntity<Product[]> getProducts() {
		final String url = "http://localhost:1212/api/product/get-products";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);
		
		List<Product> products =Arrays.asList(response.getBody());
		
		System.out.println(products.toString());
		
		return response;
	}
	
	public ResponseEntity<Product[]> getProductById(int id) {
		final String url = "http://localhost:1212/api/product/get-product-by-id?id="+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);
		
		List<Product> products =Arrays.asList(response.getBody());
		
		System.out.println(products.toString());
		
		return response;
	}

	public ResponseEntity<Customer> getCustomerById(int id) {
		final String url = "http://localhost:1212/api/customer/get-customer-by-id?id="+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer> response = template.exchange(url, HttpMethod.GET, entity, Customer.class);
		
		List<Customer> customers =Arrays.asList(response.getBody());
		
		System.out.println(customers.toString());
		
		return response;
	}


	public ResponseEntity<Customer[]> getCustomers() {
		final String url = "http://localhost:1212/api/customer/get-customers";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);
		
		List<Customer> customers =Arrays.asList(response.getBody());
		
		System.out.println(customers.toString());
		
		return response;
	}

	public String addProduct(Product p) {
    final String url ="http://localhost:1212/api/product/add-product";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(p, headers);
				
		return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	//=================================================================================
	public ResponseEntity<Product[]> getProductbyCustomerid(Integer id) {
		final String url = "http://localhost:1212/api/product/get-product-by-cuctomer-id?id="+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity <String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);
		
		List<Product> product =Arrays.asList(response.getBody());
		
		System.out.println(product.toString());
		
		return response;
	}
	//========================================================================================
	public String addCustomer(Customer c) {
		 final String url ="http://localhost:1212/api/customer/add-customer";
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
			HttpEntity <Customer> entity = new HttpEntity<Customer>(c, headers);
					
			return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
		}

	public String updateproduct(Product p) {
		final String url ="http://localhost:1212/api/product/update-product";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(p, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
	}

	public String updateCustomer(Customer c) {
		final String url ="http://localhost:1212/api/customer/update-customer";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Customer> entity = new HttpEntity<Customer>(c, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
	}

	public String deleteRecord(int id) {
		final String url ="http://localhost:1212/api/product/delete-product?id="+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Product> entity = new HttpEntity<Product>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

	public String deleteCustomer(int id) {
		final String url ="http://localhost:1212/api/customer/delete-customer?id="+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity <Customer> entity = new HttpEntity<Customer>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

	

	
	

	 
}

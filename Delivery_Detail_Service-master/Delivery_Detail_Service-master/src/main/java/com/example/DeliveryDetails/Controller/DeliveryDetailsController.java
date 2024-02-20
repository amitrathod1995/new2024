package com.example.DeliveryDetails.Controller;

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
import com.example.DeliveryDetails.Service.DeliveryDetailsService;
import com.example.DeliveryDetails.model.Customer;
import com.example.DeliveryDetails.model.Product;

@RestController
@RequestMapping("/DeliveryDetails")
public class DeliveryDetailsController {

	@Autowired
	DeliveryDetailsService deliverydetailsService;
	
	@GetMapping("/get-product-by-id")
	public ResponseEntity<Product[]> getProductById(@RequestParam int id){
		
	return deliverydetailsService.getProductById(id);
}
	@GetMapping("/get-products")
	public ResponseEntity<Product[]> getProducts() {
		
		return deliverydetailsService.getProducts();	
	}
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody Product p) {
		return deliverydetailsService.addProduct (p);
	}
	
	@PutMapping("/update-product")
	public String updateproduct(@RequestBody Product p) {
		return deliverydetailsService.updateproduct (p);
	}
	
	@DeleteMapping("/delete-product")
	public String deleteRecord(@RequestParam int id) {
		return deliverydetailsService.deleteRecord (id);
			
	}
	
	//============================================================================
	
	@GetMapping("/get-customer-by-id")
	public ResponseEntity<Customer> getCustomerById(@RequestParam int id)  {
		
		return deliverydetailsService.getCustomerById(id);	
	}
	@GetMapping("/get-customers")
	public ResponseEntity<Customer[]> getCustomers() {
		
		return deliverydetailsService.getCustomers();	
	}
	
	@PostMapping("/add-customer")
	public String addCustomer(@RequestBody Customer c) {
		return deliverydetailsService.addCustomer (c);
	}
	
	@PutMapping("/update-customer")
	public String updatecustomer(@RequestBody Customer c) {
		return deliverydetailsService.updateCustomer (c);
	}
	
	@DeleteMapping("/delete-customer")
	public String deletecustomer(@RequestParam int id) {
		return deliverydetailsService.deleteCustomer (id);
	}
	//==============================================================================
	@GetMapping("/get-products-By-Customer-id")
	public ResponseEntity<Product[]> getProductbyCustomerid(@RequestParam Integer id) {
		
		return deliverydetailsService.getProductbyCustomerid(id);	
	}
}

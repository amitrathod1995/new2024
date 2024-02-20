package com.edusol.customer.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.customer.model.Customer;
import com.edusol.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get-customers")

	public Object getCustomers() {
		@SuppressWarnings("unchecked")
		List<Customer> customer = (List<Customer>) customerService.getCustomers();
		logger.info(customer.toString());

		return (customer);	//customerService.getCustomers();

	}
	@GetMapping("/get-customer-name-by-starting-character")
	public Object getnamebystartingcharacter(@RequestParam (value="name")String name)
	{List<Customer> customer = (List<Customer>) customerService.getnamebystartingcharacter(name);
		return (customer);
		
	}

	@GetMapping("/get-customer-by-city")
	public Object getCustomerCity(@RequestParam(value="city")String city) {
		@SuppressWarnings("unchecked")
		List<Customer> customer = (List<Customer>) customerService.getCustomerCity(city);
		logger.info(customer.toString());
		return (customer); //customerService.getCustomerCity(city);

	}

	@GetMapping("/get-customer-by-id")
	public Object getCustomerId(@RequestParam(value="id") int id) {
		Object customer = customerService.getCustomerId(id);
		logger.info(customer.toString());
		return (customer); //customerService.getCustomerId(id);
	}

	@GetMapping("/get-customer-by-name")
	public Object getCustomerByName(@RequestParam(value="name") String name) {
		@SuppressWarnings("unchecked")
		List<Customer> customer = (List<Customer>) customerService.getCustomerByName(name);
		logger.info(customer.toString());
		return (customer); //customerService.getCustomerByName(name);

	}

	@PostMapping("/add-customer")
	public Object addCustomer(@RequestBody Customer customer) {
		logger.info(customer.toString());
		return customerService.addCustomer(customer);
	}

	@PutMapping("/update-customer")
	public Object updateCustomer(@RequestBody Customer customer) {
		logger.info("Customer Details Updated"+customer.toString());
		return customerService.updateCustomer(customer);

	}

	@DeleteMapping("/delete-customer")
	public Object deleteCustomer(@RequestParam(value="id")int id) {
		logger.info("Customer id"+id);
		return customerService.deleteCustomer(id);
	}

}

package com.edusol.customer.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.edusol.customer.model.Customer;
import com.edusol.customer.repository.CustomerRepository;
//import com.google.gson.JsonObject;

@Service
public class CustomerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	CustomerRepository customerRepository;
	//@Scheduled(cron="0 9 18 * * ?",zone="IST")
	public Object getCustomers() {

		List<Customer> customer = customerRepository.findAll();
		logger.info(customer.toString());
		System.out.println("schedules time");
		return customerRepository.findAll();
	}

	public List<Customer> getnamebystartingcharacter(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findAll().stream()
				.filter(cus->cus.getName().startsWith(name)).collect(Collectors.toList());
	}
	
	public Object getCustomerCity(String city) {
		//List<Customer> customer = customerRepository.findByCity(city);
		//logger.info(customer.toString());
		return customerRepository.findAll()
			    .stream()
			    .filter(user -> user.getCity().equalsIgnoreCase(city))
			    .collect(Collectors.toList());
	}

	public Object getCustomerId(int id) {
		//List<Customer> customer = (List<Customer>) customerRepository.findById(id);
		//logger.info(customer.toString());
		return customerRepository.findById(id);
	}

	public Object getCustomerByName(String name) {
		//List<Customer> customer = customerRepository.findByName(name);
		//logger.info(customer.toString());
		//return customerRepository.findByName(name);
		return customerRepository.findAll()
			    .stream()
			    .filter(user -> user.getName().equalsIgnoreCase(name))
			    .collect(Collectors.toList());
	}
	

	public Object addCustomer(Customer customer) {
		logger.info(customer.toString());
		customerRepository.save(customer);
		logger.info("Customer Added Successfully");
		return new ResponseEntity<>("Customer added Successfully",HttpStatus.CREATED);

	}

	
	public Object updateCustomer(Customer customer) {
        // Update logic using Stream API
		customerRepository.findAll()
                .stream()
                .filter(cust -> customer.getId() == customer.getId())
                .findFirst()
                .ifPresent(cust -> {
                	customer.setCity(customer.getCity());
            		customer.setName(customer.getName());
            		customer.setEmail(customer.getEmail());
            		customer.setAddress(customer.getAddress());
            		customer.setPhoneno(customer.getPhoneno());
                    // Update other fields as needed
            		customerRepository.save(customer); // Save the updated entity
                });
		return new ResponseEntity<>("Customer Updated Successfully",HttpStatus.OK);
    }
	/*public Object updateCustomer(Customer customer) {
		JsonObject response = new JsonObject();

		System.out.println("Request customer:" + customer);
		int id = customer.getId();
    try {
		Customer cust = customerRepository.getOne(id);
		System.out.println("Request customer:" + cust);

		System.out.println("old customer:" + cust);
		cust.setCity(customer.getCity());
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setAddress(customer.getAddress());
		cust.setPhoneno(customer.getPhoneno());
		System.out.println("New customer:" + cust);
		customerRepository.save(cust);
   }
    catch (Exception e) {
    	logger.error(e.getMessage());
	response.addProperty("statusCode", 404);
	response.addProperty("statusMessage", e.getMessage());
	return new ResponseEntity<>(response.toString(),HttpStatus.NOT_FOUND);
    }
    logger.info("Customer Updated Successfully");
	return new ResponseEntity<>("Customer Updated Successfully",HttpStatus.OK);
	}*/

	public Object deleteCustomer(int id) {
		try {
		customerRepository.deleteById(id);
		}
		catch(Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	logger.info("Customer deleted Successfully");
	return new ResponseEntity<>("Customer deleted Successfully",HttpStatus.OK);
	}

	

	/*
	 * List<Customer> customerList = new ArrayList<>();
	 *
	 * public Object getCustomers() { if (customerList.isEmpty()) { return
	 * "No customer found"; }
	 *
	 * return customerList;
	 *
	 * }
	 *
	 * public Object addCustomer(Customer customer) {
	 *
	 * customerList.add(customer); return "Customer added Successfully";
	 *
	 * }
	 *
	 * public Object getCustomer(String customerCity) { // TODO Auto-generated
	 * method stub if (customerList.isEmpty()) { return "No customer found"; }
	 *
	 * // List<Customer> customers = new ArrayList<>();
	 *
	 * /* for(Customer cust:customerList) {
	 * if(cust.getCustomerCity().equalsIgnoreCase(city)) { customers.add(cust); } }
	 */

	/*
	 * List<Customer> customers = customerList.stream().filter(c ->
	 * c.getCustomerCity().equalsIgnoreCase(customerCity))
	 *
	 * .collect(Collectors.toList());
	 *
	 * if (customers.isEmpty()) { return "No customer Found "; }
	 *
	 * return customers; }
	 *
	 * public Object updateCustomer(Customer customer) {
	 *
	 * boolean flag = false;
	 *
	 * if (customerList.isEmpty()) { return "No customer found";
	 *
	 * }
	 *
	 * for (Customer cust : customerList) { if (cust.getCustomerId() ==
	 * customer.getCustomerId()) { customerList.remove(cust);
	 * customerList.add(customer);
	 *
	 * flag = true; break; } }
	 *
	 * if (flag == false) { return "Customer data is not availabe"; }
	 *
	 * return "Customer Added successfully"; }
	 *
	 * public Object deleteCustomer(int customerId) {
	 *
	 * boolean flag = false;
	 *
	 * if (customerList.isEmpty()) { return "No customer found";
	 *
	 * }
	 *
	 * for (Customer cust : customerList) { if (cust.getCustomerId() == customerId)
	 * { customerList.remove(cust); flag = true; break;
	 *
	 * } } if (flag == false) { return "Customer data is not availabe";
	 *
	 * } return "Customer Deleted successfully"; }
	 */
}

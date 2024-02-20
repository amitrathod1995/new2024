package com.bank.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
//import com.bank.repository.TransactionInterface;
import com.google.gson.JsonObject;

@Service
public class CustomerService /*implements TransactionInterface*/{

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	CustomerRepository customerRepository;
	//@Scheduled(cron="0 9 18 * * ?",zone="IST")
	public Object getCustomers() {
		
		List<Customer> customer = (List<Customer>) customerRepository.findAll();
		logger.info(customer.toString());
		System.out.println("schedules time");
		return customerRepository.findAll();
	}
	
	/*public Object getCustomerCity(String city) {
		List<Customer> customer = (List<Customer>) customerRepository.findByCity(city);
		logger.info(customer.toString());
		return customerRepository.findByCity(city);
	}*/

	public Object getCustomerId(int id) {
		//List<Customer> customer = (List<Customer>) customerRepository.findById(id);
		//logger.info(customer.toString());
		return customerRepository.findById(id);
	}

	public Object getCustomerByName(String name) {
		List<Customer> customer = (List<Customer>) customerRepository.findByName(name);
		logger.info(customer.toString());
		return customerRepository.findByName(name);
	}

	/*@Override
	public String Transaction(double amount,int cid){
		Customer customer=customerRepository.findById(cid);
		if(customer!=null)
		{
		
			if((amount<0))
			{
				
				if(customer.getCustbal()>=(amount*(-1)))
				{
					customer.setCustbal(customer.getCustbal()+amount);
					customerRepository.save(customer);
					System.out.println("Amount Withdraw  Successfully");
					return "Amount Withdraw  Successfully";
				}
				
				else {
					System.out.println("your balence is incuficient");
					return "your balence is incuficient";
				}
			}
			
			else {
				customer.setCustbal(customer.getCustbal()+amount);
				customerRepository.save(customer);
				System.out.println("Amount Deposited Successfully");
				return "Amount Deposited Successfully";
			}
			
		}
		else {
			System.out.println("customer does not exists");
			return "customer does not exists";
		}
		
	}*/
	
	public Object addCustomer(Customer customer) {
		logger.info(customer.toString());
		customerRepository.save(customer);
		logger.info("Customer Added Successfully");
		return new ResponseEntity<>("Customer added Successfully",HttpStatus.CREATED);
		
	}

	@SuppressWarnings("deprecation")
	public Object updateCustomer(Customer customer) {
		JsonObject response = new JsonObject();
		
		System.out.println("Request customer:" + customer);
		int id = customer.getId();
    try {
	
		Customer cust = customerRepository.getOne(id);
		System.out.println("Request customer:" + cust);

		System.out.println("old customer:" + cust);
		cust.setName(customer.getName());
		System.out.println("New customer:" + cust);
		
		System.out.println("old customer:" + cust);
		cust.setCity(customer.getCity());
		System.out.println("New customer:" + cust);
		
		System.out.println("old customer:" + cust);
		cust.setCustbal(customer.getCustbal());
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
	}

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

}

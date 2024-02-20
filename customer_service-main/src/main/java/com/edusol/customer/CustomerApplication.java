 package com.edusol.customer;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import com.edusol.customer.model.Customer;
//import com.edusol.customer.repository.CustomerRepository;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.bind.annotation.CrossOrigin;

//import com.example.delivery.CustomerRepository
@SpringBootApplication
//@CrossOrigin("*")
//@EnableScheduling
@EnableEurekaClient
//@EnableDiscoveryClient
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	/*@Autowired
	private CustomerRepository customerRepository;
	
	public void run(String...args) throws Exception  {
		Customer customer = new Customer();
		this.customerRepository.save(customer);
	}*/
}
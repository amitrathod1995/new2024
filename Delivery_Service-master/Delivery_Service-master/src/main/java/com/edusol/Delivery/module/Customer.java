package com.edusol.Delivery.module;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "CUSTOMER_ID")
	private int id;
	
	@Column(name = "CUSTOMER_NAME")
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "CUSTOMER_PHONENO")
	private Long Phoneno;
	
	@Column(name = "CUSTOMER_EMAil")
	private String email;
	
	@Column(name = "CUSTOMER_CITY")
	private String city;
	
	@Column(name = "CUSTOMER_ADDRESS")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch = FetchType.LAZY)
	public List<Product> products;
	
	@JsonManagedReference
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	
	public void setIds(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(Long phoneno) {
		Phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Customer() {
	}
	public Customer(int id, String name, Long phoneno, String email, String city, String address) {
		super();
		this.id = id;
		this.name = name;
		Phoneno = phoneno;
		this.email = email;
		this.city = city;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Phoneno=" + Phoneno + ", email=" + email + ", city=" + city
				+ ", address=" + address + "]";
	}

}

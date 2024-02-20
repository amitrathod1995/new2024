package com.edusol.customer.model;


//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private int id;

	@Column(name = "CUSTOMER_NAME")
	private String name;

	@Column(name = "CUSTOMER_PHONENO")
	private Long Phoneno;

	@Column(name = "CUSTOMER_EMAil")
	private String email;

	@Column(name = "CUSTOMER_CITY")
	private String city;

	@Column(name = "CUSTOMER_ADDRESS")
	private String address;


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Phoneno=" + Phoneno + ", email=" + email + ", city=" + city
				+ ", address=" + address + "]";
	}





}
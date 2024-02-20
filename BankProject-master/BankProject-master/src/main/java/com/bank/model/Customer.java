package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "CUSTID")
	int id;
	
	@Column(name = "CUSTNAME")
	String name;
	
	@Column(name = "CITY")
	String city;
	
	@Column(name = "CUSTBAL")
	double custbal;
	public Customer() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getCustbal() {
		return custbal;
	}
	public void setCustbal(double custbal) {
		this.custbal = custbal;
	}
	
	/*@Autowired
	public double getAccbal() {
		return getAccbal();
	}
	@Autowired
	public void setAccbal(double accbal) {
		this.custbal = accbal;
	}*/
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", custbal=" + custbal + "]";
	}
	
}

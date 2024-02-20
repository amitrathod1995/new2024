package com.edusol.Productss.model;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTSS")
public class Productss {
	@Id
	//@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private int id;

	@Column(name = "PRODUCT_NAME")
	private String name;
	
	@Column(name = "PRODUCT_PRICE")
	private float price;
	
	@Column(name = "PRODUCT_CATOGERY")
	private String category;
	

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


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category +  "]";
	
	}
	
}


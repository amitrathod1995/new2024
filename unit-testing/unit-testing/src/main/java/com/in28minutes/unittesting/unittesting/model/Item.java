package com.in28minutes.unittesting.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
	private int id;
	private String name;
	private int price;
	private int quantity;

	@Transient
	private int value;
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Item(int id, String name, int price, int quantity) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString()
	{
		return String.format("Item[%d,%5, %d, %d]", id, name, price, quantity);
	}
}

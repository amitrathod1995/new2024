package com.bank.repository;

@FunctionalInterface
public interface TransactionInterface {
	
	public String Transaction(double amount,long accnumber);

	
}

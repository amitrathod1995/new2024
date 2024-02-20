package com.bank.model;

public class Transaction {

	int trnid;
	String trntype;
	long accnum;
	double amount;
	double accbal;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTrnid() {
		return trnid;
	}
	public void setTrnid(int trnid) {
		this.trnid = trnid;
	}
	public String getTrntype() {
		return trntype;
	}
	public void setTrntype(String trntype) {
		this.trntype = trntype;
	}
	public long getAccnum() {
		return accnum;
	}
	public void setAccnum(long accnum) {
		this.accnum = accnum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}
	@Override
	public String toString() {
		return "Transaction [trnid=" + trnid + ", trntype=" + trntype + ", accnum=" + accnum + ", amount=" + amount
				+ ", accbal=" + accbal + "]";
	}
	
}

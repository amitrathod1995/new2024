package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	 @Id
	  @Column(name = "AID")
	  int id;
	 
	  @Column(name = "AccNum") 
  long accnum;
	  
	  @Column(name = "AccType")   
  String acctype;
	  
	  @Column(name = "AccBal") 
  double accbal;

	public Account() {
	//	super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAccnum() {
		return accnum;
	}

	public void setAccnum(long accnum) {
		this.accnum = accnum;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getAccbal() {
		return accbal;
	}

	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accnum=" + accnum + ", acctype=" + acctype + ", accbal=" + accbal + "]";
	}
}
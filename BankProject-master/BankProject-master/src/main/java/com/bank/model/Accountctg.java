package com.bank.model;

public class Accountctg {

	int trnid;
	String acctype;
	long accnum;
	public Accountctg() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public int getTrnid() {
		return trnid;
	}
	public void setTrnid(int trnid) {
		this.trnid = trnid;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public long getAccnum() {
		return accnum;
	}
	public void setAccnum(long accnum) {
		this.accnum = accnum;
	}
	@Override
	public String toString() {
		return "Accountctg [trnid=" + trnid + ", acctype=" + acctype + ", accnum=" + accnum + "]";
	}
}

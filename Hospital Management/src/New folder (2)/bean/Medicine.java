package com.Bean;

public class Medicine {
	
	private String mName;
	private int quantity;
	private double rate;
	private double amount;
	
	
	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Medicine(String mName, int quantity, double rate, double amount) {
		super();
		this.mName = mName;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
	}
	
	

}

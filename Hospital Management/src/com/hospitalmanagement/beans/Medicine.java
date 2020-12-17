package com.hospitalmanagement.beans;

public class Medicine {
  private String medicine_name;
  private int quantity;
  private double rate;
  private double amount;
public Medicine(String medicine_name, int quantity, double rate, double amount) {
	super();
	this.medicine_name = medicine_name;
	this.quantity = quantity;
	this.rate = rate;
	this.amount = amount;
}
public String getMedicine_name() {
	return medicine_name;
}
public void setMedicine_name(String medicine_name) {
	this.medicine_name = medicine_name;
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
  
}

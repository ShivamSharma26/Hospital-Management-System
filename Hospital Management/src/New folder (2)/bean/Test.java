package com.Bean;

public class Test {

	private String testName;
	private double amount;
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Test(String testName, double amount) {
		super();
		this.testName = testName;
		this.amount = amount;
	}
	
	
}

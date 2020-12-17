package com.hospitalmanagement.beans;

import java.sql.Date;

public class Patient {
	
	private int ssnid;
	private String name;
	private int age;
	private String date;
	private String address;
	private String bedtype;
	private String city;
	private String state;
	private String id; 
	
	
	
	
	public Patient(int ssnid, String name, int age, String date, String address, String bedtype, String city,
			String state) {
		super();
		this.ssnid = ssnid;
		this.name = name;
		this.age = age;
		this.date = date;
		this.address = address;
		this.bedtype = bedtype;
		this.city = city;
		this.state = state;
	}
	
	public Patient(String name, int age, String date, String address, String bedtype) {
		super();
		this.name = name;
		this.age = age;
		this.date = date;
		this.address = address;
		this.bedtype = bedtype;
	}
	

	public Patient(String name, int age, String date, String address, String bedtype, String id) {
		super();
		this.name = name;
		this.age = age;
		this.date = date;
		this.address = address;
		this.bedtype = bedtype;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSsnid() {
		return ssnid;
	}
	public void setSsnid(int ssnid) {
		this.ssnid = ssnid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBedtype() {
		return bedtype;
	}
	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	

}

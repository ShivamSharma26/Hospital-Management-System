package com.service;

import java.sql.SQLException;

import com.dao.CustomerDao;
import com.bean.*;

public class CustomerService {
	
	CustomerDao cDao = new CustomerDao();
	
	public boolean addCustomer(Customer customer) throws SQLException , ClassNotFoundException {
		return cDao.addCustomer(customer);
	}

}

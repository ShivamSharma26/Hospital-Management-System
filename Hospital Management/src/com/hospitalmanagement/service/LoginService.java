package com.hospitalmanagement.service;

import java.sql.SQLException;

import com.hospitalmanagement.dao.LoginDao;

public class LoginService {

	public String validateLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		LoginDao logdao=new LoginDao();
		String isValid=logdao.validateLogin(username,password);
		System.out.println("service"+isValid);
		return isValid;
	}

}

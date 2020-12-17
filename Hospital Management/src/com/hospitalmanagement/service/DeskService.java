package com.hospitalmanagement.service;

import java.sql.SQLException;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.dao.DeskDAO;

public class DeskService {
	public boolean addPatient(Patient patient) throws SQLException , ClassNotFoundException
	{
		 DeskDAO dao = new DeskDAO();
		
		boolean success = dao.addPatient(patient);
		
		return success;
	}

	

}

package com.hospitalmanagement.service;

import java.sql.SQLException;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.dao.DeskDAO;
import com.hospitalmanagement.dao.PharmacyDAO;

public class PharmacyService {
	

	public Patient searchPatient(String patient_id) throws SQLException {
		// TODO Auto-generated method stub
		PharmacyDAO dao = new PharmacyDAO();
		
		Patient p = dao.searchPatient(patient_id);
		System.out.println(p.getAddress());
		return p;
	}

	public double addMedicine(String medicine_name,int quantity,int id1) throws SQLException {
		// TODO Auto-generated method stub
		PharmacyDAO dao = new PharmacyDAO();
		double flag=0;
		flag=dao.addMedicine(medicine_name,quantity,id1);
		System.out.println("rate in service"+flag);
		return flag;
	}

}

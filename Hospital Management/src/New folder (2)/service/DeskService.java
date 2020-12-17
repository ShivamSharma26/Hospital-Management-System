package com.service;

import java.sql.SQLException;
import java.util.List;
import com.Bean.Medicine;
import com.Bean.Patient;
import com.Bean.Test;
import com.dao.DeskDao;


public class DeskService {

	public boolean addPatient(Patient patient) throws SQLException , ClassNotFoundException
	{
		 DeskDao dao = new DeskDao();
		
		boolean success = dao.addPatient(patient);
		
		return success;
	}
	
	public Patient getPatientDetails(int id) throws SQLException , ClassNotFoundException
	{
		 DeskDao dao = new DeskDao();
		
		Patient patient= dao.getPatientDetails(id);
		
		return patient;
	}
	
	public List<Medicine> getMedicines(int id) throws SQLException , ClassNotFoundException
	{
		 DeskDao dao = new DeskDao();
		
		List<Medicine> med= dao.getMedicines(id);
		
		return med;
	}
	
	public List<Test> getTest(int id) throws SQLException , ClassNotFoundException
	{
		 DeskDao dao = new DeskDao();
		
		List<Test> test= dao.getTest(id);
		
		return test;
	}
	
	public boolean disPatient(int id) throws SQLException , ClassNotFoundException
	{
		 DeskDao dao = new DeskDao();
		
		boolean success = dao.disPatient(id);
		
		return success;
	}
}

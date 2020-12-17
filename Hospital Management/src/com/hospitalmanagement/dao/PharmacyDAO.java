package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.util.DatabaseUtil;

public class PharmacyDAO {	

public Patient searchPatient(String patient_id) throws SQLException {
	// TODO Auto-generated method stub
	String name = null,date = null,address = null,bedtype=null,id=null;
	int age=0;
	Patient p=new Patient(name, age,  date,address, bedtype,id);
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	//boolean success = false;
		
	con = DatabaseUtil.getConnection();
	String query = "select * from PatientInfo where id=?";
	ps=con.prepareStatement(query);
	ps.setString(1,patient_id);
	rs = ps.executeQuery();
	while(rs.next()) {
		name=rs.getString("name");
		System.out.println("name"+name);
		p.setName(name);
		System.out.println(p.getName());
		p.setAge(rs.getInt("age"));
		p.setAddress(rs.getString("address"));
		p.setDate(rs.getString("admissiondate"));
		p.setBedtype(rs.getString("bedtype"));
		p.setId(rs.getString("id"));
	}
	System.out.println("DAO"+p.getId());
	return p;
}

public double addMedicine(String medicine_name,int quantity,int id1) throws SQLException {
	// TODO Auto-generated method stub

	Connection con=null;
	ResultSet rs,rs2,rs3=null;
	PreparedStatement ps,ps1,ps2,ps3=null;
	//boolean success = false;
	int result,r1=0;
		
	con = DatabaseUtil.getConnection();
	String query = "select * from Medicine where medicine_name=?";
	ps=con.prepareStatement(query);
	ps.setString(1,medicine_name);
	rs = ps.executeQuery();
	while(rs.next()) {
		int a=rs.getInt("quantity");
		System.out.println(medicine_name+a);
		result=a-quantity;
		if(result>=0) {
			double rate=rs.getDouble("rate");
			//double amount=rate*a;//calculate amount
			String sql = "select * from Medicine where medicine_name=?";
			ps1=con.prepareStatement(sql);
			ps1.setString(1,medicine_name);
			rs2 = ps1.executeQuery();
			while(rs2.next()) {
				int med_id=rs2.getInt("medicine_id");
				String sql1 = "insert into Issued_Medicine values(?,?,?)";
				ps2=con.prepareStatement(sql1);
				ps2.setInt(1,id1);
				ps2.setInt(2,med_id);
				ps2.setInt(3,quantity);
				int r3= ps2.executeUpdate();
				 if(r3>0) {
					 System.out.println("Data inserted");
					 int med_quant=rs2.getInt("quantity");
						int result2=med_quant-quantity;
						String sql3 = "update Medicine set quantity=? where medicine_id=?";
						ps1=con.prepareStatement(sql3);
						ps1.setInt(1,result2);
						ps1.setInt(2,med_id);
						int r4= ps1.executeUpdate();
						if(r4>0) {
							System.out.println("Data updated");
						}
					 
				 }
			}
			return rs.getDouble("rate"); 
			
		}
		
	}
	return 0;
}
}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Medicine;
import com.Bean.Patient;
import com.Bean.Test;
import com.util.DatabaseUtil;



public class DeskDao {

public boolean addPatient(Patient patient) throws SQLException, ClassNotFoundException{
		
		
		Connection con=null;
		
		boolean success = false;
			
		con = DatabaseUtil.getConnection();
		
		String query = "insert into PatientInfo values(id.nextval,?,?,?,?,?,?,?,?,?)";
				
				
		PreparedStatement pstm=null;
		pstm = con.prepareStatement(query);
		
		pstm.setInt(1, patient.getSsnid());
		pstm.setString(2,patient.getName());
		pstm.setInt(3, patient.getAge());
		pstm.setString(4, patient.getDate());
		pstm.setString(5,patient.getBedtype());
		pstm.setString(6, patient.getAddress());
		pstm.setString(7, patient.getCity());
		pstm.setString(8, patient.getState());
		pstm.setString(9,"Active");
		
		
		int retVal = pstm.executeUpdate();
		 
		if(retVal!=0) {
			success = true;
		}
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(pstm);

	return success;

}

	
	public Patient getPatientDetails(int id) throws SQLException, ClassNotFoundException{
	
	
		Connection con=null;
	
	
		
		con = DatabaseUtil.getConnection();
	
		String query = "select id,name,age,address,adate,bedtype from PatientInfo where id=?";
			
			
		PreparedStatement pstm=null;
		pstm = con.prepareStatement(query);
	
		pstm.setInt(1, id);
	
	
	
		ResultSet rs = pstm.executeQuery();
		rs.next();
		Patient patient = new Patient(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("address"),rs.getString("adate"),rs.getString("bedtype"));
	
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(pstm);

		return patient;

	}
	
	public List<Medicine> getMedicines(int id) throws SQLException, ClassNotFoundException{
		
		ResultSet rs,rs1;
		Connection con=null;
		con = DatabaseUtil.getConnection();
		int count=0;
		int rows=0;
		List<Medicine> med = new ArrayList<>();
		
		String query = "select medicine_id,quantity from Issued_Medicine where id=?";
		
		PreparedStatement pstm = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstm.setInt(1, id);
		//Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 rs = pstm.executeQuery();
		 
		
		 while(rs.next()) {
			 System.out.println(rs.getInt("medicine_id"));
			 System.out.println(rs.getInt("quantity"));
			 count=count+1;
		 }
		 System.out.println(count);
		 if(rs.last()) {
			  rows = rs.getRow();
			 rs.beforeFirst();
		 }
		 System.out.println(rows);
		 
		 String[] mname = new String[rows];
		 Double[] rate = new Double[rows];
		 int[] mid = new int[rows];
		 int[] quantity = new int[rows];
		 int i=0;
		 while(rs.next()) {
			  mid[i] = rs.getInt("medicine_id"); 
			  quantity[i] = rs.getInt("quantity");
			  query = "select medicine_name,rate from Medicine where medicine_id=?";
			 
			 PreparedStatement pst=null;
			 pst = con.prepareStatement(query);
			 pst.setInt(1, rs.getInt("medicine_id"));
			 rs1 = pst.executeQuery();
			 
			 rs1.next();
			 mname[i]= rs1.getString("medicine_name");
			 rate[i] = rs1.getDouble("rate");
			 i++;
			// System.out.println(rs1.getString("medicine_name"));
			// System.out.println(rs1.getDouble("rate"));
			 
		 }
		 
		 for(int j=0;j<i;j++) {
			 System.out.println(mid[j]+"  "+mname[j]+"  "+quantity[j]+"  "+rate[j]);
			 med.add(new Medicine(mname[j],quantity[j],rate[j],(quantity[j]*rate[j])));
		 }
	
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(pstm);

		return med;

	}

	
	public List<Test> getTest(int id) throws SQLException, ClassNotFoundException{
		
		ResultSet rs,rs1;
		Connection con=null;
		con = DatabaseUtil.getConnection();
		int count=0;
		int rows=0;
		List<Test> test = new ArrayList<>();
		
		String query = "select test_id from Issued_Test where id=?";
		
		PreparedStatement pstm = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstm.setInt(1, id);
		//Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 rs = pstm.executeQuery();
		 
		
		 while(rs.next()) {
			 System.out.println(rs.getInt("test_id"));
			 
			 count=count+1;
		 }
		 System.out.println(count);
		 if(rs.last()) {
			  rows = rs.getRow();
			 rs.beforeFirst();
		 }
		 System.out.println(rows);
		 
		 String[] tname = new String[rows];
		 Double[] amount = new Double[rows];
		 
		 int i=0;
		 while(rs.next()) {
			  
			  query = "select test_name,test_charge from Test where test_id=?";
			 
			 PreparedStatement pst=null;
			 pst = con.prepareStatement(query);
			 pst.setInt(1, rs.getInt("test_id"));
			 rs1 = pst.executeQuery();
			 
			 rs1.next();
			 tname[i]= rs1.getString("test_name");
			 amount[i] = rs1.getDouble("test_charge");
			 i++;
			// System.out.println(rs1.getString("test_name"));
			// System.out.println(rs1.getDouble("amount"));
			 
		 }
		 
		 for(int j=0;j<i;j++) {
			 System.out.println(tname[j]+"  "+amount[j]);
			 test.add(new Test(tname[j],amount[j]));
		 }
		 
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(pstm);

		return test;
	}
	
		
	public boolean disPatient(int id) throws SQLException, ClassNotFoundException{
		
		
		Connection con=null;
		
		boolean success = false;
			
		con = DatabaseUtil.getConnection();
		
		String query = "update PatientInfo set status=? where id=?";
		
		PreparedStatement pstm=null;
		pstm = con.prepareStatement(query);
		
		pstm.setString(1, "discharged");
		pstm.setInt(2,id);
		
		int ret = pstm.executeUpdate();
		if(ret>0) {
			success = true;
		}
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(pstm);

		return success;
	}
}

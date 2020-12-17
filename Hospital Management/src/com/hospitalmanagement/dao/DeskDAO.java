package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.util.DatabaseUtil;

public class DeskDAO {
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


}

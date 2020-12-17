package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospitalmanagement.util.DatabaseUtil;

public class LoginDao {

	public String validateLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		

		Connection con=null;
		boolean isValid=false;
		
		
			con=DatabaseUtil.getConnection();
			System.out.println(con);
			String query="select * from User_store where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			String position1=null;
			
			
			//if username and password match
			if(rs.next()) {
				isValid=true;
				position1=rs.getString("position");
				System.out.println("Stakeholder is "+position1);
				
			}
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(ps);
			System.out.println(isValid);
		return position1;
		
	
	}
		

}

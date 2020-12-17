package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Medicine;
import com.Bean.Test;

public class DbTry {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
		
		ResultSet rs,rs1;
		Connection con=null;
		con = DatabaseUtil.getConnection();
		int count=0;
		int rows=0;
		List<Test> test = new ArrayList<>();
		
		String query = "select test_id from Issued_Test where id=?";
		
		PreparedStatement pstm = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstm.setInt(1, 1234);
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
		 
		 
	}

}

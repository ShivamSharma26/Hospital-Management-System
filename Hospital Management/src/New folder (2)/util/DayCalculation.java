package com.util;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class DayCalculation {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
		//LocalDate localdate = LocalDate.now();
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	  //  String date = formatter.format(formatter);
		//System.out.println(date);
		
		//java.util.Date utildate = formatter.parse(date);
		//java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
		
		
		
		//Date sqldate = Date.valueOf(localdate);
		//System.out.println(sqldate);
		
		//database fetching of date start
		ResultSet rs;
		Connection con=null;
		con = DatabaseUtil.getConnection();
		
		String query = "select adate from PatientInfo where id=1234";
		
		PreparedStatement pstm = con.prepareStatement(query);
		
		 rs = pstm.executeQuery();
		 rs.next();
		 //System.out.println(rs.getString("adate"));
		 String doj = rs.getString("adate");
		//database fetching of date ended
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		 Date doj1 = df1.parse(doj);
		// System.out.println("date in date format: "+ doj1);  
		 
	     
		 //current date fetched
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date dod = new Date();
		 System.out.println(df.format(dod));
		 String aa = df.format(dod);
		 System.out.println(aa);
		 
		 long diff =  dod.getTime() - doj1.getTime();
		 long diffdays = diff/(24*60*60*1000);
		 
		 System.out.println(diffdays);
	}

}

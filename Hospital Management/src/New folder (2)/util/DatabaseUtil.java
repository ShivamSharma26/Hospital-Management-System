package com.util;
import java.sql.*;

public class DatabaseUtil {

		
		private static final String DRIVER_NAME= "oracle.jdbc.driver.OracleDriver";
		private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USERNAME="system";
		private static final String PASSWORD="rashmi";	
		
		
		public static Connection getConnection() {
			
			Connection con=null;
			
			try {
				Class.forName(DRIVER_NAME);
				con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return con;
			
		}
		
		public static void closeConnection(Connection con) {
			
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		public static void closeStatement(PreparedStatement ps) {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
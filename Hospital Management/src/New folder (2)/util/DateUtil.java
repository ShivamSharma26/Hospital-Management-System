package com.util;


import java.sql.Date;

public class DateUtil {
	public static Date convertStringToDate(String dateInString) {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//Date date = null;
		System.out.println("Date String:"+dateInString);
		//date = formatter.parse(dateInString);
		 Date date = Date.valueOf(dateInString);
		
		return date;
	}

}

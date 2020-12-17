package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class calculateDayAmount {

	public static long calculateDay(String doa) {
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		 Date doa1 = null;
		try {
			doa1 = df1.parse(doa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
	     
		 //current date fetched
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date dod = new Date();
		 System.out.println(df.format(dod));
		 
		 long diff =  dod.getTime() - doa1.getTime();
		 long diffdays = diff/(24*60*60*1000);
		 
		 System.out.println(diffdays);
		 return diffdays;
	}
	
	public static double calculateBedAmount(long days,String bedtype) {
		
		double charge=0;
		
		if(bedtype.equalsIgnoreCase("generalward")) {
			charge = days*2000;
		}
		
		if(bedtype.equalsIgnoreCase("semisharing")) {
			charge = days*4000;
		}
		
		if(bedtype.equalsIgnoreCase("singleroom")) {
			charge = days*8000;
		}
		
		
		return charge;
	}
	
}








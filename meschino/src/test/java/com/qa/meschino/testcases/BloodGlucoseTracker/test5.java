package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;



public class test5 {

	
	@Test
	public void te5() throws ParseException{
		
		String s = "1/9/2019 12:00:00 AM";
		
		//Date d = new Date();
		 SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		Date ss =  sf.parse(s);
		String time = new SimpleDateFormat("HH:mm a").format(ss);
		   System.out.println(time);
	}
}

package com.qa.meschino.testcases.AsthmaTracker;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;
//import com.relevantcodes.extentreports.LogStatus;

public class test1 extends BaseTest{
 

@Test
public void cal() throws ParseException{
	
	String dateToSelect= "12/10/2010";
	
	Date d= new Date();
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	   Date d1 = sdf.parse(dateToSelect);
	
	
	String month = new SimpleDateFormat("MMMM").format(d1);
	String year = new SimpleDateFormat("yyyy").format(d1);
	
	
	String day = new SimpleDateFormat("dd").format(d);
	
	System.out.println(month+"  "+year+ " "+day);
	
	
}

	
}

package com.qa.meschino.testcases.AsthmaTracker;



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
 
	

@BeforeMethod
public void startup(){
	logger = extent.createTest("Starting test case t1");
	
	
	
}
	@Test
	public void t1(){
		
		init("Chrome");
		
		
		LoginPage lp = new LoginPage(driver, logger);
PageFactory.initElements(driver, lp);

lp.lo("aneel");
			
		
		
		
	}
	
	
	@AfterMethod
	public void quit(){
		
		
		if(extent!=null){
	//	extent.endTest(logger);
	    extent.flush();	
		}
	}
}

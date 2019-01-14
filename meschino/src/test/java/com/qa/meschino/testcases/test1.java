package com.qa.meschino.testcases;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class test1 extends BaseTest{
 
	

@BeforeMethod
public void startup(){
	logger = extent.startTest("Starting test case t1");
	
	
	init("Chrome");
}
	@Test
	public void t1(){
		
		
		
		LoginPage lpage = new LoginPage(driver, logger);
		
		PageFactory.initElements(driver, lpage);
		
	
		
	//LoginPage lpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.log(LogStatus.INFO, "Enter Login Details");
		Object page = lpage.doLogin("Neil@peter.com", "Test@123");
		
		String actualResult ="";
		
		if(page instanceof LandingPage){
			
			actualResult="Success";
			LandingPage landingpage = (LandingPage) page;
		    	
			landingpage.profile.chageProfilePic();
		}
		
		actualResult= "Unsuccessfull";
	//	if(actualResult.equalsIgnoreCase(arg0))
		
		
		
		//landingpage.getProfile().chageProfilePic();
	}
	
	
	@AfterMethod
	public void quit(){
		
		logger.log(LogStatus.INFO, "Closing Browser");
		driver.quit();
		if(extent!=null){
		extent.endTest(logger);
	    extent.flush();	
		}
	}
}

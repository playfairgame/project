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
	test = extent.startTest("Starting test case t1");
	init("Chrome");
}
	@Test
	public void t1(){
		
		
		
		LoginPage lpage = new LoginPage(driver, test);
		
		PageFactory.initElements(driver, lpage);
		
	
		
	//LoginPage lpage = PageFactory.initElements(driver, LoginPage.class);
		
		test.log(LogStatus.INFO, "Enter Login Details");
		LandingPage landingpage = lpage.doLogin("Neil@peter.com", "Test@123");
		
		landingpage.profile.chageProfilePic();
		//landingpage.getProfile().chageProfilePic();
	}
	
	
	@AfterMethod
	public void quit(){
		
		test.log(LogStatus.INFO, "Closing Browser");
		driver.quit();
		if(extent!=null){
		extent.endTest(test);
	    extent.flush();	
		}
	}
}

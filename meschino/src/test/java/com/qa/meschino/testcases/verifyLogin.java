package com.qa.meschino.testcases;

import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class verifyLogin extends BaseTest{
	
	/*
	@BeforeMethod
	public void startup(){
		
		init("Firefox");
	}
	*/
	@Test
	public void loginTest() throws InterruptedException{
		
		logger = extent.startTest("login");
		
		logger.log(LogStatus.INFO, "Opeining test");
		
		init("Chrome");
		
		//logger.log(LogStatus.PASS,"Test Passed");
		
		LoginPage lp = new LoginPage(driver, logger);
		PageFactory.initElements(driver, lp);
		
		LandingPage landing = lp.doLogin("Neil@peter.com", "Test@123");
		Thread.sleep(5000);
		
		landing.takeScreenshot();
		
		
	}
	
	@AfterMethod
	public void endTest(){
		if(extent!=null){
			extent.endTest(logger);
			extent.flush();
		}
	}

}

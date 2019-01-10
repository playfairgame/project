package com.qa.meschino.testcases;

import java.util.Date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	public void loginTest(){
		
		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest log = extent.startTest("login");
		
		log.log(LogStatus.INFO, "Opeining test");
		
		log.log(LogStatus.PASS,"Test Passed");
		
		extent.endTest(log);
		extent.flush();
		
		
		
	}

}

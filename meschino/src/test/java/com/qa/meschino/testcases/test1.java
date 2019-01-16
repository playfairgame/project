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
	
	
	
}
	@Test
	public void t1(){
		String testCaseName= "LoginTest";
		String sheetName = MWConstants.DATASHEET_NAME;
		int row=1;
		while(!xls.getCellData(sheetName, 0, row).equals(testCaseName)){
			
			
		}
		
		
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

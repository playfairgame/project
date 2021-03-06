package com.qa.meschino.testcases.Login;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
import com.qa.meschino.utils.ExtentManager;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class verifyLogin extends BaseTest{
	
	
	


	@Test(dataProviderClass=DataProviderFile.class ,dataProvider="LoginTest")
	public void LoginTest(Hashtable<String, String> data) throws InterruptedException{
		logger.log(Status.INFO, data.get("Description"));
		
		
		if(data.get("Runmode").equals("N")){
			
			//logger.log(LogStatus.SKIP, "Test Case Skipped");
			throw new SkipException("Skipping Test case  as runmode is No");
			
		}
		
		init("Chrome");
		//logger.log(LogStatus.PASS,"Test Passed");
		
		LoginPage lp = new LoginPage(driver, logger);
		PageFactory.initElements(driver, lp);
		
		Object page = lp.doLogin(data.get("UserName"), data.get("Password"));
		Thread.sleep(2000);
		String actualResult ="";
		
		if(page instanceof LandingPage){
		
			actualResult ="Success";
		 //   logger.log(LogStatus.PASS, data.get("Description"));
		//	LandingPage landingpage = (LandingPage) page;
			
		
		}else
		{
					actualResult="Unsuccessfull";
		
		}
		
		if(!actualResult.equals(data.get("Expected"))){
			
			
			//logger.log(LogStatus.FAIL, "Test case failed");
			try {
				reportFailure(data.get("Description"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	


}

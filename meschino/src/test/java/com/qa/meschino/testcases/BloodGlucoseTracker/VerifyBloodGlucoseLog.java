package com.qa.meschino.testcases.BloodGlucoseTracker;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.TrackersAndResourcesPage;
import com.qa.meschino.testcases.basetest.BaseTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.qa.meschino.utils.DataUtils;

public class VerifyBloodGlucoseLog extends BaseTest{
 
	String testCaseName ="BloodGlucoseTest" ;

	//  @Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	
		@Test(dataProviderClass=DataProviderFile.class,  dataProvider="BloodGlucoseTest")
		public void BloodGlucoseTest(Hashtable<String, String> data) throws ParseException, InterruptedException{
	
			logger.log(Status.INFO, data.get("Description"));
	
	
				if(data.get("Runmode").equals("N")){
		
					//logger.log(LogStatus.SKIP, "Test Case Skipped");
					throw new SkipException("Skipping Test case  as runmode is No");
		
				}
	
	
	init("Chrome");
	
//	lp.doLogin(data.get("UserName"), data.get("Password"));
	
	LoginPage l = new LoginPage(driver, logger);
	
	PageFactory.initElements(driver, l);
	
	Object page  =  l.doLogin(data.get("UserName"), data.get("Password"));
	
	String actualMessage="";
	String result="";
        LandingPage lp = (LandingPage) page;
        //Thread.sleep(9000);
        TrackersAndResourcesPage t = lp.goToToolsTrackers();
	    t.openBGTracker();
	    
	    
	    logger.log(Status.INFO, "Entering Blood Glucose Level");
	    
	    t.logBGLevel(data.get("BGLevel"));
	    
	  
	    
	    if(!data.get("Date").equals("0"))
	    {
	    	logger.log(Status.INFO,"Selecting Date from Calendar");
	    	t.clickOnCalendar();
	    	
	    	if(data.get("Date").equalsIgnoreCase("Current")){
	    		
	    		t.pickDate(t.getCurrentDate());
	    		
	    	}
	    	else{
	    	
	    	
	    	t.pickDate(data.get("Date"));
	    	}
	    	
	    }
	    
	    if(data.get("Time").equalsIgnoreCase("Current")){
	    	 t.pickTime(t.getCurrentTime());
	    	
	    }else 
	    {
	    t.pickTime(data.get("Time"));
	    }
	    
	    t.clickOnSave();
	    
	    actualMessage = t.getConfirmationMessage();
	
	     if(actualMessage.equalsIgnoreCase(data.get("Expected"))){
	    	 
	    	 result ="Success";
	    	 //logger.log(Status.PASS, "Test case Passed");
	     }
	     else{
	    	 
	    	 result= "Unsuccessfull";
	    try {
			reportFailure("Actual Result is : "+actualMessage+" NOT as per extected Result "+data.get("Expected"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     }
	    //System.out.println(msg);
	
	
	
	    t.clickOK();
	    
	  //  t.closeBGTracker();
	    
	
}
		
	/*
@DataProvider
public Object[][] getData(){
	return DataUtils.getData(xls, testCaseName);
}


*/
	
}

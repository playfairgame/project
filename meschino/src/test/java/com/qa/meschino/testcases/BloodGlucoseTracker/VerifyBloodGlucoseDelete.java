package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.io.IOException;
import java.text.ParseException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.TrackersAndResourcesPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class VerifyBloodGlucoseDelete extends BaseTest{
	
	
	
	
	@Test(dataProviderClass=DataProviderFile.class, dataProvider="BloodGlucoseDeleteLogs")
	public void BloodGlucoseDeleteLogs(Hashtable<String, String> data) throws InterruptedException, IOException, ParseException{
		String actualMessage="";
		
		if(data.get("Runmode").equalsIgnoreCase("N")){
			
						
			throw new SkipException("Skipping the Test case are runmode is NO");
		}
		
		logger.log(Status.INFO, data.get("Description"));
		
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		
		Object p = l.doLogin(data.get("UserName"),data.get("Password"));
		LandingPage lp = (LandingPage) p;
		
		TrackersAndResourcesPage t = lp.goToToolsTrackers();
		t.openBGTracker();
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
	    
		    t.clickOK();
		    Thread.sleep(3000);
		t.clickOnReset();
		
		t.clickOK();
		Thread.sleep(3000);
		actualMessage= t.getlog();
		System.out.println(actualMessage);
		if(!actualMessage.equalsIgnoreCase(data.get("Expected"))){
			
			reportFailure(actualMessage+ " is not equal to "+data.get("Expected"));
		}
		
		
	}

}

package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.text.ParseException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.ProfilePage;
import com.qa.meschino.pages.TrackersAndResourcesPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class VerifyBloodGlucoseOnProfile extends BaseTest{

	
	@Test(dataProviderClass= DataProviderFile.class, dataProvider="getDataBGProfile")
	public void BloodGlucoseOnProfile(Hashtable<String, String> data) throws InterruptedException, ParseException{
		
		String cctime="";
		String ccdate="";
		logger.log(Status.INFO, data.get("Description"));
		
		if(data.get("Runmode").equalsIgnoreCase("N")){
			
			throw new SkipException("Skipping Test case  as runmode is No");
		}
		
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		Object page = l.doLogin(data.get("UserName"), data.get("Password"));
		
		LandingPage lp = (LandingPage) page;
		
		TrackersAndResourcesPage t = lp.goToToolsTrackers();
		
		t.openBGTracker();
		
		
		logger.log(Status.INFO, "Entering Blood Glucose Level");
		
		 t.logBGLevel(data.get("BGLevel"));
		 if(!data.get("Date").equals("0"))
		    {
		    	logger.log(Status.INFO,"Selecting Date from Calendar");
		    	t.clickOnCalendar();
		    	
		    	if(data.get("Date").equalsIgnoreCase("Current")){
		    		ccdate = t.getCurrentDate();
		    		t.pickDate(ccdate);
		    		
		    	}
		    	else{
		    	
		    	
		    	t.pickDate(data.get("Date"));
		    	}
		    	
		    }
		    
		    if(data.get("Time").equalsIgnoreCase("Current")){
		    	 
		    	cctime=t.getCurrentTime();
		    	t.pickTime(cctime);
		    	
		    }else 
		    {
		    t.pickTime(data.get("Time"));
		    }
		    
		    t.clickOnSave();
		
		    t.clickOK();
		    Thread.sleep(3000);
		    t.closeBGTracker();
		    
		     t.getProfile().goToProfile();
		     t.getProfile().goToHealthTab();
		     
		   
		    
	}
}

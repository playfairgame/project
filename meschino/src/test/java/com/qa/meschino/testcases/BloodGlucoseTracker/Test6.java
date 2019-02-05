package com.qa.meschino.testcases.BloodGlucoseTracker;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.CreateMyWellnessPlanPage;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class Test6 extends BaseTest{



@Test
public void tq() throws InterruptedException{
	
	init("Chrome");
	
	
	LoginPage l = new LoginPage(driver, logger);
	PageFactory.initElements(driver, l);
	
	Object p =l.doLogin("Neil@peter.com", "Test@123");
	LandingPage lp = (LandingPage)p;
	
	CreateMyWellnessPlanPage wp = lp.goToCreateMyWellnessPlan();
	wp.clickOnAlcoholConsumpton();
	String a =wp.getRiskStatus("Blood Glucose");
    
	System.out.println(a);

}

}

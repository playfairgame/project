package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfilePage {
	
	WebDriver driver;
	ExtentTest test;
	
	
	//******************Profile Page is Common for all Pages and can be accessed from all pages*****************
	
	//***************Constructor*******************************

	public ProfilePage(WebDriver driver, ExtentTest test){
		
		this.driver=driver;
		this.test=test;
		
		
	}
	
	public void chageProfilePic(){
	test.log(LogStatus.INFO, "changinf profile pic on profile page");
		System.out.println("Profile pic changed");
	}
	
}

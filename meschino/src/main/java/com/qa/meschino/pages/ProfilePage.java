package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class ProfilePage {
	
	WebDriver driver;
	ExtentTest logger;
	
	
	//******************Profile Page is Common for all Pages and can be accessed from all pages*****************
	
	//***************Constructor*******************************

	public ProfilePage(WebDriver driver, ExtentTest logger){
		
		this.driver=driver;
		this.logger=logger;
		
		
	}
	
	public void chageProfilePic(){
		logger.log(Status.INFO, "changinf profile pic on profile page");
		System.out.println("Profile pic changed");
	}
	
}

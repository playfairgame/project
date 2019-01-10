package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage {
	
	WebDriver driver;
	
	//******************Profile Page is Common for all Pages and can be accessed from all pages*****************
	
	//***************Constructor*******************************

	public ProfilePage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	public void chageProfilePic(){
		
		System.out.println("Profile pic changed");
	}
	
}

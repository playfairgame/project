package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage {
	
	public WebDriver driver;
	
	//***************Constructor*******************************

	public ProfilePage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	public void chageProfilePic(){
		
		System.out.println("Profile pic changed");
	}
	
}

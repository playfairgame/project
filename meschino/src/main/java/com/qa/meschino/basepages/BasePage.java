package com.qa.meschino.basepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.meschino.pages.ProfilePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	
	public WebDriver driver;
	public ExtentTest test;
	
	public ProfilePage profile;
	
	//***********Default Constructor********************
	
	public BasePage(){
	
	}
	
	//*****************Constructor**********************
	public BasePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		
		profile = new ProfilePage(driver, test);
		PageFactory.initElements(driver, profile);
		
		//profile = PageFactory.initElements(driver, ProfilePage.class);
		
	}
	
	
	//********************Functions**********************
	
	//************Common Page******************
	public ProfilePage getProfile(){
		
		
		return profile;
	}
	
	
	
	public String verifyTitle(String expectedTitle){
		
		return "";
	}
	
	
	public String verifyText(String locator, String expectedText){
		
		return "";
	}
	
	public boolean isElementPresent(String locator){
		
		return false;
	}
	
	

	
	
	
}

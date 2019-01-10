package com.qa.meschino.testcases;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class test1 extends BaseTest{
 
	

@BeforeMethod
public void startup(){
	
	init("Chrome");
}
	@Test
	public void t1(){
		
	
		
	LoginPage lpage = PageFactory.initElements(driver, LoginPage.class);
		
	System.out.println("goin to login");
		LandingPage landingpage = lpage.doLogin("Neil@peter.com", "Test@123");
		
		landingpage.getProfile().chageProfilePic();
	}
	
	
	@AfterMethod
	public void close(){
		driver.quit();
	}
}

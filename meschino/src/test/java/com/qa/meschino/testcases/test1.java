package com.qa.meschino.testcases;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class test1 extends BaseTest{
WebDriver driver;
	
	@Test
	public void t1(){
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	LoginPage lpage = PageFactory.initElements(driver, LoginPage.class);
		lpage.browseUrl();
		LandingPage landingpage = lpage.doLogin("Neil@peter.com", "Test@123");
		
		
	}
}

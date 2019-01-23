package com.qa.meschino.testcases.AsthmaTracker;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.TrackersAndResourcesPage;
import com.qa.meschino.testcases.basetest.BaseTest;
//import com.relevantcodes.extentreports.LogStatus;

public class test1 extends BaseTest{
 


@Test
public void cal() throws ParseException, InterruptedException{
	
	init("Chrome");
	
//	lp.doLogin(data.get("UserName"), data.get("Password"));
	
	LoginPage l = new LoginPage(driver, logger);
	
	PageFactory.initElements(driver, l);
	
	Object page  =  l.doLogin("neil@peter.com", "Test@123");
	
        LandingPage lp = (LandingPage) page;
        //Thread.sleep(9000);
        TrackersAndResourcesPage t = lp.goToToolsTrackers();
	    t.openBGTracker();
	    t.clickOnCalendar();
	    t.pickDate("10/10/2012");
	
	/*
	
	System.setProperty("webdriver.chrome.driver", MWConstants.CHROME_DRIVER_EXE);
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.meschinowellness.com");
	driver.findElement(By.id("UserName")).sendKeys("neil@peter.com");
	driver.findElement(By.id("Password")).sendKeys("Test@123");
	driver.findElement(By.id("btnLogin")).click();
	
	Thread.sleep(10000);
	
	driver.findElement(By.id("toolsAndResources")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Blood Glucose Tracker')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
	

	//pickDate("12/10/2010");
	 * 
	 */
	
}




	
}

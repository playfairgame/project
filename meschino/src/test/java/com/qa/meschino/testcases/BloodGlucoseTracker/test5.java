package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.testcases.basetest.BaseTest;



public class test5 extends BaseTest{

	WebDriver  driver;
	
	@Test
	public void te5() throws ParseException, InterruptedException, IOException{
		
		System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
			driver.get(MWConstants.PROD_URL);
			
			driver.findElement(By.id("UserName")).sendKeys("mwtesting222@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("Admin789@");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(8000);
			WebElement e = driver.findElement(By.xpath("//div[@class='username']/span[1]"));
			
			Actions act = new Actions(driver);
			
			act.moveToElement(e).build().perform();
			
			driver.findElement(By.xpath("//i[@class='icon-user']")).click();
			Thread.sleep(3000);
			
			//Hashtable<String, String> table = getProfileData("Personal", "Heights");
			//
		 		//	System.out.println(table.get("Height value"));
		 			//System.out.println(table.get("Height metric"));
	}
	
	
}

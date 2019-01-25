package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.testcases.basetest.BaseTest;

public class testing extends BaseTest {
	
	WebDriver  driver;
	
    @Test 
	public void t2() throws InterruptedException{
		
		
    	
    	System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
			driver.get(MWConstants.PROD_URL);
			
			driver.findElement(By.id("UserName")).sendKeys("neil@peter.com");
			driver.findElement(By.id("Password")).sendKeys("Test@123");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(8000);
			WebElement e = driver.findElement(By.xpath("//div[@class='username']/span[1]"));
			
			Actions act = new Actions(driver);
			
			act.moveToElement(e).build().perform();
			
			driver.findElement(By.xpath("//i[@class='icon-user']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='tabbable']/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//div[@class='username']/span[1]")).sendKeys(Keys.ENTER);
			
			WebElement t= driver.findElement(By.xpath("//div[@id='divMeasurements_tab_3']/table/tbody"));
			
		 List<WebElement> li = t.findElements(By.tagName("tr"));
					 
		 int rows = li.size();
			
			Hashtable<String, String> table = new Hashtable<String, String>(); 
		
			String xpath1 = "//div[@id='divMeasurements_tab_3']/table/tbody/tr[";
			String xpath2 = "]/td[1]/div[5]";
			for(int i=1;i<=rows;i++){
				
				System.out.println(driver.findElement(By.xpath(xpath1+i+xpath2)).getText());
				
			}
			
			
			
			
			
	}

	
	
}

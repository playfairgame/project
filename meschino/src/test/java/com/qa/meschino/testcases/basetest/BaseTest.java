package com.qa.meschino.testcases.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public WebDriver driver;
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	
	public void init(String browser){
		
		if(browser.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.geckodriver.driver", MWConstants.CHROME_DRIVER_EXE);
			test.log(LogStatus.INFO, "Launching Browser");
			 driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", MWConstants.FIREFOX_DRIVER_EXE);
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Launching Url");
		driver.get(MWConstants.PROD_URL);
		
	}
	
	
	
	
	
	
}

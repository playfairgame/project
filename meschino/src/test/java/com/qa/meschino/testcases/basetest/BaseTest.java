package com.qa.meschino.testcases.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public WebDriver driver;
	
	
	
	public void init(String browser){
		
		if(browser.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("Https://www.meschinowellness.com");
		
	}
	
	
	
	
	
	
}

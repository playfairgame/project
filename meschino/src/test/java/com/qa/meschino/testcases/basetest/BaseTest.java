package com.qa.meschino.testcases.basetest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.utils.ExtentManager;
import com.qa.meschino.utils.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {

	public WebDriver driver;
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest logger;
	public Xls_Reader xls = new Xls_Reader(MWConstants.DATASHEET_PATH);
	
	
	// intialize browsers
	
	public void init(String browser){
		
		if(browser.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.geckodriver.driver", MWConstants.CHROME_DRIVER_EXE);
			logger.log(LogStatus.INFO, "Launching Browser");
			 driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", MWConstants.FIREFOX_DRIVER_EXE);
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		logger.log(LogStatus.INFO, "Launching Url");
		driver.get(MWConstants.PROD_URL);
		
	}
	
	public void reportFailure(String message){
		
		logger.log(LogStatus.FAIL, message);
		takeScreenshot();
		Assert.fail(message);
		
	}
	
	
	// Take Screen shots and log in the extent reports
	public void takeScreenshot(){
		// code
		Date d = new Date();
		String fName = d.toString().replace(" ", "_").replace(":","_")+".png";
		// Create file path with complete file name
		String filePath=MWConstants.SCREENSHOTS_PATH+fName;
		
		// cast driver into TakeScreensshot interface
		
		TakesScreenshot srcShot = (TakesScreenshot) driver;
	
		// call getScreenshotAs function to create image file 
		
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		// Move image file to destination
		
		File destFile = new File(filePath);
		
		// Copy file  to destination
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		logger.log(LogStatus.INFO,logger.addScreenCapture(filePath));
		
	}
	
	// Before suits to check the runmode of suite
	@BeforeSuite
	public void run(ITestContext ctx){
		
		
		String sheetName = MWConstants.SUITE_SHEET_NAME;
		
		String suiteName = ctx.getSuite().getName();
		int rows = xls.getRowCount(sheetName);
		
		for(int r=2; r<=rows;r++){
			
			if(xls.getCellData(sheetName, 0, r).equalsIgnoreCase(suiteName)){
				
				if(xls.getCellData(sheetName, 1, r).equalsIgnoreCase("N")){
					//logger.log(LogStatus.SKIP, "Skipping the Suite as "+suiteName+" has runmode NO");
					throw new SkipException("run mode of the suite is NO");
				}
			}
		}
		
	}

	
	@AfterSuite
	public void closeSuite(){
	
	
	}
	
	
}

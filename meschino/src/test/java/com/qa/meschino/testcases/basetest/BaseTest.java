package com.qa.meschino.testcases.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.extentReportListener.Listeners;
import com.qa.meschino.utils.ExtentManager;
import com.qa.meschino.utils.Xls_Reader;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {

	public WebDriver driver;
	
	 
	public ExtentReports extent = ExtentManager.getInstance();
	
	public ExtentTest logger;
	public static Xls_Reader xls = new Xls_Reader(MWConstants.DATASHEET_PATH);
	//public ExtentHtmlReporter r;
	public String mName;
	// intialize browsers
	
	public void init(String browser){
		
		if(browser.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.geckodriver.driver", MWConstants.FIREFOX_DRIVER_EXE);
			logger.log(Status.INFO, "Launching Browser");
			 driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		logger.log(Status.INFO, "Browsing Url");
		driver.get(MWConstants.PROD_URL);
		//driver.get(MWConstants.STAGE_URL);
		
	}
	
	public void reportFailure(String message) throws IOException{
		
		//logger.log(LogStatus.FAIL, message);
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
				
		//logger.log(LogStatus.INFO,logger.addScreenCapture(filePath));
		
			
			try {
				
				logger.fail("Failed " ).addScreenCaptureFromPath(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		//	logger.fail("details").addScreenCaptureFromPath(filePath);
		
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
					throw new SkipException("Runmode of the suite is NO");
				}
			}
		}
		
	}
	
	@BeforeMethod
	public void startup(Method method){
	
				logger = extent.createTest(method.getName());
	}

	
	@AfterMethod
	public void endTest(ITestResult result ) throws IOException{
		if(extent!=null){
			
			if(result.getStatus()==ITestResult.FAILURE){
				mName = Listeners.getMethodName(result);
		      //  reportFailure(mName + " failed ");
			takeScreenshot();
				logger.log(Status.FAIL, mName+ " Test case failed " +result.getThrowable());
			}else if (result.getStatus()== ITestResult.SKIP){
				mName = Listeners.getMethodName(result);
				logger.log(Status.SKIP, mName+ " Test case Skipped "+ result.getThrowable());
			}else{
				mName = Listeners.getMethodName(result);
			logger.log(Status.PASS, mName+ " Test case Passed ");
			}
			
			//extent.endTest(logger);
			extent.flush();
			if(driver!=null){
		//	driver.quit();
			}
			
		}
		
		
	}
	
}

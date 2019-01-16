package com.qa.meschino.basepages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.pages.ProfilePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	
	public WebDriver driver;
	public ExtentTest logger;
	
	public ProfilePage profile;
	
	//***********Default Constructor********************
	
	public BasePage(){
	
	}
	
	//*****************Constructor**********************
	public BasePage(WebDriver driver,ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		
		profile = new ProfilePage(driver, logger);
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
		
		logger.log(LogStatus.INFO, "Trying to find the element "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s>0)
		{
			logger.log(LogStatus.INFO, "Element found ");
			return true;
		}
		else
		{	logger.log(LogStatus.INFO, "Element not found ");
		return false;
	}
	}
	
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

	public WebElement findAndWait(WebElement e, int sec){
		
		try{
		WebDriverWait wdw = new WebDriverWait(driver, sec);
		wdw.until(ExpectedConditions.visibilityOf(e));
		if(e.isDisplayed())
			return e;
				}
		catch(Throwable t){
			logger.log(LogStatus.ERROR, t);
		}
		return e;
	}
	
	
	
}

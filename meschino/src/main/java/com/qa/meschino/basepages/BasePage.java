package com.qa.meschino.basepages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.constants.MWConstants;

import com.qa.meschino.pages.ProfilePage;
import com.qa.meschino.utils.ExtentManager;
import com.qa.meschino.utils.Xls_Reader;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

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
		
		logger.log(Status.INFO, "Trying to find the element "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s>0)
		{
			logger.log(Status.INFO, "Element found ");
			return true;
		}
		else
		{	logger.log(Status.INFO, "Element not found ");
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
				
		//logger.log(LogStatus.INFO,logger.addScreenCapture(filePath));
		try {
			logger.addScreenCaptureFromPath(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement findAndWait(WebElement e, int sec){
		
		try{
		WebDriverWait wdw = new WebDriverWait(driver, sec);
		wdw.until(ExpectedConditions.visibilityOf(e));
		if(e.isDisplayed())
			return e;
				}
		catch(Throwable t){
			logger.log(Status.ERROR, "Error is reported "+t.getMessage());
			
			//logger.log(Status.ERROR, t);
		}
		return e;
	}
	
	// Report Failure
public void reportFailure(String message) throws IOException{
		
		//logger.log(LogStatus.FAIL, message);
		takeScreenshot();
		Assert.fail(message);
		
	}
	
	// **********************CALENDAR DATE PICKER*************************************

public  void pickDate(String dateToSelect) throws ParseException{
	
	String calMonthYearVisible = driver.findElement(By.xpath(MWConstants.CALENDAR_MONTH_YEAR)).getText();
	
	System.out.println(calMonthYearVisible);
	
		
	Date d= new Date();
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date d1 = sdf.parse(dateToSelect);
	
	
	String month = new SimpleDateFormat("MMMM").format(d1);
	String year = new SimpleDateFormat("yyyy").format(d1);
	String day = new SimpleDateFormat("dd").format(d);
	
	String dayToSelect = new SimpleDateFormat("dd").format(d1);
	String calMonthYearToSelect = month+" "+year;
	//System.out.println(month+"  "+year+ " "+day);
	
	
	while(!calMonthYearVisible.equalsIgnoreCase(calMonthYearToSelect)){
		
		if(d1.before(d)){
			driver.findElement(By.xpath(MWConstants.CALENDAR_LEFT_ARROW)).click();
			
		}else{
			
			driver.findElement(By.xpath(MWConstants.CALENDAR_RIGHT_ARROW)).click();
			
		} // While loop ends
		
		
		
		calMonthYearVisible = driver.findElement(By.xpath(MWConstants.CALENDAR_MONTH_YEAR)).getText();
	}
		
		
		WebElement cal = driver.findElement(By.xpath(MWConstants.CALENDAR_SELECT_DAY));
		
		List<WebElement> days = cal.findElements(By.className("day"));
		
		for(int i=0;i<days.size();i++){
            
			if(days.get(i).getText().equals(dayToSelect)){
			days.get(i).click();
			break;
			}
		}
	
	
}

//********************CALENDAR TIME PICKER**************************************
public void pickTime(String time){
	
	System.out.println(" tryin to set time");
	JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("document.getElementById('Time').value = '"+time+"';");
}




//*************************CURRENT DATE AND TIME PICKER*****************************************


public  String getCurrentDate(){
	Date cdate= new Date();
	String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(cdate);
	return currentDate;
}


public String getCurrentTime(){
	Date cdate= new Date();
	String currentTime = new SimpleDateFormat("hh:mm a").format(cdate);
	return currentTime;
}




}

package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;

public class TrackersAndResourcesPage  extends BasePage{
	
	
	public TrackersAndResourcesPage(WebDriver driver, ExtentTest logger){
		
		super(driver,logger);
	}

	//CONFIRMATION MESSAGE BOX
	
	@FindBy(xpath="//div[@class='bootbox-body']")
	WebElement message;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement okbutton;
	
	
	
	//GET Confirmation message
	
		public String getConfirmationMessage(){
			
			return findAndWait(message, 20).getText();
		}
	
	// Click on OK button on Confirmation msg box
	
	public void clickOK(){
		findAndWait(okbutton, 20).click();
	}
	
	// Recent Tracking
	
		@FindBy(xpath="//div[@class='recent-track']/table/tbody/tr[1]/td[1]")
		WebElement record;
		
	
		
		public String getlog(){
			
			String a = findAndWait(record, 20).getText().trim();
			
		return	a;
			 
		}
		
	
	// Blood Glucose Tracker Elements
	@FindBy(xpath="//a[contains(text(),'Blood Glucose Tracker')]")
	WebElement bloodglucose;
	
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	WebElement calendar;
	
	@FindBy(id="BloodSugerLevel")
	WebElement bglevel;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement saveButton;
	
	@FindBy(xpath="//h4[@class='modal-title']/button")
	WebElement closeButton;
	
	@FindBy(xpath="//a[@class='pull-right link']")
	WebElement reset;
	
	
	//Blood Glucose Tracker Functions
	public void openBGTracker(){
		logger.log(Status.INFO, "Opening Blood Glucose Tracker");
		
		findAndWait(bloodglucose, 30).click();
	}
	
	public void clickOnCalendar(){
		
		logger.log(Status.INFO, "Clicking on Calendar");
		findAndWait(calendar, 20).click();
	}
	
	
	public void logBGLevel(String bgValue){
		logger.log(Status.INFO, "Entering Blood Glucose Level");
		findAndWait(bglevel, 10).sendKeys(bgValue);
	}
	
	public void clickOnSave(){
		logger.log(Status.INFO, "Clicking on Save Button");
		findAndWait(saveButton, 10).click();
	}
	
	public void closeBGTracker(){
		logger.log(Status.INFO, "Closing Blood Glucose Tracker");
		findAndWait(closeButton, 30).click();
	}
	
	public void clickOnReset(){
		logger.log(Status.INFO, "clicking on Reset");
		findAndWait(reset, 20).click();
	}
	
	
}

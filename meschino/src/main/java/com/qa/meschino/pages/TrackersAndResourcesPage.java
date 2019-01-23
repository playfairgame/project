package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.qa.meschino.basepages.BasePage;

public class TrackersAndResourcesPage  extends BasePage{
	
	
	public TrackersAndResourcesPage(WebDriver driver, ExtentTest logger){
		
		super(driver,logger);
	}

	            //  "//a[contains(text(),'Blood Glucose Tracker')]"
	@FindBy(xpath="//a[contains(text(),'Blood Glucose Tracker')]")
	WebElement bloodglucose;
	
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	WebElement calendar;
	
	public void openBGTracker(){
		
		
		findAndWait(bloodglucose, 30).click();
	}
	
	public void clickOnCalendar(){
		
		findAndWait(calendar, 20).click();
	}
	
}

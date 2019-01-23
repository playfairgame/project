package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.meschino.basepages.BasePage;
//import com.relevantcodes.extentreports.ExtentTest;

public class LandingPage extends BasePage{
	
	
//***********Constructor*****************************


 public LandingPage(WebDriver driver,ExtentTest logger){
	 
	 super(driver, logger);
 }

 @FindBy(id="toolsAndResources")
	WebElement toolstrackers;
	
	
	
	public TrackersAndResourcesPage goToToolsTrackers(){
		
		findAndWait(toolstrackers, 30).click();
		
		TrackersAndResourcesPage trackers = new TrackersAndResourcesPage(driver, logger);
		PageFactory.initElements(driver, trackers);
		return trackers;
	}

}

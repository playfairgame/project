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
	
 @FindBy(xpath="//a[@id='myHra']")
 WebElement myhra;
 
 @FindBy(xpath="//a[@id='researchandReviews']")
 WebElement researchreview;
 
	
 @FindBy(xpath="//a[@id='riskreport']")
	WebElement wellnessplanlink;
 
 
 public MeschinoResearchReviewPage goToMeschinoResearchReview(){
	 System.out.println("click on mrr");
	 findAndWait(researchreview, 30).click();
	 MeschinoResearchReviewPage r = new MeschinoResearchReviewPage(driver, logger);
	 PageFactory.initElements(driver, r);
	 
	 return r;
 }
	
	public CreateMyWellnessPlanPage goToCreateMyWellnessPlan(){
		
		findAndWait(wellnessplanlink, 20).click();
		CreateMyWellnessPlanPage wp = new CreateMyWellnessPlanPage(driver, logger);
		PageFactory.initElements(driver, wp);
		return wp;
	}
	
	
	public TrackersAndResourcesPage goToToolsTrackers(){
		
		findAndWait(toolstrackers, 30).click();
		
		TrackersAndResourcesPage trackers = new TrackersAndResourcesPage(driver, logger);
		PageFactory.initElements(driver, trackers);
		return trackers;
	}

	
	
	public MyHRAPage goToMyHRA(){
		
		findAndWait(myhra, 30).click();
		
		MyHRAPage hra = new MyHRAPage(driver, logger);
		PageFactory.initElements(driver, hra);
		return hra;
		
	}
	
	
	
	
}

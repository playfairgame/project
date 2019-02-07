package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.qa.meschino.basepages.BasePage;

public class MeschinoResearchReviewPage extends BasePage{

	
	public MeschinoResearchReviewPage(WebDriver driver, ExtentTest logger){
		
		super(driver,logger);
		
	}
	
	@FindBy(xpath="//a[@id='healthrisk']")
	WebElement healthrisk;
	
	@FindBy(xpath="//a[@id='ui-id-1']")
	WebElement allmedia;
	
	@FindBy(xpath="//a[@id='ui-id-2']")
	WebElement articles;
	
	@FindBy(xpath="//a[@id='ui-id-3']")
	WebElement downloads;
	
	@FindBy(xpath="//a[@id='ui-id-4']")
	WebElement videos;
	
	
	public void clickOnHealthRisk(){
		findAndWait(healthrisk, 30).click();
	}

	
	public void clickOnAllMedia(){
		
		findAndWait(allmedia, 30).click();
	}
	
	
	public void clickOnArticles(){
		
		findAndWait(articles, 30).click(); 
	}
	
	
	
	public void clickOnDownloads(){
		
		findAndWait(downloads, 30).click();
	}
	
	
	public void clickOnVideos(){
		
		
		findAndWait(videos, 30).click();
	}
	
	
	
	
	
	
	
	
	
}


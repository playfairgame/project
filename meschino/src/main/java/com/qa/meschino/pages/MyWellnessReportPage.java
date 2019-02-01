package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.meschino.basepages.BasePage;

public class MyWellnessReportPage extends BasePage{

	
	public MyWellnessReportPage(WebDriver driver, ExtentTest logger){
		
		super(driver,logger);
	}
	
	@FindBy(xpath="//a[@id='riskreport']")
	WebElement wellnessplanlink;
	
	public CreateMyWellnessPlanPage goToCreateMyWellnessPlan(){
		
		findAndWait(wellnessplanlink, 20).click();
		CreateMyWellnessPlanPage wp = new CreateMyWellnessPlanPage(driver, logger);
		PageFactory.initElements(driver, wp);
		return wp;
	}
	
}

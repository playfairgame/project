package com.qa.meschino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class ProfilePage extends BasePage{
	
	//WebDriver driver;
	//ExtentTest logger;
	
	
	//******************Profile Page is Common for all Pages and can be accessed from all pages*****************
	
	//***************Constructor*******************************

	public ProfilePage(WebDriver driver, ExtentTest logger){
		
		
		this.driver=driver;
		this.logger=logger;
		
		
	}
	
	
	//*******************OBJECT OF PROFILE PAGE****************************************
	
	@FindBy(xpath="//div[@class='username']/span[1]")
	WebElement profileicon;
	
	@FindBy(xpath="//i[@class='icon-user']")
	WebElement profilelink;
	
	@FindBy(xpath="//a[@class='tab_3']")
	WebElement healthtab;
	
	
	public void goToProfile() throws InterruptedException{
	
		logger.log(Status.INFO, "Going to Profile page");
		WebElement e = findAndWait(profileicon, 30);
		
		Actions act = new Actions(driver);
		
		act.moveToElement(e).build().perform();
		Thread.sleep(3000);
		findAndWait(profilelink, 30).click();
		//driver.findElement(By.xpath("//i[@class='icon-user']")).click();
	}
	
	public void goToHealthTab(){
		
		findAndWait(healthtab, 30).click();
		
	}
	
	
	public void chageProfilePic(){
		logger.log(Status.INFO, "changinf profile pic on profile page");
		System.out.println("Profile pic changed");
	}
	
}

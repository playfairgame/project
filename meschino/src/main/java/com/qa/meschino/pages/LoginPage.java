package com.qa.meschino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BasePage{
	
	
	//************Constructor*********************
	public LoginPage(WebDriver driver, ExtentTest logger){
		
	super(driver, logger);
		
	}
	
	//**********Page Objects**************
	
	@FindBy(xpath="//input[@id='UserName']")
	WebElement userName;
	
	@FindBy(id="Password")
	WebElement passWord;

	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	
	//**************Functions*********************
	
	public void lo(String a){
		findAndWait(userName, 10).sendKeys(a);
		
		
	}
	public Object doLogin(String uName, String password){
		
		logger.log(Status.INFO, "Entering Login Credentails");
		findAndWait(userName, 10).sendKeys(uName);
	//	userName.sendKeys(uName);
		
		findAndWait(passWord,10).sendKeys(password);
	//	passWord.sendKeys(password);
		
		logger.log(Status.INFO, "Entered Login Credentails");
		findAndWait(loginButton,10).click();
	//	loginButton.click();
		
		Boolean result;
		if(isElementPresent(MWConstants.HEADER_LOCATOR))
		{
			
			result = true;
		}
		else {
			result = false;
		}
		if(result){
			LandingPage landingpage = new LandingPage(driver, logger);
			PageFactory.initElements(driver, landingpage);
			
			return landingpage;
			
		}else
		{
			LoginPage lpage = new LoginPage(driver, logger);
			PageFactory.initElements(driver, lpage);
			
			return lpage;
		}
		
		
		
	}
}

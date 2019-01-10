package com.qa.meschino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.meschino.basepages.BasePage;

public class LoginPage extends BasePage{
	
	
	//************Constructor*********************
	public LoginPage(WebDriver driver){
		
	super(driver);
		
	}
	
	//**********Page Objects**************
	
	@FindBy(id="UserName")
	WebElement userName;
	
	@FindBy(id="Password")
	WebElement passWord;

	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	
	//**************Functions*********************
	
	public void browseUrl(){
		driver.get("https://www.meschinowellness.com");
	}
	

	public LandingPage doLogin(String uName, String password){
		
		userName.sendKeys(uName);
		passWord.sendKeys(password);
		loginButton.click();
		
		return PageFactory.initElements(driver, LandingPage.class);
		
	}
}

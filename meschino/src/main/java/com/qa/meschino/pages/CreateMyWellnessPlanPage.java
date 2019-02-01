package com.qa.meschino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.qa.meschino.basepages.BasePage;

public class CreateMyWellnessPlanPage extends BasePage{
	
	
	//***********Constructor*****************************
	
	public CreateMyWellnessPlanPage(WebDriver driver, ExtentTest logger){
		
		super(driver, logger);
		
	}
	
	@FindBy(xpath="//a[@id='Physical_Activity']")
	WebElement physicalactivity;
	
	@FindBy(xpath="//a[@id='Overweight']")
	WebElement overweight;
	
	@FindBy(xpath="//a[@id='Blood_Pressure']")
	WebElement bloodpressure;
	
	@FindBy(xpath="//a[@id='Cholesterol']")
	WebElement cholesterol;
	
	@FindBy(xpath="//a[@id='Blood_Glucose']")
	WebElement bloodglucose;
	
	@FindBy(xpath="//a[@id='Blood_Glucose_Level_Unknown']")
	WebElement bloodglucoseunknown;
	
	@FindBy(xpath="//a[@id='Blood_Pressure_Level_Unknown']")
	WebElement bloodpressureunknown;
	
	@FindBy(xpath="//a[@id='Cholesterol_Level_Unknown']")
	WebElement cholesterolunknown;
	
	@FindBy(xpath="//a[@id='Alcohol_Consumption']")
	WebElement alcoholconsumption;
	
	@FindBy(xpath="//a[@id='Smoking']")
	WebElement smoking;
	
	@FindBy(xpath="//a[@id='Stress']")
	WebElement stress;
	
	@FindBy(xpath="//a[@id='Type_2_Diabetes']")
	WebElement diabetes;
	
	@FindBy(xpath="//a[@id='P3_Genetic_Testing']")
	WebElement p3;
	
	@FindBy(xpath="//input[@class='knob knob-arobic']")
	WebElement riskstatus;
	
	public String getRiskStatus(){
		String Actualcolor =   driver.findElement(By.xpath("//input[@class='knob knob-arobic']")).getAttribute("data-fgcolor");
	                         
	//	String Actualcolor = findAndWait(riskstatus, 20).getAttribute("data-fgcolor");
		
		String color="";
		if(Actualcolor.equalsIgnoreCase("#00B40D")){
			color= "Green";
			return color;
		}else if(Actualcolor.equalsIgnoreCase("#FFDA0E") ){
			color= "Yellow";
			return color;
		}else if(Actualcolor.equalsIgnoreCase("#B61300")){
			color="Red";
			return color;
					
		}
		return color;
		
	}
	
	public void clickOnPhysicalActivity(){
		findAndWait(physicalactivity, 20).click();
	}

	public void overweight(){
		findAndWait(overweight, 20).click();
	}
	
	public void clickOnBloodPressure(){
		findAndWait(bloodpressure, 20).click();
	}
	public void clickOnCholesterol(){
		findAndWait(cholesterol, 20).click();
	}
	
	public void clickOnBloodGlucose(){
		
		findAndWait(bloodglucose, 20).click();
	}
	
	public void clickOnBloodGlucoseUnknown(){
		
		findAndWait(bloodglucoseunknown, 20).click();
	}
	public void clickOnBloodPressureKnown(){
		findAndWait(bloodpressureunknown, 20).click();
	}
	
	public void clickOnCholesterolUnknown(){
		findAndWait(cholesterolunknown, 20).click();
	}
	
	public void clickOnAlcoholConsumpton(){
		findAndWait(alcoholconsumption, 20).click();
	}
	
	public void clickOnSmoking(){
		findAndWait(smoking, 20).click();
	}
	
	public void clickOnStress(){
		
		findAndWait(stress, 20).click();
	}
	
	public void clickOnDiabetes(){
		findAndWait(diabetes, 20).click();
	}
	
	public void clickOnP3(){
		findAndWait(p3, 20).click();
	}
	
	
	

}

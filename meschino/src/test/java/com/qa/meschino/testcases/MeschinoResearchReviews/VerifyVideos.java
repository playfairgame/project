package com.qa.meschino.testcases.MeschinoResearchReviews;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.MeschinoResearchReviewPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class VerifyVideos extends BaseTest{
	
	
	//
	@Test(dataProviderClass=DataProviderFile.class, dataProvider="MeschinoResearchReviews_videos")
	public void videos(Hashtable<String,String> data) throws InterruptedException{
		System.out.println("i am here");

		if(data.get("Runmode").equalsIgnoreCase("N")){
			
			
			throw new SkipException("Skipping the Test case as runmode is NO");
		}
		
		logger.log(Status.INFO, data.get("Description"));
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		
		Object p =l.doLogin(data.get("UserName"), data.get("Password"));
		
		LandingPage lp = (LandingPage) p;
		
		
		
	MeschinoResearchReviewPage r =lp.goToMeschinoResearchReview();
	Thread.sleep(3000);
	
	r.clickOnVideos();
	Thread.sleep(3000);
	System.out.println(driver.findElements(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div[1]")).size());
	
	WebElement a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div[1]"));
	List<WebElement> x = a.findElements(By.tagName("a"));
	System.out.println(x.size());
	for(int i=0;i<x.size();i++){
		
     System.out.println(x.get(i).getText().trim());
		
	}
	
	}

}

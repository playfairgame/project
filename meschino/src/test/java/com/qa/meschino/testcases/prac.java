package com.qa.meschino.testcases;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.MeschinoResearchReviewPage;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
import com.qa.meschino.utils.Xls_Reader;

public class prac extends BaseTest{
	
	
	
	@Test
	public void pracTest() throws InterruptedException{
		

		//logger.log(Status.INFO, data.get("Description"));
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		
		Object p =l.doLogin("Mwtesting222@gmail.com","Admin789@");
		
		LandingPage lp = (LandingPage) p;
		
		
		
	MeschinoResearchReviewPage r =lp.goToMeschinoResearchReview();
	Thread.sleep(3000);
	
	r.clickOnVideos();
	Thread.sleep(3000);
	
	//r.checkVideos();
	
//	driver.findElement(By.xpath("//div[@id='articleTypeTabs']//div[@class='row']//div[1]//div[1]//div[1]")).click();
	
	driver.findElement(By.xpath("//div[@id='articleTypeTabs']//div[@id='div1']//div[2]//div[1]//h4[1]")).click();
	
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//div[@class='header-navigation pull-right font-transform-inherit']/ul/li[5]")).click();
	driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
			
	//
	
	
	}
	
	
	

	

}



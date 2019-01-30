package com.qa.meschino.testcases.MyHRA;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.MyHRAPage;
import com.qa.meschino.testcases.basetest.BaseTest;

public class te12 extends BaseTest{
	
	
	
	@Test(dataProviderClass=DataProviderFile.class, dataProvider="MyHRALogs")
	public void MyHRALog(Hashtable<String, String> data) throws InterruptedException{
		
		
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		
		Object p =l.doLogin(data.get("UserName"), data.get("Password"));
		
		LandingPage lp = (LandingPage) p;
		
		MyHRAPage h = lp.goToMyHRA();
		if(h.isRestart()){
			h.clickOnRestart();
		}
			
		h.selectweight(data.get(h.Q1));
		h.selectwaist(data.get(h.Q2));
		h.clickNext();
		System.out.println("data from excel "+ data.get(h.Q3));
		h.selectAnswerOption("Q1", data.get(h.Q3));
		
		
	}

}

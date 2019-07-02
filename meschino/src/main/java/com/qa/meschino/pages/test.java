package com.qa.meschino.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;

public class test extends BasePage {
	
	@Test
	public void t(){
		
		
//		System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
//		 driver = new ChromeDriver();
		 
		System.out.println(getResponseCode("https://www.cochranelibrary.com/cdsr/doi/10.1002/14651858.CD003402.pub3/full"));
		 
		
	}

}

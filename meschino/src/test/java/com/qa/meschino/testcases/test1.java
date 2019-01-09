package com.qa.meschino.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.meschino.pages.LaunchPage;

public class test1 {

	
	@Test
	public void t1(){
		
		WebDriver driver = new ChromeDriver();
		
		PageFactory.initElements(driver, LaunchPage.class);
		
		System.out.println("Updated after pulling from office");
	}
}

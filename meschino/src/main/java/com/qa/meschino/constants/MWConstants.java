package com.qa.meschino.constants;

public class MWConstants {

	// Driver Paths
	public static final String CHROME_DRIVER_EXE= System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\geckodriver.exe";
	public static final String FIREFOX_DRIVER_EXE= System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\chromedriver.exe";
	

	// URLs
	public static final String PROD_URL = "https://www.meschinowellness.com";
	
	
	// REPORT PATH
	public static final String REPORTS_PATH =System.getProperty("user.dir")+"//Reports//";
	public static final String SCREENSHOTS_PATH =System.getProperty("user.dir")+"//ScreenShots//";
	
	// DATA SHEET PATH
	public static final String DATASHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\testdata\\data.xlsx";
	
	public static final String DATASHEET_NAME = "Test";
	public static final String SUITE_SHEET_NAME = "Suits";
	
	
	//**************LOCATORS***************************
	
	// LoginPage
	   /// verify login
	public static final String HEADER_LOCATOR ="//h2[contains(text(),'My Wellness Wallet')]";
	
	public static final String WELCOME_POPUP ="//div[@class='modal-content']/button[@class='close']";
	
	// EMAIL EXTENT REPORT - USERNAME AND PASSWORD
	public static final String emailID = "aneelbb@mail.com";
	public static final String password = "Hello789@";
	
	
	
	
	
	
	
}

package com.qa.meschino.constants;

public class MWConstants {
	
	// Driver Paths
	public static final String CHROME_DRIVER_EXE= System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\chromedriver.exe";
	public static final String FIREFOX_DRIVER_EXE= System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\meschino\\driverFiles\\geckodriver.exe";
	

	// URLs
	public static final String PROD_URL = "https://www.meschinowellness.com";
	public static final String STAGE_URL = "http://stage-meschinowellness.azurewebsites.net";
	
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
	
	//Verify HRA done
	public static final String REPORT_COMPLETED= "//div[@class='report-date']/span";
	
	
	// EMAIL EXTENT REPORT - USERNAME AND PASSWORD
	public static final String emailID = "aneelbb@mail.com";
	public static final String password = "Hello789@";
	
	
	
	// CALAENDAR DATE PICKER ELEMENTS
	public static final String CALENDAR_MONTH_YEAR ="//table[@class=' table-condensed']/thead/tr[1]/th[2]";
	public static final String CALENDAR_LEFT_ARROW = "//table[@class=' table-condensed']/thead/tr[1]/th[1]";
	public static final String CALENDAR_RIGHT_ARROW = "//table[@class=' table-condensed']/thead/tr[1]/th[3]";
	public static final String CALENDAR_SELECT_DAY = "//table[@class=' table-condensed']/tbody";
	
	//DATE PICKER ELEMENTS
	
	
	
}

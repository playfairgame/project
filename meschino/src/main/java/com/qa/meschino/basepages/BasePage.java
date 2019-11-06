package com.qa.meschino.basepages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.constants.MWConstants;

import com.qa.meschino.pages.ProfilePage;
import com.qa.meschino.utils.ExtentManager;
import com.qa.meschino.utils.Xls_Reader;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	
	public WebDriver driver;
	public ExtentTest logger;
	
	public ProfilePage profile;
	
	
	//***********Default Constructor********************
	
	public BasePage(){
	
	}
	
	//*****************Constructor**********************
	public BasePage(WebDriver driver,ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		
		
		
		profile = new ProfilePage(driver, logger);
		PageFactory.initElements(driver, profile);
		
		//profile = PageFactory.initElements(driver, ProfilePage.class);
		
	}
	
	
	//********************Functions**********************
	
	//************Common Page******************
	public ProfilePage getProfile(){
		
		
		return profile;
	}
	

	
	
	public String verifyTitle(String expectedTitle){
		
		return "";
	}
	
	
	public String verifyText(String locator, String expectedText){
		
		return "";
	}
	
	public boolean isElementPresent(String locator){
		
		logger.log(Status.INFO, "Trying to find the element "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s>0)
		{
			logger.log(Status.INFO, "Element found ");
			return true;
		}
		else
		{	logger.log(Status.INFO, "Element not found ");
		return false;
	}
	}
	
	public void takeScreenshot(){
		// code
		Date d = new Date();
		String fName = d.toString().replace(" ", "_").replace(":","_")+".png";
		// Create file path with complete file name
		String filePath=MWConstants.SCREENSHOTS_PATH+fName;
		
		// cast driver into TakeScreensshot interface
		
		TakesScreenshot srcShot = (TakesScreenshot) driver;
	
		// call getScreenshotAs function to create image file 
		
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		// Move image file to destination
		
		File destFile = new File(filePath);
		
		// Copy file  to destination
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//logger.log(LogStatus.INFO,logger.addScreenCapture(filePath));
		try {
			logger.addScreenCaptureFromPath(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement findAndWait(WebElement e, int sec){
		
		try{
		WebDriverWait wdw = new WebDriverWait(driver, sec);
		wdw.until(ExpectedConditions.visibilityOf(e));
		if(e.isDisplayed())
			return e;
				}
		catch(Throwable t){
			logger.log(Status.ERROR, "Error is reported "+t.getMessage());
			
			//logger.log(Status.ERROR, t);
		}
		return e;
	}
	
	// Report Failure
public void reportFailure(String message) throws IOException{
		
		//logger.log(LogStatus.FAIL, message);
		takeScreenshot();
		Assert.fail(message);
		
	}
	
	// **********************CALENDAR DATE PICKER*************************************

public  void pickDate(String dateToSelect) throws ParseException{
	
	String calMonthYearVisible = driver.findElement(By.xpath(MWConstants.CALENDAR_MONTH_YEAR)).getText();
	
	//System.out.println(calMonthYearVisible);
	
		
	Date d= new Date();
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date d1 = sdf.parse(dateToSelect);
	
	
	String month = new SimpleDateFormat("MMMM").format(d1);
	String year = new SimpleDateFormat("yyyy").format(d1);
	String day = new SimpleDateFormat("dd").format(d);
	
	String dayToSelect = new SimpleDateFormat("dd").format(d1);
	String calMonthYearToSelect = month+" "+year;
	//System.out.println(month+"  "+year+ " "+day);
	
	
	while(!calMonthYearVisible.equalsIgnoreCase(calMonthYearToSelect)){
		
		if(d1.before(d)){
			driver.findElement(By.xpath(MWConstants.CALENDAR_LEFT_ARROW)).click();
			
		}else{
			
			driver.findElement(By.xpath(MWConstants.CALENDAR_RIGHT_ARROW)).click();
			
		} // While loop ends
		
		
		
		calMonthYearVisible = driver.findElement(By.xpath(MWConstants.CALENDAR_MONTH_YEAR)).getText();
	}
		
		
		WebElement cal = driver.findElement(By.xpath(MWConstants.CALENDAR_SELECT_DAY));
		
		
		int selectDay = Integer.parseInt(dayToSelect);
		List<WebElement> days = cal.findElements(By.className("day"));
		
		dayToSelect = Integer.toString(selectDay);
		for(int i=0;i<days.size();i++){
            
			if(days.get(i).getText().equals(dayToSelect)){
				
			days.get(i).click();
			break;
			}
		}
	
	
}

//********************CALENDAR TIME PICKER**************************************
public void pickTime(String time){
	
	logger.log(Status.INFO, "Picking Time");
	JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("document.getElementById('Time').value = '"+time+"';");
}




//*************************CURRENT DATE AND TIME PICKER*****************************************


public  String getCurrentDate(){
	Date cdate= new Date();
	String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(cdate);
	return currentDate;
}


public String getCurrentTime(){
	Date cdate= new Date();
	String currentTime = new SimpleDateFormat("hh:mm a").format(cdate);
	return currentTime;
}




//*****************************GET RESPONSE CODE*****************************************************

public int getResponseCode(String url){
	
	System.setProperty("jsse.enableSNIExtension", "false");
	HttpURLConnection huc = null;
	int respCode = 0;
	
	try {
        huc = (HttpURLConnection)(new URL(url).openConnection());
        
        huc.setRequestMethod("HEAD");
        
        huc.connect();
        
        respCode = huc.getResponseCode();
        
        System.out.println("The Response Code is === "+ respCode);
        
        return respCode;
            
    } catch (Throwable t) {
        // TODO Auto-generated catch block
    
    	String msg= t.getMessage();
    	logger.log(Status.ERROR, msg);
    	
        
    } 
	return respCode;
	
	
	
	
	/*
	int resp_code=0;
	try{
		
		resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
		
	}catch(Throwable t){
		String msg = t.getMessage();
		logger.log(Status.ERROR,msg);
	}
	return resp_code;
//	if(resp_code==200)
//	return true;
//	else
//		return false;
//	
 * 
 * 
 */
}

//***************************GET PROFILE DATA******************************************

public Hashtable<String, String> getProfileData(String tabName, String fieldName) throws ParseException, IOException{
	String tab="";
	String updatedTime="";
	String updatedDate="";
	String metric;
	String name="";
	if(tabName.equalsIgnoreCase("Health")){
		driver.findElement(By.xpath("//a[@class='tab_3']")).click();
		tab= "tab_3";
	}else if (tabName.equalsIgnoreCase("Lifestyle")){
		driver.findElement(By.xpath("//a[@class='tab_2']")).click();
		tab= "tab_2";
	}else if(tabName.equalsIgnoreCase("Personal"))
	{
		driver.findElement(By.xpath("//a[@class='tab_1']")).click();
		tab= "tab_1";
	}
	
	
//	driver.findElement(By.xpath("//div[@class='tabbable']/ul/li[2]/a")).click();
	
	
	WebElement t= driver.findElement(By.xpath("//div[@id='divMeasurements_"+tab+"']/table/tbody"));
	
 List<WebElement> li = t.findElements(By.tagName("tr"));
 Hashtable<String, String> table = new Hashtable<String, String>();  
 
 int rowNumber=0;
 for(int rows=1;rows<=li.size();rows++){
	 rowNumber= rows;
	 if(driver.findElements(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[1]//div[5]")).size()>0){
		  	name = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[1]//div[5]")).getText();
		 if(name.equalsIgnoreCase(fieldName)){
			 break; 
		 }else{
			 rowNumber=0;
		 }
			 
		 
	 }
	 
 }// end for
 
// System.out.println("Row number is "+ rowNumber);
	 
	 if(rowNumber>0){
		 
		
		 String value = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rowNumber+"]//td[2]//div[1]")).getText();
		 
		 if(driver.findElements(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rowNumber+"]//td[3]//select[1]")).size()>0)
			{	
				metric = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rowNumber+"]//td[3]//select//option")).getText();
			}
		 
		 else
		    {
			metric ="Null";
			//metric=driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[3]")).getText();
			
	        }
		 		String source = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rowNumber+"]//td[4]")).getText();
		 		String time= driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rowNumber+"]//td[5]")).getText();
		 		if(!time.equalsIgnoreCase("")){
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
					    Date d = sdf.parse(time);
					    updatedTime = new SimpleDateFormat("HH:mm a").format(d);
					    updatedDate = new SimpleDateFormat("MM/dd/yyyy").format(d);
					}
					else
					{
						updatedTime ="0";
						updatedDate="0";
					}
		 		String valuekey = name+" value";
				String metrickey = name+ " metric";
				String sourcekey = name+ " source" ;
				String datekey = name+" date";
				String timekey = name+" time";
						
						table.put(valuekey, value);
						table.put(metrickey, metric);
						table.put(sourcekey, source);
						table.put(datekey, updatedDate);
						table.put(timekey, updatedTime);
		 		
		 		
		 
	 }else
	 {
		 reportFailure(fieldName+" does not exist");
		 return null;
	 }
	
 return table;
}// function ends


}

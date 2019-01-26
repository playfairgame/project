package com.qa.meschino.testcases.BloodGlucoseTracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.testcases.basetest.BaseTest;

public class testing extends BaseTest {
	
	private static final int Hashtable = 0;
	WebDriver  driver;
	
    @Test 
	public void t2() throws InterruptedException, ParseException{
		
		
    	
    	System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
			driver.get(MWConstants.PROD_URL);
			
			driver.findElement(By.id("UserName")).sendKeys("mwtesting222@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("Admin789@");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(8000);
			WebElement e = driver.findElement(By.xpath("//div[@class='username']/span[1]"));
			
			Actions act = new Actions(driver);
			
			act.moveToElement(e).build().perform();
			
			driver.findElement(By.xpath("//i[@class='icon-user']")).click();
			Thread.sleep(3000);
			
			Hashtable<String, String> table = getProfileData("Personal");
			
		 			System.out.println(table.get("Height value"));
		 			System.out.println(table.get("Height metric"));
					
					
					
					
					
					
			
		
			
			
			
	}
    
    public Hashtable<String, String> getProfileData(String tabName) throws ParseException{
    	String tab="";
    	String updatedTime="";
		String updatedDate="";
		String metric;
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
	 for(int rows=1;rows<=li.size();rows++){
	   if(driver.findElements(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[1]//div[5]")).size()>0){
		String name = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[1]//div[5]")).getText();
		String value = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[2]//div[1]")).getText();
		
		if(driver.findElements(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[3]//select[1]")).size()>0)
		{	
		 metric = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[3]//select//option")).getText();
		}
		else{
			metric ="Null";
			//metric=driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[3]")).getText();
			
		}
		 
		String source = driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[4]")).getText();
		String time= driver.findElement(By.xpath("//div[@id='"+tab+"']//tbody//tr["+rows+"]//td[5]")).getText();
		
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
	    		
	 }	
    }// for loop ends
	 return table;
    }// function ends

	
	
}

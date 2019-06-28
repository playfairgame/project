package com.qa.meschino.pages;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.qa.meschino.basepages.BasePage;

public class MeschinoResearchReviewPage extends BasePage{

	
	public MeschinoResearchReviewPage(WebDriver driver, ExtentTest logger){
		
		super(driver,logger);
		
	}
	
	@FindBy(xpath="//a[@id='healthrisk']")
	WebElement healthrisk;
	
	@FindBy(xpath="//a[@id='ui-id-1']")
	WebElement allmedia;
	
	@FindBy(xpath="//a[@id='ui-id-2']")
	WebElement articles;
	
	@FindBy(xpath="//a[@id='ui-id-3']")
	WebElement downloads;
	
	@FindBy(xpath="//a[@id='ui-id-4']")
	WebElement videos;
	
	@FindBy(xpath="//a[@id='btnWellnessLibrary']")
	WebElement savetolibrarybutton;
	
	@FindBy(xpath="//div[@class='header-navigation pull-right font-transform-inherit']/ul/li[5]")
	WebElement reviewlink;
	
	@FindBy(xpath="//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")
	WebElement reviewsidebarlink;
	
	public void clickOnHealthRisk(){
		findAndWait(healthrisk, 30).click();
	}

	
	public void clickOnAllMedia(){
		
		findAndWait(allmedia, 30).click();
	}
	
	
	public void clickOnArticles(){
		
		findAndWait(articles, 30).click(); 
	}
	
	
	
	public void clickOnDownloads(){
		
		findAndWait(downloads, 30).click();
	}
	
	
	public void clickOnVideos(){
		
		
		findAndWait(videos, 30).click();
	}
	
	
	public void findLinksOnArticle(){
		                                           		
	WebElement eLink = driver.findElement(By.xpath("//div[@class='article-wrapper']"));
	List<WebElement> externalLinks = eLink.findElements(By.tagName("a"));
	
	int externalActualLinks= externalLinks.size()-3;
	logger.log(Status.INFO, "Number of External Links in the Article are: " + externalActualLinks);
	
	System.out.println("Number of External Links in the Article are: " + externalActualLinks);
	//int statusCode=0;
	int status;
	String href;
	for(int l=0;l<externalActualLinks;l++){
	
		href = externalLinks.get(l).getAttribute("href");
		 status = getResponseCode(href);
		if (status != 200){
			logger.log(Status.ERROR, "External Link Failed: " + externalLinks.get(l).getText()+" Status Code: "+ status);
		}else{
			logger.log(Status.INFO, "External Link Passed: " + externalLinks.get(l).getText());
		}
		
		System.out.println(externalLinks.get(l).getText());
		
	}
	
		
	}
	

public int checkVideos() throws InterruptedException{
		int counter =0;
		//System.out.println(driver.findElements(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div[1]")).size());
		for(int x=1; x<=3;x++){ //outer for loop
			
			if(isElementPresent("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]")){ // if begin
				WebElement a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
				List<WebElement> row = a.findElements(By.tagName("a"));
				//System.out.println("number of links "+row.size());
				for(int i=0;i<row.size();i++){ // inner for loop
					
				 String link= row.get(i).getText().trim();
			     
			     //System.out.println(link);
			     //System.out.println("about to click");
			     
			     WebElement element =  row.get(i);
			     JavascriptExecutor executor = (JavascriptExecutor)driver;
			     executor.executeScript("arguments[0].click();", element);
			     
			     
			    // row.get(i).click();
			     
			     String title = driver.getTitle();
			    
			     if(!isElementPresent("//a[@id='btnWellnessLibrary']")){
			    	 
			    	 if (title.equalsIgnoreCase("Page Not Found")){
			    		 counter= counter+1; 
				    	 logger.log(Status.ERROR, "Link Failed ----> "+ link);
				    	
				    	 findAndWait(reviewlink, 20).click();
			    	 //driver.findElement(By.xpath("//div[@class='header-navigation pull-right font-transform-inherit']/ul/li[5]")).click();
				    
				    	 findAndWait(videos, 20).click();
				    	// driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
			    	
			    	 
			    	 }else{
			    		 
			    		 logger.log(Status.ERROR, "Link Failed ----> "+ link);
				    	 counter= counter+1; 
				    findAndWait(reviewsidebarlink, 20).click();
				    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
					     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
			    	 findAndWait(videos, 20).click();
			    	 
			    	 }
			     }  
			     else{
			    	 
			    	 logger.log(Status.INFO, "Link Passed --> "+ link);
			    	 findAndWait(reviewsidebarlink, 20).click();
			    	 findAndWait(videos, 20).click();
			    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
				     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
			     }
			           
						     
			     a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
				 row = a.findElements(By.tagName("a"));
			
				
				}
				
			} // if ends
			else {
				logger.log(Status.INFO, "Record not found");
		     	break;
			}
			
			
			
			
		}
		return counter;
	
	
}



public int checkArticles() throws InterruptedException{
	int counter =0;
	//System.out.println(driver.findElements(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div[1]")).size());
	for(int x=1; x<=3;x++){ //outer for loop
		
		if(isElementPresent("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]")){ // if begin
			WebElement a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
			List<WebElement> row = a.findElements(By.tagName("a"));
			//System.out.println("number of links "+row.size());
			for(int i=0;i<row.size();i++){ // inner for loop
				
			 String link= row.get(i).getText().trim();
		     
		     //System.out.println(link);
		     //System.out.println("about to click");
		     
		     WebElement element =  row.get(i);
		     JavascriptExecutor executor = (JavascriptExecutor)driver;
		     executor.executeScript("arguments[0].click();", element);
		     
		     
		    // row.get(i).click();
		     
		     String title = driver.getTitle();
		    
		     if(!isElementPresent("//a[@id='btnWellnessLibrary']")){
		    	 
		    	 if (title.equalsIgnoreCase("Page Not Found")){
		    		 counter= counter+1; 
			    	 logger.log(Status.ERROR, "Link Failed ----> "+ link);
			    	
			    	 findAndWait(reviewlink, 20).click();
		    	 //driver.findElement(By.xpath("//div[@class='header-navigation pull-right font-transform-inherit']/ul/li[5]")).click();
			    
			    	 findAndWait(articles, 20).click();
			    	// driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		    	
		    	 
		    	 }else{
		    		 
		    		 logger.log(Status.ERROR, "Link Failed ----> "+ link);
			    	 counter= counter+1; 
			    findAndWait(reviewsidebarlink, 20).click();
			    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
				     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		    	 findAndWait(articles, 20).click();
		    	 
		    	 }
		     }  
		     else{
		    	 
		    	 logger.log(Status.INFO, "Link Passed --> "+ link);
// Check number of links in the Article    "HTML", "Usage: <b>BOLD TEXT</b>"
		    	
		    	 logger.log(Status.INFO, "Checking the Links on the Article: "+ link);
		    	 
		    	 findLinksOnArticle();
		    	 
		    	 ///*********************************
		    	 findAndWait(reviewsidebarlink, 20).click();
		    	 findAndWait(articles, 20).click();
		    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
			     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		    	 
		    	 
		    	
		    	 
		    	 
		    	 
		    	 
		     }
		           
					     
		     a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
			 row = a.findElements(By.tagName("a"));
		
			
			}
			
		} // if ends
		else {
			logger.log(Status.INFO, "Record not found");
	     	break;
		}
		
		
		
		
	}
	return counter;


}

public int checkDownloads() throws InterruptedException{
	int counter =0;
	//System.out.println(driver.findElements(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div[1]")).size());
	for(int x=1; x<=3;x++){ //outer for loop
		
		if(isElementPresent("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]")){ // if begin
			WebElement a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
			List<WebElement> row = a.findElements(By.tagName("a"));
			//System.out.println("number of links "+row.size());
			for(int i=0;i<row.size();i++){ // inner for loop
				
			 String link= row.get(i).getText().trim();
		     
		     //System.out.println(link);
		     //System.out.println("about to click");
		     
		     WebElement element =  row.get(i);
		     JavascriptExecutor executor = (JavascriptExecutor)driver;
		     executor.executeScript("arguments[0].click();", element);
		     
		     
		    // row.get(i).click();
		     
		     String title = driver.getTitle();
		    
		     if(!isElementPresent("//a[@id='btnWellnessLibrary']")){
		    	 
		    	 if (title.equalsIgnoreCase("Page Not Found")){
		    		 counter= counter+1; 
			    	 logger.log(Status.ERROR, "Link Failed ----> "+ link);
			    	
			    	 findAndWait(reviewlink, 20).click();
		    	 //driver.findElement(By.xpath("//div[@class='header-navigation pull-right font-transform-inherit']/ul/li[5]")).click();
			    
			    	 findAndWait(downloads, 20).click();
			    	// driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		    	
		    	 
		    	 }else{
		    		 
		    		 logger.log(Status.ERROR, "Link Failed ----> "+ link);
			    	 counter= counter+1; 
			    findAndWait(reviewsidebarlink, 20).click();
			    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
				     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		    	 findAndWait(downloads, 20).click();
		    	 
		    	 }
		     }  
		     else{
		    	 
		    	 logger.log(Status.INFO, "Link Passed --> "+ link);
		    	 findAndWait(reviewsidebarlink, 20).click();
		    	 findAndWait(downloads, 20).click();
		    	 //driver.findElement(By.xpath("//div[@class='page-sidebar navbar-collapse collapse']/ul/li[5]/a")).click();
			     //driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		     }
		           
					     
		     a = driver.findElement(By.xpath("//div[@class='tab-content']/div[2]/div[3]/div["+x+"]"));
			 row = a.findElements(By.tagName("a"));
		
			
			}
			
		} // if ends
		else {
			logger.log(Status.INFO, "Record not found");
	     	break;
		}
		
		
		
		
	}
	return counter;


}




}

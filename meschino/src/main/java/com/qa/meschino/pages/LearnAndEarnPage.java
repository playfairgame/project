package com.qa.meschino.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;

public class LearnAndEarnPage extends BasePage{

	
	
	public  LearnAndEarnPage(WebDriver driver, ExtentTest logger){
		super(driver,logger);
		
	}
	
	
	@FindBy (xpath="//a[@class='btn btn-back']")
	WebElement backButton;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	WebElement backButtonLE;
	
	
	public void clickLEBack(){
		
		findAndWait(backButtonLE, 10).click();
	}
	public void clickOnBack(){
		
		findAndWait(backButton, 10).click();
	}
	
	
	public void findLinksOnLearnAndEearn(){
		
		WebElement lePage = driver.findElement(By.xpath("//div[@class='tab-content']/div[1]"));
		int status;
		String href;
		List<WebElement> leLinks = lePage.findElements(By.tagName("a"));
		int number =leLinks.size()-1;
		logger.log(Status.INFO, "Number of Links on this Learn and Earn:--->  "+number);
		
		System.out.println("Number of links on the LE are: "+ number );
		for(int lelink=0;lelink<leLinks.size();lelink++){
			
			href = leLinks.get(lelink).getAttribute("href");
			if(href!=null){
			System.out.println("href is "+ href);
		if(!href.equalsIgnoreCase("javascript:;")){	   // submit and complete quit
			//System.out.println("link is not submit or complete quiz");
			logger.log(Status.INFO, "Checking the link: "+href);
			
			status = getResponseCode(href);
			if (status >= 400){
				logger.log(Status.ERROR, "********** EXTERNAL LINK FAILED ******** --->>> " + leLinks.get(lelink).getText()+" Status Code: "+ status);
			}else{
				logger.log(Status.INFO, "External Link Passed: " + leLinks.get(lelink).getText()+ status);
			}
			System.out.println(leLinks.get(lelink).getText());
		
		} // end if for submit and complete quiz
		}// end of FOR Loop
		}
		
	}
	
	
	
	public int verifyLearnAndEarn(){
		int leCounter =0;
		
		if(isElementPresent("//div[@class='row leCategories']")){
			//System.out.println("l&e present");
			List<WebElement> catRows = driver.findElements(By.xpath("//div[@class='row leCategories']"));
			for(int c = 0;c<catRows.size();c++){ //// change it to zero
				
				WebElement row = catRows.get(c);
				//System.out.println("Category Name: "+row.getText());
				
				// find categories in a row
				List<WebElement> colsInRow = row.findElements(By.className("col-md-4"));
				for(int Cols=0;Cols<colsInRow.size();Cols++){ 
					
					WebElement col = colsInRow.get(Cols);
					logger.log(Status.INFO, "************* CHECKING THE CATEGORY *****************  >>>   "+ col.getText());
					//System.out.println("Category Name: "+ col.getText());
					
					// Click on the Category
					WebElement li = col.findElement(By.tagName("a"));
					//System.out.println(li.getText());
					JavascriptExecutor executor = (JavascriptExecutor)driver;
				    executor.executeScript("arguments[0].click();", li);
					
				    
					if(isElementPresent("//div[@class='row leCategories']")){
						// System.out.println("learn and earns present");
						// If Learn and Earn exists then get the Number of rows
						List<WebElement> learnRows = driver.findElements(By.xpath("//div[@class='row leCategories']"));
					
						// Loop for each Learn and Earn Row
						for(int learnRow = 0;learnRow<learnRows.size();learnRow++){  /// Loop for Learn and Earn LINKS-------->>>>
							
							WebElement lRow = learnRows.get(learnRow);
							
							 
							// Find number of Columns for Learn and Earns 
							List<WebElement> leColumns = lRow.findElements(By.className("col-md-4"));
						
							// Loop for each Learn and Earn Column
							for(int leCols=0;leCols<leColumns.size();leCols++){
								
								WebElement leCol = leColumns.get(leCols);
							
								String leTitle = leCol.findElement(By.tagName("a")).getText();
								//System.out.println("Learn and Earn Name is: "+leTitle);
								
									logger.log(Status.INFO,"********* CHECKING LEARN AND EARN TITLE ***************  "+leTitle);	
								
								
								// Get L&E Link	
								WebElement leLink = leCol.findElement(By.tagName("a"));
								
								// Click on Learn and Earn to Verify if it Opens
									
									JavascriptExecutor exe = (JavascriptExecutor)driver;
								    exe.executeScript("arguments[0].click();", leLink);
								        
								        // Verify L&E
//								    String actualTitle = driver.findElement(By.xpath("//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li[1]/a")).getText();
//								    System.out.println(actualTitle+"Printed title");
//								    clickLEBack();
								    
								        if(isElementPresent("//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li[1]")){
								        	
								        	String title = driver.getTitle();
								        	//String actualTitle = driver.findElement(By.xpath("//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li[1]/a")).getText();
								        	
								        	if(title.equalsIgnoreCase("Page Not Found")){
								        		// i am here
								        		logger.log(Status.ERROR, "*********  LEARN AND EARN FAILED TO OPEN **********");
									        	leCounter = leCounter+1;
									        	//System.out.println("Link failed - 2");
									        	clickLEBack();
								        		
								        	}else{
								        		logger.log(Status.INFO, "****** LEARN AND EARN OPENED ********");
									        	
									        	//System.out.println("Link passed -1");
									        	
									        	findLinksOnLearnAndEearn();
									        	clickLEBack();
								        		
								        	}
								        	
								        	
								        }else{
								        	
								        	logger.log(Status.ERROR, "***** LEARN AND EARN FAILED TO OPEN *******");
								        	leCounter = leCounter+1;
								        //	System.out.println("Link failed - 3");
								        	clickLEBack();
								        	
								        }
							    
								    learnRows = driver.findElements(By.xpath("//div[@class='row leCategories']"));
							        lRow = learnRows.get(learnRow);
							        leColumns = lRow.findElements(By.className("col-md-4"));
								        
								
							}// this is the end of loop
							
						
						}

						
						clickOnBack();
					}else{
						
						System.out.println("learn and earns not available");
						clickOnBack();
					}
					
					catRows = driver.findElements(By.xpath("//div[@class='row leCategories']"));
					row = catRows.get(c);
					colsInRow = row.findElements(By.className("col-md-4"));
				
				}
				
				
				
				
				
			}
			
			
			
		}else{
			
			System.out.println("record not present");
			logger.log(Status.INFO, "Record Not Available");
			
			
		}
		System.out.println(driver.findElements(By.xpath("//div[@class='row leCategories']")).size());
		return leCounter;
	}
	
    
}
package com.qa.meschino.pages;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JLabel;

import java.net.MalformedURLException;
import java.awt.Font;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;

public class test extends BasePage {
	
	@Test
	public void t(){
		
		System.setProperty("jsse.enableSNIExtension", "false");
		HttpURLConnection huc = null;
		int respCode = 200;
//		System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
//		 driver = new ChromeDriver();
		String url="";
		 
	//	System.out.println(getResponseCode("https://www.lead.org.au/fs/Fact_sheet-Nutrients_that_reduce_lead_poisoning_June_2010.pdf"));
	
		 url=  "file:///H:/Nutrients%20of%20Interest/artimisinin%20and%20CRC.pdf";
	
		 
		 
		try {
			System.out.println("i am in");
            huc = (HttpURLConnection)(new URL(url).openConnection());
            
//            huc.setRequestMethod("HEAD");
//            
//            huc.connect();
//            
//           respCode = huc.getResponseCode();
//            
//            System.out.println("The Response Code is === "+ respCode);
//            
            if(respCode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
                
        }// catch (MalformedURLException e) {
        
		catch(Throwable t){
		// TODO Auto-generated catch block
        	System.out.println("i am out in mal");
            System.out.println(t.getMessage());
		}
//        } catch (IOException e) {
//        	System.out.println("i am out in IO");
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//		
		
		
		
		
	}

}

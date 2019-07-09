package com.qa.meschino.pages;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JLabel;

import java.net.MalformedURLException;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;

public class test extends BasePage {
	
	@Test
	public void t() throws IOException{
		
		System.setProperty("jsse.enableSNIExtension", "false");
		HttpURLConnection huc = null;
		int respCode = 200;
//		System.setProperty("webdriver.chrome.driver",MWConstants.CHROME_DRIVER_EXE );
//		 driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", MWConstants.EDGE_DRIVER_EXE);
	
		 driver = new EdgeDriver();

//	 driver.get("https://meschinowellness.blob.core.windows.net/downloads/LowerBloodPressure-eBook.pdf");
	
		 
//		 URL pdfURL;
//		 
//		 BufferedInputStream bis ;
//		 PDFParser parser;
//		 String getURL;
//		 String text;
//		 
//		 
//		 
//	  File file = new File("C:\\Users\\aneel.bhullar\\Desktop\\protein_food_chart.pdf");
//	  FileInputStream fis = new FileInputStream(file);
//	  
//	  PDFParser parser = new PDFParser(fis);
//	  System.out.println("before parse");
//	  parser.parse();
//	  System.out.println("after parse");
//      COSDocument cosDoc =  parser.getDocument();
//      PDDocument pdDoc = new PDDocument(cosDoc);
//      
//      PDFTextStripper strip = new PDFTextStripper();
//      String data= strip.getText(pdDoc);
//	 	 System.out.println(data);
//	 	 
//	 	 cosDoc.close();
//	 	 pdDoc.close();
	 	 
		 
		 String url="";
		 
	
	
		 url=  "https://meschinowellness.blob.core.windows.net/downloads/protein_food_chart.pdf";
	
		 
		 
		try {
			System.out.println("i am in");
            huc = (HttpURLConnection)(new URL(url).openConnection());
            
            
            if(respCode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
                
        }
        
		catch(Throwable t){
		
        	System.out.println("i am out in mal");
            System.out.println(t.getMessage());
		}
		
	
		
		
	}

}

package com.qa.meschino.utils;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.*;
//import com.aventstack.extentreports.ExtentReports;
import com.qa.meschino.constants.MWConstants;
//import com.relevantcodes.extentreports.DisplayOrder;
//import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	
	public static ExtentReports getInstance() {
		if (extent == null) {
			
			
			createInstance("TestReport/extent.html");
			/*
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath =MWConstants.REPORTS_PATH+fileName;
 
			//extent = new ExtentReports(reportPath, true);
		extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo(
					"Environment", "Regression");
					*/
			
		}
		return extent;
	}
	 public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	       
	        extent = new ExtentReports();
	        
	        extent.attachReporter(htmlReporter);
	        
	        return extent;
	    }
}

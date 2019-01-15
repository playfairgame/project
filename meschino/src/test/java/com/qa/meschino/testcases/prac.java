package com.qa.meschino.testcases;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
import com.qa.meschino.utils.Xls_Reader;

public class prac extends BaseTest{
	String testCaseName = "TestB";
	
	
	@Test(dataProvider="getData")
	public void pracTest(Hashtable<String, String> data){
		
		System.out.println("Name "+ data.get("Name")+" Age "+ data.get("Age")+" Sex "+data.get("Sex")+" Address "+data.get("Address")+" date of birth "+data.get("DOB"));
	}
	
	
	

	@DataProvider
	public Object[][] getData(){
		
		return DataUtils.getData(xls, testCaseName);
	}
    

}



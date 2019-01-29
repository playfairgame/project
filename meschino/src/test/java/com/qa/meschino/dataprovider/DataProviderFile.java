package com.qa.meschino.dataprovider;

import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
import org.testng.annotations.DataProvider;


public class DataProviderFile extends BaseTest{
	
	
	@DataProvider(name="testData")
	public static Object[][] getData(){
	
		Object[][] data = new Object[2][2];
		
		data[0][0] = "one";
		data[0][1] ="two";
		data[1][0]= "sub";
		data[1][1]="start";
		
		return data;
		
	}
	
	
	//Login
	
	@DataProvider(name="LoginTest")
	public Object[][] getDataLogin(){
		return DataUtils.getData(xls, "LoginTest");
	}
	
	@DataProvider(name="BloodGlucoseTest")
	public static Object[][] getDataBG(){
		return DataUtils.getData(xls, "BloodGlucoseTest");
	}

	
	@DataProvider(name="BloodGlucoseOnProfile")
	public static Object[][] getDataBGProfile(){
		return DataUtils.getData(xls, "BloodGlucoseOnProfile");
	}
	
	@DataProvider(name="BloodGlucoseDeleteLogs")
	public static Object[][] getDataBGDelete(){
		return DataUtils.getData(xls, "BloodGlucoseDeleteLogs");
	}
	
	
	
	
	

}



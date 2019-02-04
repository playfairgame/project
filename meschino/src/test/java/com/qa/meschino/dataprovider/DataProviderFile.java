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
	

	@DataProvider(name="MyHRALogsMale")
	public static Object[][] getDataMyHRA(){
		return DataUtils.getData(xls, "MyHRALog_Male");
	}
	
	
	
	@DataProvider(name="MyHRALogsMaleRisk_Alcohol")
	public static Object[][] getDataMyHRAMale(){
		return DataUtils.getData(xls, "HraMaleAlcoholRiskStatus");
	}

	
	@DataProvider(name="MyHRALogsMaleRisk_BloodGlucose")
	public static Object[][] getDataMyHRAMaleBG(){
		return DataUtils.getData(xls, "HraMaleBloodGlucoseRiskStatus");
	}
	
	
	@DataProvider(name="MyHRALogsMaleRisk_BloodGlucoseUnknown")
	public static Object[][] getDataMyHRAMaleBGUnKnown(){
		return DataUtils.getData(xls, "HraMaleBloodGlucoseUnknownRiskStatus");
	}
	
	@DataProvider(name="MyHRALogsMaleRisk_BloodPressure")
	public static Object[][] getDataMyHRAMaleBP(){
		return DataUtils.getData(xls, "HraMaleBloodPressureRiskStatus");
	}
	
	@DataProvider(name="MyHRALogsMaleRisk_BloodPressureUnknown")
	public static Object[][] getDataMyHRAMaleBPUnknown(){
		return DataUtils.getData(xls, "HraMaleBloodPressureUnknownRiskStatus");
	}
	
}



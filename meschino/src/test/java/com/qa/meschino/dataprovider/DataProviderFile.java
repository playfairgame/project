package com.qa.meschino.dataprovider;

import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
import org.testng.annotations.DataProvider;


public class DataProviderFile extends BaseTest{
	
	
	@DataProvider(name="BloodGlucoseTest")
	public Object[][] getData(){
		return DataUtils.getData(xls, "BloodGlucoseTest");
	}
	
	
	
	
	

}



package com.qa.meschino.testcases.BloodGlucoseTracker;

import org.testng.annotations.Test;

import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.testcases.basetest.BaseTest;

public class Test6 extends BaseTest{



@Test
public void tq(){
	
	String a = "391.0";
					
	System.out.println(a.substring(0, a.indexOf(".")));
	
	
}

}

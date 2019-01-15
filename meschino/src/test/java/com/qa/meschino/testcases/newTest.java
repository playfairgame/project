package com.qa.meschino.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.Xls_Reader;

public class newTest extends BaseTest{
	
	
	@Test(dataProvider="getData")
	public void newTest1(Hashtable<String, String> data){
	
		System.out.println("name is  "+ data.get("Name"));
		
	
	}

	
	
	@DataProvider
	public Object[][] getData(){
		
		Xls_Reader xls = new Xls_Reader("C:\\Users\\aneel.bhullar\\Desktop\\data.xlsx");
		

		String testcaseName = "TestB";
		String sheetName ="Test";
		
		int row =1;
		while(!xls.getCellData(sheetName, 0, row).equalsIgnoreCase(testcaseName)){
			
			row++;
		}
		
		int startRowNumOfCol = row+1;
		int startRowNumOfTestData = row+2;
		
		int testDataRows=0;
		
		while (!xls.getCellData(sheetName, 0, startRowNumOfTestData+testDataRows).equals("")){
			testDataRows++;
		}
		
		int testDataCols =0;
		while (!xls.getCellData(sheetName, testDataCols, startRowNumOfCol).equals("")){
			
			testDataCols++;
		}
		
		int dataRowCount = testDataRows;
		int dataColCount = testDataCols;
				
		Object[][] data = new Object[dataRowCount][1];
		Hashtable<String,String> table =null;
		int r=0;
		for(int rowNums=startRowNumOfTestData;rowNums<startRowNumOfTestData+dataRowCount;rowNums++){
			
			table = new Hashtable<String,String>();
			for(int colNums=0;colNums<dataColCount;colNums++){
				
				String key = xls.getCellData(sheetName, colNums, startRowNumOfCol);
				String value = xls.getCellData(sheetName, colNums, rowNums);
				table.put(key, value);
				
			}
		
			data[r][0] =table;
		  r++;
		}
	        return data;	
		
	}
}

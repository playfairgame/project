package com.qa.meschino.utils;

import java.util.Hashtable;

import com.qa.meschino.constants.MWConstants;

public class DataUtils {

	
	public static Object[][] getData(Xls_Reader xls, String testCaseName){
		 String sheetName = MWConstants.DATASHEET_NAME;
		  int rNumber =1;
				 
		 while(!xls.getCellData(sheetName, 0, rNumber).equals(testCaseName)){
			// System.out.println(xls.getCellData(sheetName, 0, rNumber));
			 
			  rNumber++;
		 }
		 
		 int colStartLineNum = rNumber+1;
		 int testDataStartRowNum = rNumber+2;
		 
		 int rowCount=0;
		 
		 while(!xls.getCellData(sheetName, 0, testDataStartRowNum+rowCount).equals("")){
			 rowCount++;
		 }
		// System.out.println(rowCount);
				
		int colCount=0;
		
		
		 while(!xls.getCellData(sheetName, colCount, colStartLineNum).equals("")){
			 colCount++;
		 }
		// System.out.println(colCount);
				
		//Object data[][] = new Object[rowCount][colCount];
		 Object data[][] = new Object[rowCount][1]; // we will create a hashtable, there will be only 1 col	
		int r=0;
		Hashtable<String, String> table =null;
		for(int rowNum=testDataStartRowNum;rowNum<testDataStartRowNum+rowCount;rowNum++){
			
			table = new Hashtable<String, String>();
			
			for(int colNum=0;colNum<colCount;colNum++){
				
			//	System.out.print(xls.getCellData(sheetName, colNum, rowNum));
			//	data[r][colNum] = xls.getCellData(sheetName, colNum, rowNum);
				// put the data in the hashtable as key and values
				
				String key = xls.getCellData(sheetName, colNum, colStartLineNum);
				String value = xls.getCellData(sheetName, colNum, rowNum);
				table.put(key, value);
						
				
			}
			// put the hashtable values in the object array for each row (in each row there will a hashtable)
			data[r][0] = table;
			r++; // increment the row number for object array
			//System.out.println("");
		}
		return data;
		
	}
}

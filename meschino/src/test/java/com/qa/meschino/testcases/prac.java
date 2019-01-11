package com.qa.meschino.testcases;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.qa.meschino.utils.Xls_Reader;

public class prac {
	
	@Test
	public void pracTest(){
		
		Xls_Reader xls = new Xls_Reader("C:\\Users\\aneel.bhullar\\Desktop\\data.xlsx");
		
		
		System.out.println("Number of Rows "+ xls.getRowCount("Login"));
		
	System.out.println("Number of cols "+xls.getColumnCount("Login"));
	
	for(int r=2;r<=xls.getRowCount("Login");r++){
		for(int c=0;c<xls.getColumnCount("Login");c++){
			
			System.out.print(xls.getCellData("Login", c, r));
			
		}
		System.out.println("");
	}
		
	}

}

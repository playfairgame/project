package com.qa.meschino.testcases;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

public class prac {
	
	@Test
	public void pracTest(){
		
		//C:\Users\aneel.bhullar\Desktop
		
		Date d = new Date();
		
		String name = d.toString().replace(" ", "_").replace(":", "_");
        String path= "C:\\Users\\aneel.bhullar\\Desktop\\"+name+".jpg";
		System.out.println(path);
        File f = new File(path);
	
		
		
		System.out.println(f.exists());
	}

}

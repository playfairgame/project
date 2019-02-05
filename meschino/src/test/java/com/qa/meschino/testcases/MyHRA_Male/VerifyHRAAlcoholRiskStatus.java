package com.qa.meschino.testcases.MyHRA_Male;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.meschino.dataprovider.DataProviderFile;
import com.qa.meschino.pages.CreateMyWellnessPlanPage;
import com.qa.meschino.pages.LandingPage;
import com.qa.meschino.pages.LoginPage;
import com.qa.meschino.pages.MyHRAPage;
import com.qa.meschino.pages.MyWellnessReportPage;
import com.qa.meschino.testcases.basetest.BaseTest;



public class VerifyHRAAlcoholRiskStatus extends BaseTest{

	
	@Test(dataProviderClass=DataProviderFile.class, dataProvider="MyHRALogsMaleRisk_Alcohol")
	public void HraAlcoholRiskStatus(Hashtable<String, String> data) throws IOException, InterruptedException{
	
		
		
	if(data.get("Runmode").equalsIgnoreCase("N")){
			
			
			throw new SkipException("Skipping the Test case as runmode is NO");
		}
		
		logger.log(Status.INFO, data.get("Description"));
		init("Chrome");
		
		LoginPage l = new LoginPage(driver, logger);
		PageFactory.initElements(driver, l);
		
		Object p =l.doLogin(data.get("UserName"), data.get("Password"));
		
		LandingPage lp = (LandingPage) p;
		
		MyHRAPage h = lp.goToMyHRA();
		//Thread.sleep(2000);
		if(h.isRestart()){
			
			h.clickOnRestart();
		}
		
		
			
		h.selectweight(data.get(h.Q1));
		h.selectwaist(data.get(h.Q2));
		Thread.sleep(2000);
		h.clickNext();
		
		h.selectAnswerOption("Q1", data.get(h.Q3));
		h.selectAnswerOption("Q2", data.get(h.Q4));
		h.selectAnswerOption("Q3", data.get(h.Q5));
		h.selectAnswerOption("Q4", data.get(h.Q6));
		h.selectAnswerOption("Q5", data.get(h.Q7));
		h.selectAnswerOption("Q6", data.get(h.Q8));
		h.selectAnswerOption("Q7", data.get(h.Q9));
		h.selectAnswerOption("Q8", data.get(h.Q10));
		h.selectAnswerOption("Q9", data.get(h.Q11));
		h.selectAnswerOption("Q10", data.get(h.Q12));
		h.selectAnswerOption("Q11", data.get(h.Q13));
		h.selectAnswerOption("Q12", data.get(h.Q14));
		h.selectAnswerOption("Q13", data.get(h.Q15));
		h.selectAnswerOption("Q14", data.get(h.Q16));
		h.selectAnswerOption("Q15", data.get(h.Q17));
		h.selectAnswerOption("Q16", data.get(h.Q18));
		h.selectAnswerOption("Q17", data.get(h.Q19));
		if(!data.get(h.Q20).equalsIgnoreCase("0")){
			
			h.selectAnswerOption("Q18", data.get(h.Q20));
			h.selectAnswerOption("Q19", data.get(h.Q21));
			h.selectAnswerOption("Q20", data.get(h.Q22));
		}
		h.selectAnswerOption("Q18", data.get(h.Q20));
		h.selectAnswerOption("Q21", data.get(h.Q23));
		h.selectAnswerOption("Q22", data.get(h.Q24));
		h.clickNext();
		
		h.selectAnswerOption("Q23", data.get(h.Q25));
		h.selectAnswerOption("Q24", data.get(h.Q26));
		h.selectAnswerOption("Q25", data.get(h.Q27));
		h.selectAnswerOption("Q26", data.get(h.Q28));
		
		h.selectAnswerOption("Q28", data.get(h.Q29));
		h.selectAnswerOption("Q29", data.get(h.Q30));
		h.selectAnswerOption("Q30", data.get(h.Q31));
		h.clickNext();
		
		h.selectAnswerOption("Q31", data.get(h.Q32));
		h.selectAnswerOption("Q32", data.get(h.Q33));
		h.selectAnswerOption("Q33", data.get(h.Q34));
		h.selectAnswerOption("Q34", data.get(h.Q35));
		h.selectAnswerOption("Q35", data.get(h.Q36));
		h.selectAnswerOption("Q36", data.get(h.Q37));
		
		 if(!data.get(h.Q38).equalsIgnoreCase("Never Smoked")){
			
			 if(!data.get(h.Q38).equalsIgnoreCase("Ex-smoker")){
				 h.selectAnswerOption("Q37", data.get(h.Q38));
				 h.selectAnswerOption("Q38", data.get(h.Q39));
				 h.selectAnswerOption("Q39", data.get(h.Q40));
				 h.selectAnswerOption("Q40", data.get(h.Q41));
			 }
			 h.selectAnswerOption("Q37", data.get(h.Q38));
			 h.selectAnswerOption("Q41", data.get(h.Q42));
			 h.selectAnswerOption("Q42", data.get(h.Q43));
			 h.selectAnswerOption("Q43", data.get(h.Q44));
			 
		 }
		 
		 h.selectAnswerOption("Q37", data.get(h.Q38));
		 h.selectAnswerOption("Q44", data.get(h.Q45));
		 h.selectAnswerOption("Q45", data.get(h.Q46));
		 h.selectAnswerOption("Q46", data.get(h.Q47));
		 h.selectAnswerOption("Q47", data.get(h.Q48));
		 h.selectAnswerOption("Q48", data.get(h.Q49));
		 h.selectAnswerOption("Q49", data.get(h.Q50));
		 h.selectAnswerOption("Q50", data.get(h.Q51));
		 h.selectAnswerOption("Q51", data.get(h.Q52));
		 h.selectAnswerOption("Q52", data.get(h.Q53));
		 h.selectAnswerOption("Q53", data.get(h.Q54));
		 h.selectAnswerOption("Q54", data.get(h.Q55));
		 h.selectAnswerOption("Q55", data.get(h.Q56));
		 h.selectAnswerOption("Q56", data.get(h.Q57));
		 h.selectAnswerOption("Q57", data.get(h.Q58));
		 h.selectAnswerOption("Q58", data.get(h.Q59));
		 //h.selectAnswerOption("Q59", data.get(h.Q60));
		 
		 if(!data.get(h.Q60).equalsIgnoreCase("No")){
			 h.selectAnswerOption("Q59", data.get(h.Q60));
			 h.selectAnswerOption("Q60", data.get(h.Q61));
			 h.selectAnswerOption("Q61", data.get(h.Q62));
			 h.selectAnswerOption("Q62", data.get(h.Q63));
			 h.selectAnswerOption("Q63", data.get(h.Q64));
			 h.selectAnswerOption("Q64", data.get(h.Q65));
			 h.selectAnswerOption("Q67", data.get(h.Q66));
			 h.selectAnswerOption("Q68", data.get(h.Q67));
			 h.selectAnswerOption("Q69", data.get(h.Q68));
			 h.selectAnswerOption("Q70", data.get(h.Q69));
			 h.selectAnswerOption("Q71", data.get(h.Q70));
			 h.selectAnswerOption("Q73", data.get(h.Q71));
			 h.selectAnswerOption("Q74", data.get(h.Q72));
			 h.selectAnswerOption("Q75", data.get(h.Q73));
			 h.selectAnswerOption("Q76", data.get(h.Q74));
			 h.selectAnswerOption("Q77", data.get(h.Q75));
			 h.selectAnswerOption("Q78", data.get(h.Q76));
			 
				 
		 }
		 
		 h.selectAnswerOption("Q59", data.get(h.Q60));
		 h.clickNext();
		 
		 h.selectAnswerOption("Q79", data.get(h.Q77));
		 h.selectAnswerOption("Q82", data.get(h.Q78));
		 h.selectAnswerOption("Q83", data.get(h.Q79));
		 h.selectAnswerOption("Q84", data.get(h.Q80));
		 h.selectAnswerOption("Q86", data.get(h.Q81));
		 h.selectAnswerOption("Q87", data.get(h.Q82));
		 h.selectAnswerOption("Q88", data.get(h.Q83));
		 h.selectAnswerOption("Q89", data.get(h.Q84));
		 h.selectAnswerOption("Q90", data.get(h.Q85));
		 h.selectAnswerOption("Q92", data.get(h.Q86));
		 h.selectAnswerOption("Q93", data.get(h.Q87));
		 h.clickNext();
		
		 h.selectAnswerOption("Q94", data.get(h.Q88));
		 h.selectAnswerOption("Q96", data.get(h.Q89));
		 h.selectAnswerOption("Q97", data.get(h.Q90));
		 h.selectAnswerOption("Q98", data.get(h.Q91));
		 h.selectAnswerOption("Q99", data.get(h.Q92));
		 h.clickNext();
		
 
		 
		 h.selectAnswerOption("Q100", data.get(h.Q93));
		 h.selectAnswerOption("Q101", data.get(h.Q94));
		 h.selectAnswerOption("Q102", data.get(h.Q95));
		 h.selectAnswerOption("Q103", data.get(h.Q96));
		 h.selectAnswerOption("Q104", data.get(h.Q97));
		 h.selectAnswerOption("Q105", data.get(h.Q98));
		 h.selectAnswerOption("Q106", data.get(h.Q99));
		 h.selectAnswerOption("Q107", data.get(h.Q100));
		 h.selectAnswerOption("Q108", data.get(h.Q101));
		 h.clickNext();
		 

		 h.selectAnswerOption("Q109", data.get(h.Q102));
		 h.selectAnswerOption("Q110", data.get(h.Q103));
		 h.selectAnswerOption("Q111", data.get(h.Q104));
		 h.selectAnswerOption("Q112", data.get(h.Q105));
		 h.selectAnswerOption("Q113", data.get(h.Q106));
		 h.selectAnswerOption("Q114", data.get(h.Q107));
		 h.selectAnswerOption("Q115", data.get(h.Q108));
		 h.selectAnswerOption("Q116", data.get(h.Q109));
		 h.selectAnswerOption("Q117", data.get(h.Q110));
		 h.selectAnswerOption("Q118", data.get(h.Q111));
		 h.selectAnswerOption("Q119", data.get(h.Q112));
		 h.clickNext();
		 
		 h.selectAnswerOption("Q120", data.get(h.Q113));
		 h.selectAnswerOption("Q122", data.get(h.Q114)); 
		 h.selectAnswerOption("Q123", data.get(h.Q115));
		 h.selectAnswerOption("Q124", data.get(h.Q116));
		 h.selectAnswerOption("Q125", data.get(h.Q117));
		 h.selectAnswerOption("Q127", data.get(h.Q118));
		 h.selectAnswerOption("Q128", data.get(h.Q119));
		 h.selectAnswerOption("Q129", data.get(h.Q120));
		 h.selectAnswerOption("Q130", data.get(h.Q121));
		 h.selectAnswerOption("Q131", data.get(h.Q122));
		 
		 h.selectAnswerOption("Q132", data.get(h.Q123));
		 h.selectAnswerOption("Q133", data.get(h.Q124));
		 h.selectAnswerOption("Q134", data.get(h.Q125));
		 h.selectAnswerOption("Q135", data.get(h.Q126));
		 h.selectAnswerOption("Q136", data.get(h.Q127));
		 h.selectAnswerOption("Q137", data.get(h.Q128));
		 h.selectAnswerOption("Q138", data.get(h.Q129));
		 h.selectAnswerOption("Q139", data.get(h.Q130));
		 h.selectAnswerOption("Q140", data.get(h.Q131));
		 
		 h.selectAnswerOption("Q141", data.get(h.Q132));
		 h.selectAnswerOption("Q142", data.get(h.Q133));
		 h.selectAnswerOption("Q143", data.get(h.Q134));
		 h.selectAnswerOption("Q144", data.get(h.Q135));
		 h.selectAnswerOption("Q145", data.get(h.Q136));
		 h.selectAnswerOption("Q146", data.get(h.Q137));
		 h.selectAnswerOption("Q147", data.get(h.Q138));
		 h.selectAnswerOption("Q148", data.get(h.Q139));
		 h.selectAnswerOption("Q149", data.get(h.Q140));
		 h.selectAnswerOption("Q150", data.get(h.Q141));
		 
		 h.selectAnswerOption("Q151", data.get(h.Q142));
		 h.selectAnswerOption("Q152", data.get(h.Q143));
		 h.selectAnswerOption("Q153", data.get(h.Q144));
		 h.selectAnswerOption("Q154", data.get(h.Q145));
		 h.selectAnswerOption("Q155", data.get(h.Q146));
		 h.selectAnswerOption("Q156", data.get(h.Q147));
		 h.selectAnswerOption("Q157", data.get(h.Q148));
		 h.selectAnswerOption("Q158", data.get(h.Q149));
		 h.selectAnswerOption("Q159", data.get(h.Q150));
		 h.selectAnswerOption("Q160", data.get(h.Q151));
		 
		 h.selectAnswerOption("Q161", data.get(h.Q152));
		 h.selectAnswerOption("Q162", data.get(h.Q153));
		 h.selectAnswerOption("Q163", data.get(h.Q154));
		 h.selectAnswerOption("Q164", data.get(h.Q155));
		 h.selectAnswerOption("Q165", data.get(h.Q156));
		 h.selectAnswerOption("Q166", data.get(h.Q157));
		 h.selectAnswerOption("Q167", data.get(h.Q158));
		 h.selectAnswerOption("Q168", data.get(h.Q159));
		 h.selectAnswerOption("Q169", data.get(h.Q160));
		 h.clickNext();
		 
		 
		 h.selectAnswerOption("Q171", data.get(h.Q161));
		 h.selectAnswerOption("Q172", data.get(h.Q162));
		 h.selectAnswerOption("Q173", data.get(h.Q163));
		 h.selectAnswerOption("Q174", data.get(h.Q164));
		 h.selectAnswerOption("Q175", data.get(h.Q165));
		 h.selectAnswerOption("Q177", data.get(h.Q166));
		 h.selectAnswerOption("Q178", data.get(h.Q167));
		 h.selectAnswerOption("Q179", data.get(h.Q168));
		 h.selectAnswerOption("Q180", data.get(h.Q169));
		 h.selectAnswerOption("Q181", data.get(h.Q170));
		 h.selectAnswerOption("Q182", data.get(h.Q171));
		 h.clickNext();
		 
		 h.selectAnswerOption("Q204", data.get(h.Q172));
		 h.selectAnswerOption("Q205", data.get(h.Q173));
		 h.selectAnswerOption("Q209", data.get(h.Q174));
		 h.selectAnswerOption("Q213", data.get(h.Q175));
		 h.selectAnswerOption("Q214", data.get(h.Q176));
		 h.selectAnswerOption("Q215", data.get(h.Q177));
		 h.selectAnswerOption("Q216", data.get(h.Q178));
		 h.selectAnswerOption("Q217", data.get(h.Q179));
		 h.selectAnswerOption("Q218", data.get(h.Q180));
		 h.selectAnswerOption("Q219", data.get(h.Q181));
		 h.clickNext();
		 
		 
		 h.selectAnswerOption("Q220", data.get(h.Q182));
		 h.selectAnswerOption("Q222", data.get(h.Q183));
		 h.selectAnswerOption("Q223", data.get(h.Q184));
		 h.selectAnswerOption("Q224", data.get(h.Q185));
		 h.selectAnswerOption("Q225", data.get(h.Q186));
		 h.selectAnswerOption("Q226", data.get(h.Q187));
		 h.selectAnswerOption("Q227", data.get(h.Q188));
		 h.selectAnswerOption("Q228", data.get(h.Q189));
		 h.selectAnswerOption("Q229", data.get(h.Q190));
		 h.clickNext();
		 
		 h.selectAnswerOption("Q230", data.get(h.Q191));
		 h.selectAnswerOption("Q231", data.get(h.Q192));
		 h.selectAnswerOption("Q233", data.get(h.Q193));
		 h.selectAnswerOption("Q279", data.get(h.Q194));
		 h.clickNext();
		 
		 h.selectAnswerOption("Q236", data.get(h.Q195));
		 h.selectAnswerOption("Q237", data.get(h.Q196));
		 h.selectAnswerOption("Q239", data.get(h.Q197));
		 h.selectAnswerOption("Q240", data.get(h.Q198));
		 h.selectAnswerOption("Q241", data.get(h.Q199));
		 h.clickNext();
		 
		 
		 h.selectAnswerOption("Q242", data.get(h.Q200));
		 h.selectAnswerOption("Q244", data.get(h.Q201));
		 h.selectAnswerOption("Q245", data.get(h.Q202));
		 h.selectAnswerOption("Q246", data.get(h.Q203));
		 h.selectAnswerOption("Q247", data.get(h.Q204));
		 h.selectAnswerOption("Q248", data.get(h.Q205));
		 h.selectAnswerOption("Q250", data.get(h.Q206));
		 h.selectAnswerOption("Q251", data.get(h.Q207));
		 
		 h.selectAnswerOption("Q252", data.get(h.Q208));
		 h.selectAnswerOption("Q253", data.get(h.Q209));
		 h.selectAnswerOption("Q254", data.get(h.Q210));
		 h.selectAnswerOption("Q255", data.get(h.Q211));
		 h.selectAnswerOption("Q256", data.get(h.Q212));
		 h.selectAnswerOption("Q257", data.get(h.Q213));
		 h.selectAnswerOption("Q258", data.get(h.Q214));
		 h.selectAnswerOption("Q259", data.get(h.Q215));
		 h.selectAnswerOption("Q260", data.get(h.Q216));
		 h.selectAnswerOption("Q261", data.get(h.Q217));
		 h.selectAnswerOption("Q262", data.get(h.Q218));
		 
		 h.selectAnswerOption("Q263", data.get(h.Q219));
		 h.selectAnswerOption("Q264", data.get(h.Q220));
		 h.selectAnswerOption("Q265", data.get(h.Q221));
		 h.selectAnswerOption("Q266", data.get(h.Q232));
		 h.selectAnswerOption("Q267", data.get(h.Q223));
		 h.selectAnswerOption("Q268", data.get(h.Q224));
		 h.selectAnswerOption("Q269", data.get(h.Q225));
		 h.selectAnswerOption("Q270", data.get(h.Q226));
		 h.selectAnswerOption("Q271", data.get(h.Q227));
		 h.selectAnswerOption("Q272", data.get(h.Q228));
		 h.selectAnswerOption("Q273", data.get(h.Q229));
		 h.selectAnswerOption("Q274", data.get(h.Q230));
		 h.selectAnswerOption("Q275", data.get(h.Q231));
		 h.selectAnswerOption("Q276", data.get(h.Q232));
		 
		 h.clickOnFinish();
		 Thread.sleep(2000);
		 h.checkConsent();
		 Thread.sleep(2000);
		MyWellnessReportPage r= h.clickConfirm();
		Thread.sleep(2000);
		CreateMyWellnessPlanPage wp =r.goToCreateMyWellnessPlan();
		wp.clickOnAlcoholConsumpton();
		String actual =	wp.getRiskStatus("Alcohol Consumption");
		
		if(!actual.equalsIgnoreCase(data.get("Expected"))){
			
			reportFailure("Risk status should be "+data.get("Expected")+" instead of "+actual);
		}
		 
		 
		
		
		
		
	}
	
	
}

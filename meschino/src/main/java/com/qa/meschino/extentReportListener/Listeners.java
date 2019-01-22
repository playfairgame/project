package com.qa.meschino.extentReportListener;

import java.util.Set;

import org.apache.commons.mail.EmailException;
import org.testng.IClass;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;
import com.qa.meschino.testcases.basetest.BaseTest;
import com.qa.meschino.utils.DataUtils;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends BaseTest implements ITestResult, ITestListener, IExecutionListener {  

//extends TestListenerAdapter{

	public static String getMethodName(ITestResult result){
		
		return result.getMethod().getConstructorOrMethod().getName();
		
		
	}
	

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		/*
		try {
			DataUtils.email(MWConstants.emailID, MWConstants.password);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	public void onExecutionStart() {
		// TODO Auto-generated method stub
	//	logger = extent.createTest("ABC");
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		if(extent!=null)
			extent.flush();
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		//logger = extent.createTest(result.getm)
		//logger = extent.startTest(arg0.getSuite().getName());
		//logger.log(LogStatus.INFO, "Starting suite");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		//logger.log(Status.INFO, result.getMethod().getConstructorOrMethod().getName()+" Test case started");
	
		}

	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public int compareTo(ITestResult arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void onTestFailure(ITestResult it) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult it) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult it) {
		// TODO Auto-generated method stub
		
	}

		
	
	public long getEndMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInstanceName() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITestNGMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}


	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setParameters(Object[] parameters) {
		// TODO Auto-generated method stub
		
	}


	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}


	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setThrowable(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}


	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setEndMillis(long millis) {
		// TODO Auto-generated method stub
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}


	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}
/////////////////////////////////////////////////////////////////


	
	

}

package com.qa.meschino.extentReportListener;

import java.util.Set;

import org.testng.IClass;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.qa.meschino.basepages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends BasePage implements ITestResult, ITestListener, IExecutionListener {  

//extends TestListenerAdapter{

	
	

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		
		sendemail();
		
	}

	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
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

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setEndMillis(long arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setParameters(Object[] arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setThrowable(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}
}
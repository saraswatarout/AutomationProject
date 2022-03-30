package com.vtiger.Genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



/**
 * This class contains implementation for ITestListener interface of TestNG
 * @author saraswata
 */

public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---> start");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---> execution successful");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---> execution failed");
		System.out.println(result.getThrowable());
		
		try {
			String path=new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---> skipped");
		System.out.println(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution finished");
		
	}
	
	
	

}

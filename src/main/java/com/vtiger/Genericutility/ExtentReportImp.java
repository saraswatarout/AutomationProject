package com.vtiger.Genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener {
	ExtentTest test;
	ExtentReports report;

	public void onTestStart(ITestResult result) {
		// step 3 create a test method during the test execution starts
		test=report.createTest(result.getMethod().getMethodName());
		}

	public void onTestSuccess(ITestResult result) {
		// step 4 log the pass method
		test.log(Status.PASS,result.getMethod().getMethodName());
		
		}

	public void onTestFailure(ITestResult result) {
		// step 6 fail method,take screenshot,attach screenshot to extent report
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		String path=null;
		WebDriverUtility wUti=new WebDriverUtility();
		try {
			path=wUti.takeScreenshot(BaseClass.sDriver,result.getMethod().getMethodName());
			} catch(Throwable e) {
				
			}
		}

	public void onTestSkipped(ITestResult result) {
		// step 5 log the skip method(test case name and exception logs
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

     public void onStart(ITestContext context) {
		//step 1 Extent report configuration
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./extentReporter"+new JavaUtility().getSystemDateAndTime());
		htmlReporter.config().setReportName("Regression execution report");
		htmlReporter.config().setDocumentTitle("Comcast automation execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		//step 2 attach the physical report and do the system configuration
		report= new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Enviroment", "Testing enviroment");
		report.setSystemInfo("URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name", "saraswata");
		
	}
   
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
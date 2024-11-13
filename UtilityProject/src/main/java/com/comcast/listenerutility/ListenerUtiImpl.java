package com.comcast.listenerutility;

import java.io.File;
//import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.webdriverutility.UtilityClassObject;

public class ListenerUtiImpl implements ITestListener , ISuiteListener {
	ExtentReports report ;
	public static ExtentTest test ;
	
	@Override
	public void onStart(ISuite suite) {
		String d = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./reporter/report"+d+".html");
		spark.config().setDocumentTitle("CRM TestSuit") ;
		spark.config().setReportName("CEM REport");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName + " started");
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + " started");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		//		ITestListener.super.onTestFailure(result);
		String testName = result.getMethod().getMethodName();

		//		BaseClass.edriver ;
		TakesScreenshot ts = (TakesScreenshot)BaseClass.edriver ;
		String d = new Date().toString().replace(" ", "_").replace(":", "_");

		String f = ts.getScreenshotAs(OutputType.BASE64);
		//		File dest = new File("./screenshots/"+testName+" "+d+".png");
//		File dest = new File("./screenshots/"+testName+d+".png");
		
		test.addScreenCaptureFromBase64String(f);







	}
}

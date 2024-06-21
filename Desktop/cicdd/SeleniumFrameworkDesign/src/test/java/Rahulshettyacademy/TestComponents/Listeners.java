package Rahulshettyacademy.TestComponents;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Rahulshettyacademy.data.ExtentReport;

public class Listeners extends BaseTest  implements ITestListener {
	
	
	ExtentReports extent=ExtentReport.getReport();
	ExtentTest test;
    ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{      
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	public void onTestFailure(ITestResult result)
	{
		
		extentTest.get().fail(result.getThrowable());
		
		
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		
		
		String filepath=null;
		
		try {
			filepath=getScreenshot(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		extentTest.get().log(Status.SKIP, "Test is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
		
	}

	public void onStart(ITestContext context)
	{
		
	
	}

	public void onFinish(ITestContext context) 
	{
		
		extent.flush();
	}
	
	
	

}

package Rahulshettyacademy.data;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReport {
	
	public static ExtentReports getReport()
	{
		
		String path=System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Automation Test Report");
		report.config().setDocumentTitle("Test Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "sandeep");
		return extent;
		
		
		
		
		
		
	}

}

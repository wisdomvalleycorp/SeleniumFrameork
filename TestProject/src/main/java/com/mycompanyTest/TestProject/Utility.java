package com.mycompanyTest.TestProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility {
	
	public static ExtentReports report = new ExtentReports();
	
	
	public ExtentReports getReport(){
		
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("extentreport.html");
		report.attachReporter(htmlReport);
		return report;
	}

}

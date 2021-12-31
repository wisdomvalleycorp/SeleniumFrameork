package com.mycompany.SeleniumProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Utility {
	
	public static Properties prop;
	public static FileInputStream fis;
	public static ExtentReports extReports = new ExtentReports();
	String projectPath = System.getProperty("user.dir");
	
	public FileInputStream getFile() throws FileNotFoundException{
		fis = new FileInputStream(projectPath+"\\resourses\\facebook.xlsx");
		return fis;
	}

	public Properties getProperty() throws IOException{
		
		prop = new Properties();
		fis = new FileInputStream(projectPath+"\\resourses\\config.properties");
		prop.load(fis);
		return prop;
	}
	
	public ExtentReports getExtentReports(){
		ExtentHtmlReporter html = new ExtentHtmlReporter("extentreport.html");
		extReports.attachReporter(html);
		return extReports;
	}
}


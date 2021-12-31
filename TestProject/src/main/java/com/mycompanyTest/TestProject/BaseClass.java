package com.mycompanyTest.TestProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	FileInputStream file;
	
	public static WebDriver init(){
		projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
	}
	
	public FileInputStream getFile() throws FileNotFoundException{
		
		file = new FileInputStream(projectPath+"\\testdata\\facebook.xlsx");
		return file;
	}
	
	public Properties getProperties() throws IOException, FileNotFoundException{
		
		file = new FileInputStream(projectPath+"\\resourses\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop;
	}

}

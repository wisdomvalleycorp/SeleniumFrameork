package com.mycompany.SeleniumProject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mycompany.SeleniumProject.pom.SignInPage;

/**
 * Unit test for simple App.
 */
public class AppTest extends App
{
	/**
	 * Create the test case
	 *
	 */
	WebDriver driver;
	ExtentTest etest;
	Utility getObj = new Utility();

	@BeforeSuite
	public void setup(){
		driver = init();
		etest = getObj.getExtentReports().createTest("facebook test");
	}


	@Test
	public void test1() throws IOException{
		SignInPage sp = new SignInPage(driver);
		driver.get("https://www.facebook.com/");
		String username = getObj.getProperty().getProperty("username");
		sp.getUsername().sendKeys(username);
		etest.pass("Test1 in extent");
	}

	@Test
	public void test2() throws EncryptedDocumentException, FileNotFoundException, IOException{
		SignInPage sp = new SignInPage(driver);
		driver.get("https://www.facebook.com/");
		String username = getObj.getProperty().getProperty("username");
		//String pass = WorkbookFactory.create(getObj.getFile()).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		sp.getPassword().sendKeys(username);
		getObj.getExtentReports().createTest("new test").fail("failed password");
	}

	

	@AfterSuite
	public void tearDown(){
		getObj.getExtentReports().flush();
		driver.quit();
	} 

}

package com.mycompanyTest.TestProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.mycompanyTest.TestProject.pom.Login;
import com.mycompanyTest.TestProject.pom.SignUp;

//class name to which ITestListener is implemented
@Listeners(listner.Listners.class)
public class FacebookTest extends BaseClass {
	
	WebDriver driver;
	static FileInputStream fis;
	Properties prop;
	Utility utl = new Utility();
	ExtentTest test;
	Sheet sh;
	
	@BeforeSuite
	public void setUp(){
		driver = init();
		
		try {
			
			fis = getFile();
			prop = getProperties();
			test = utl.getReport().createTest("Login Test");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test(dataProvider = "LoginData",groups = {"sanity"})
	public void test_login(String userName, String pass) throws Exception{
		Login loginObj = new Login(driver);
		driver.get("https://facebook.com");
		Thread.sleep(1000);
		sh = WorkbookFactory.create(fis).getSheet("Sheet1");
		String username = sh.getRow(0).getCell(0).getStringCellValue();
		loginObj.getUsername().sendKeys(userName);
		test.pass("Entered username ");
		Thread.sleep(1000);
		String password = sh.getRow(0).getCell(1).getStringCellValue();
		loginObj.getPassword().sendKeys(pass);
		test.pass("Entered password");
		Thread.sleep(1000);
		loginObj.getLoginButton().click();
		test.pass("Cliked on Login button");
	}
	
	@DataProvider(name="LoginData")
	public Object[][] loginData(){
		//String[][] str ={ {"dsfsd","dfsd"} };
		return new Object[][] {{"asd@gmail.com","pass1@123"},{"sdf@gmail.com", "pass2@123"},{"ret@gmail.com", "pass3@123"}};
	}
	
	@Test(enabled = false)
	public void test_signup() throws Exception {
		
		SignUp signupObj=new SignUp(driver);
		
		driver.get("https://www.facebook.com/reg/");
		Thread.sleep(5000);
		
		String fname = prop.getProperty("firstname");
		signupObj.getFirstname().sendKeys(fname);
		Thread.sleep(3000);
		
		String lname = prop.getProperty("surname");
		signupObj.getSurname().sendKeys(lname);
		Thread.sleep(3000);
		
		String mobno = prop.getProperty("mobileno");
		signupObj.getMobileNo().sendKeys(mobno);
		Thread.sleep(3000);
		
		String pass = prop.getProperty("password");
		signupObj.getNewPassword().sendKeys(pass);
		Thread.sleep(2000);
		
		String day = prop.getProperty("day");
		signupObj.getDay().sendKeys(day);
		Thread.sleep(3000);
		
		String month = prop.getProperty("month");
		signupObj.getMonth().sendKeys(month);
		Thread.sleep(3000);
		
		String year = prop.getProperty("year");
		signupObj.getYear().sendKeys(year);
		Thread.sleep(3000);
		
		signupObj.getFemale().click();
		Thread.sleep(3000);
		
		signupObj.getSignup().click();
		Thread.sleep(3000);
		
	}
	@Test(groups = {"smoke"})
	public void test5(){
		System.out.println("in test 5");
	}
	
	/*@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException{
		if(ITestResult.FAILURE == result.getStatus()){
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(projectPath+"\\failedtest-screenshot\\"+result.getName()+".png"));
		}
	}*/
	
	@AfterSuite
	public void tearDown(){
		utl.getReport().flush();
		driver.quit();
	}

}

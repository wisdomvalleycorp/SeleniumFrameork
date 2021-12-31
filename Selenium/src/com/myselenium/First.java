package com.myselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First {
	
	static{
	}
	
	private static void test(String num){
		final String num1 = "";
	}
	private void test(int num){}
	
	public static void main(String[]args) throws InterruptedException, EncryptedDocumentException, IOException
	
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/shrey/Desktop/login.html");
		//TakesScreenshot interface contains getScreenshotAs method
		//OutputType is also a interface
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
            FileUtils.copyFile(s, new File("F:\\selenium\\login.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
		driver.findElement(By.id("alertButton")).click();
		
	    Alert simpleAlert = driver.switchTo().alert();
	    
	    Thread.sleep(5000);
	    simpleAlert.accept();
		
	    driver.findElement(By.id("confirmButton")).click();
	    
	    Alert confirmAlert = driver.switchTo().alert();
	    
	    Thread.sleep(5000);
	    confirmAlert.accept();
	    
	    driver.findElement(By.id("promptButton")).click();
	    
Alert promptAlert = driver.switchTo().alert();
driver.switchTo().alert().sendKeys("hello tester");
	    
	    Thread.sleep(5000);
	    promptAlert.accept();
		
		
		WebElement city = driver.findElement(By.id("city"));
		
		boolean val = driver.findElement(By.id("city")).isEnabled();
		if(val){
			Select cityDropDown = new Select(city);
			//Thread.sleep(5000);
			cityDropDown.selectByVisibleText("Jodhpur");
		}
		else{
			
		}
		//Thread.sleep(5000);
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("check1")).click();
		
		boolean flag = driver.findElement(By.id("male")).isSelected();
		if(flag){
			
		}
		else{
			
		}
		boolean check = driver.findElement(By.id("check1")).isSelected();
		
		
		FileInputStream file = new FileInputStream("F:\\selenium\\facebook.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String userName = sh.getRow(0).getCell(0).getStringCellValue();
		
		driver.findElement(By.id("")).sendKeys(userName);
		
		int rowCount = sh.getLastRowNum();
		
		for(int i=0;i<rowCount;i++){
			
			int cellCount = sh.getRow(i).getLastCellNum();
			
			for(int j=0; j<cellCount;j++){
				
				Cell ce = sh.getRow(i).getCell(j);
				
				System.out.println("Cell Type "+ce.getCellType().name());
				
				switch(ce.getCellType()){
				case STRING:
					driver.findElement(By.id("")).sendKeys(sh.getRow(i).getCell(j).getStringCellValue());				
					break;
				case NUMERIC:
					System.out.println(sh.getRow(i).getCell(j).getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(sh.getRow(i).getCell(j).getBooleanCellValue());
					break;
				
				default:
					System.out.println(sh.getRow(i).getCell(j).getNumericCellValue());
					break;
				}
				
			}
		}
	}
}

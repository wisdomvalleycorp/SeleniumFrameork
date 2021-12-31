package com.myselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement ele = driver.findElement(By.name("btnK"));
		
		List<WebElement> allInputs = driver.findElements(By.xpath("//input"));
		
		 ele.sendKeys(Keys.ENTER);
		 wait.until(ExpectedConditions.visibilityOfAllElements(allInputs));
		
		driver.findElement(By.id("dfbdshfb")).click();
	}

}

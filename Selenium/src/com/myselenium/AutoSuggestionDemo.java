package com.myselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AutoSuggestionDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		
		Thread.sleep(5000);
		
		/*List<WebElement> listEle = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li"));
		
		int listSize = listEle.size();
		
		WebElement li = listEle.get(4);
		
		li.click();*/
		
		driver.findElement(By.xpath("(//input[contains(@name,'btn')])[1]")).sendKeys(Keys.CONTROL, Keys.ENTER);
		
	}

}

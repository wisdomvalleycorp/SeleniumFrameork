package com.myselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWebElement {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		
		
		driver.findElement(By.xpath("//input[@value='Subscribe']")).click();
		
		Thread.sleep(5000);
		
		Set<String> win = driver.getWindowHandles();
		
		int size = win.size();
		
		
		System.out.println(size);
		
		Iterator<String> itr = win.iterator(); 
		
		String	winId = itr.next(); //1
		
		String	winId1 = itr.next(); // 2
		
		/*int i =0;
		String[] str = {};
		while(itr.hasNext()){
			 str[i] = itr.next();
			i++;
		}*/
 		
		
		Thread.sleep(5000);
		
		driver.switchTo().window(winId1);
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().fullscreen();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc");
		
		driver.switchTo().window(winId1).close();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		
	}

}

package com.myselenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/shrey/Desktop/iframe.html");
	    driver.manage().window().maximize();
	    driver.switchTo().frame(0);
	    Thread.sleep(5000);
	    driver.findElement(By.id("hamburger-menu")).click();
	    Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    Thread.sleep(5000);
	    driver.switchTo().frame(1);
	    driver.findElement(By.xpath("//h5[text()='Elements']")).click();
	}

}

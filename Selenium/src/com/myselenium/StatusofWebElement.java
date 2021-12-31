package com.myselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusofWebElement {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(5000);
		
		WebElement search = driver.findElement(By.xpath("//input[@name='firstname']"));
		
		System.out.println("Display Status:" + search.isDisplayed());
		
		System.out.println("Enable Status:" + search.isEnabled());
		
		driver.findElement(By.xpath("//input[@name='sex']")).click();
		boolean flag = driver.findElement(By.xpath("//input[@name='sex']")).isSelected();
		if(flag) {
			System.out.println("selected");
		}
		else {
			System.out.println("not selected");
		}
		
		
		
		
	}
}

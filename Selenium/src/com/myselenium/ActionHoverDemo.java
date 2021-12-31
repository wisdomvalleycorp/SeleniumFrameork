package com.myselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionHoverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.onlineservices.nsdl.com/paam/endUserRegisterContact.html");
		
		Actions act = new Actions(driver);
		
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),' Registered User')]"));
		
		act.moveToElement(link).build().perform();
		
		act.contextClick(link).build().perform();
		
		act.doubleClick(link).build().perform();
		

	}

}

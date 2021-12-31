package com.myselenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionClassDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.onlineservices.nsdl.com/paam/endUserRegisterContact.html");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, new File("F:\\selenium\\xyz.png"));*/
		
		Actions act = new Actions(driver);
		
		
		
		Integer num = new Integer(10);
		
		
		/*Set<String> win = driver.getWindowHandles();
		
		int size = win.size();
		String winId = null ;
		
		System.out.println(size);
		
		Iterator<String> itr = win.iterator();
		if(itr.hasNext()){
			winId = itr.next();
 		}
		
		driver.switchTo().window(winId);*/
		
		WebElement sel = driver.findElement(By.xpath("//span[@id='select2-type-container']"));
		
		act.click(sel).build().perform();
		Thread.sleep(5000);
		
		act.click(driver.findElement(By.xpath("(//li)[3]"))).build().perform();
		
		Thread.sleep(5000);
		
		act.click(driver.findElement(By.xpath("//input[@id='date_of_birth_reg']"))).build().perform();
		
		Thread.sleep(5000);
		
		WebElement dateSel = driver.findElement(By.className("monthselect"));
		
		WebElement yearSel = driver.findElement(By.xpath("(//select[contains(@class,'yearselect')])[1]"));
		
		Select datesel = new Select(dateSel);
		
		Thread.sleep(5000);
		Select yearsel = new Select(yearSel);
	//	Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//th[contains(@class,'prev')]")).click();
		//datesel.selectByValue("0");
		
		yearsel.selectByValue("2005");
		
		driver.findElement(By.xpath("(//td[contains(text(),'30')])[1]")).click();
		
		
		
		
		
	}

}

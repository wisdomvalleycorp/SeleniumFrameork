package com.mycompanyTest.TestProject.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
	public SignUp(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement surname;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement mobileNo;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	private WebElement newPassword;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy(xpath="//label[text()='Female']")
	private WebElement female;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement male;
	
	@FindBy(xpath="//label[text()='Custom']")
	private WebElement custom;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement signUpButton;
	
	public WebElement getFirstname() {
		return firstname;
	}
	
	public WebElement getSurname() {
		return surname;
	}
	public WebElement getMobileNo() {
		return mobileNo;
	}
	public WebElement getNewPassword() {
		return newPassword ;
	}
	public WebElement getDay() {
		return day;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getFemale() {
		return female;
	}
	public WebElement getMale() {
		return male;
	}
	public WebElement getCustom() {
		return custom;
	}
	public WebElement getSignup() {
		return signUpButton;
	}
}

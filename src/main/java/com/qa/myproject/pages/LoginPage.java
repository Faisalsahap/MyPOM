package com.qa.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

/**
 * Every page must have its own private driver
 * 
 */
	private WebDriver driver;

	
//  Do not make the locators accessible for everyone. Make it private.
//	1. Private By locator
//	private By emailid = By.id("input-email");
//	private By password = By.id("input-password");
//	private By loginBtn = By.xpath("//input[@class='btn btn-primary']");
//	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By submitBtn = By.id("submitbtn");

	
//	Avoid unwanted inheritance.
//	2. Constructor
	public LoginPage(WebDriver driver) {
//		driver = driver1;
		this.driver = driver;
	}
	
	
/**
 * pages don't have an assertions. Test should assert (TestNG responsibility)
 * Do not violate the POM rule of SRP. 
 */
	
// 3. Page Actions:
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("URL is: " + url);
		return url;
	}

//	public boolean isForgotPwdLinkExist() {
//		return driver.findElement(forgotPwdLink).isDisplayed();
//
//	}

	public void doLogin(String un, String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitBtn).click();
	}

}

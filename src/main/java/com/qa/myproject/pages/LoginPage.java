package com.qa.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

//	1. Private By locator
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

//	2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

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

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();

	}

	public void doLogin(String un, String pwd) {
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}

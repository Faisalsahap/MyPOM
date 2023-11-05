package com.qa.myproject.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.myproject.constants.AppConstants;
import com.qa.myproject.utils.ElementUtil;

public class LoginPage {

/**
 * Every page must have its own private driver
 * 
 */
	private WebDriver driver;
	private ElementUtil eleUtil;

	
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
		this.driver = driver; //SID 123 > driver reference (SID 123) > eleUtil driver (SID 123)
		eleUtil = new ElementUtil(driver); //constructor on ElementUtil & SID 123
		
	}
	
	
/**
 * pages don't have an assertions. Test should assert (TestNG responsibility)
 * Do not violate the POM rule of SRP. 
 */
	
// 3. Page Actions:
	public String getLoginPageTitle() {
//		String title = driver.getTitle();
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Title is: " + title);
		return title;
	}

	public String getLoginPageURL() {
//		String url = driver.getCurrentUrl();
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("URL is: " + url);
		return url; //return is for manipulation
	}

//	public boolean isForgotPwdLinkExist() {
//		return driver.findElement(forgotPwdLink).isDisplayed();
//
//	}

	
	/**
	 * After clicking button/link, if we're landing on a new page, 
	 * it's a method responsibility to return the next landing page class object(Home Page)
	 * Mouse over to create a landing page (Test Driven Development - TDD Approach)(Page chaining model)
	 * @param un
	 * @param pwd
	 * Introducing Util classes
	 */
	public UserProfilePage doLogin(String un, String pwd) {
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(submitBtn).click();
		
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);//for pwd we no need to wait
		eleUtil.doClick(submitBtn);
		eleUtil.waitForElementVisible(submitBtn, AppConstants.DEFAULT_MEDIUM_TIME_OUT);//Login page > Next landing page problem
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Login page > Next landing page problem
		return new UserProfilePage(driver);
	}

}

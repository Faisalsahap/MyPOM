package com.qa.myproject.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.myproject.factory.DriverFactory;
import com.qa.myproject.pages.LoginPage;
import com.qa.myproject.pages.UserProfilePage;

public class BaseTest {
	
	/**
	 * Initialize the driver, pages with reference
	 * Create objects here only(not in test class)
	 * Access modifier -> protected (same/diff. package, child classes). We can use public too (avail for all)
	 * initDriver returns driver, so created the WebDriver reference to store it.
	 * Iniialized the driver at class level, so we can use it inside.(tearDown)
	 */
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected UserProfilePage userProfilePage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver("chrome");
		loginPage = new LoginPage(driver);
//		loginPage.doLogin("faisal", "Mf$9788241519"); //We have to first login to land user profile page. 
//											   //But it will disturb loginPageTest (already logged in) 

	}

	/**
	 * Session ID never going to be NULL here.
	 * AfterTest > BeforeTest > initDriver(DriverFactory)(SID: 123) > chromeDriver(SID: 123) > return driver(SID: 123) 
	 * > BeforeTest(holding parameter)(SID: 123) > class variable(SID: 123) > AfterTest(driver.quit)(SID: 123) 
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}

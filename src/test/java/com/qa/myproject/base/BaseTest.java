package com.qa.myproject.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.myproject.factory.DriverFactory;
import com.qa.myproject.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver("chrome");
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}

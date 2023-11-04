package com.qa.myproject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

/**
 * Always prefer the cross-bowser logic to initialize the driver
 */
	public WebDriver driver;

	public WebDriver initDriver(String browserName) {
		System.out.println("browser name: " + browserName);

		if (browserName.trim().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.trim().equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please pass the right browser: " + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://yaabitech.com/user/login?logred=");
		return driver;

	}

}

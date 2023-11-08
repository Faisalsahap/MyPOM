package com.qa.myproject.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

/**
 * Always prefer the cross-bowser logic to initialize the driver
 * this method initializing the driver on the basis of given browser name 
 * @param browserName
 * @return this returns the driver
 */
	public WebDriver driver;
	public Properties prop; 

//	public WebDriver initDriver(String browserName) {
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").toLowerCase().trim(); //All the prop keys are strings
		System.out.println("browser name: " + browserName);

//		if (browserName.trim().equalsIgnoreCase("chrome")) {
			if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

//		else if (browserName.trim().equalsIgnoreCase("firefox")) {
			else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

//		else if (browserName.trim().equalsIgnoreCase("safari")) {
			else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please pass the right browser: " + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		driver.get("https://yaabitech.com/user/login?logred=");
		driver.get(prop.getProperty("url"));
		return driver;

	}
	
	/**
	 * FileInputStream to read non-java files 
	 * ./src => ./ means project directory
	 * Handle the exception in method level (Not in user method main())
	 * this method reading the properties from the .properties file
	 */

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
}

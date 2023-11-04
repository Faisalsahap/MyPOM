package com.qa.myproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePage {
	
	private WebDriver driver;
	
	
	private By LogoutLink = By.linkText("Logout");
	private By EditLinks = By.cssSelector("a[class='btn-small grey lighten-3 red-text text-darken-2']");
	private By JoinWithUs = By.xpath("/html/body/footer/div[1]/div/div[3]/h5");
	
	
	public UserProfilePage(WebDriver driver) {
		this.driver= driver;
	}

	public String getHomePageTitle() {
		String HomePageTitle = driver.getTitle();
		System.out.println(HomePageTitle);
		return HomePageTitle;
	}
	
	public String getHomePageURL() {
		String HomePageURL = driver.getCurrentUrl();
		System.out.println(HomePageURL);
		return HomePageURL;
	}
	
//	Encapsulation -> Accession private locators by public methods
	public boolean isLogoutLinkExist() {
		return driver.findElement(LogoutLink).isDisplayed();
	}
	
	public boolean isJoinWithUsExist() {
		return driver.findElement(JoinWithUs).isDisplayed();
	}
	
	public List<String> getUserProfilePageEditLinksList() {
		List<WebElement> userProfilePageEditLinksList = driver.findElements(EditLinks);
		List<String> userProfilePageEditLinksValueList = new ArrayList<String>();
		for(WebElement e : userProfilePageEditLinksList) {
			String text = e.getText();
			userProfilePageEditLinksValueList.add(text);
		}
			return userProfilePageEditLinksValueList;
	}
	
	
}


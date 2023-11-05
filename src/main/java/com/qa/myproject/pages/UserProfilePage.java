package com.qa.myproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.myproject.constants.AppConstants;
import com.qa.myproject.utils.ElementUtil;

public class UserProfilePage {
	
	/**
	 * Create a ElementUtil object inside constructor, not in class level.
	 * Otherwise WebDriver driver will be called in class level. ElementUtil SID will become NULL.
	 */
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	/**
	 * Both Locators and Page Actions should be defined within the same class(Epitome of encapsulation). Otherwise we have to create 2 classes unnecessarily.
	 * DEFINE A MAINTENABLE LOCATORS
	 * DO NOT WRITE ALL LOCATORS IN ONE CLASS, PROPERTIES FILE, OR EXCEL FILE(EXTERNAL DEPENDANCY).
	 * WE CAN EASILY TRACK AND IDENTIFY IN FUTURE WHERE THE EXCEPTION OCCURS, IF WE DEFINE PAGE CLASS WISE LOCATORS
	 */
	private By LogoutLink = By.linkText("Logout");
	private By EditLinks = By.cssSelector("a[class='btn-small grey lighten-3 red-text text-darken-2']");
	private By JoinWithUs = By.xpath("/html/body/footer/div[1]/div/div[3]/h5");
	
	
	public UserProfilePage(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
//		String HomePageTitle = driver.getTitle();
		String HomePageTitle = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.USER_PROFILE_PAGE_TITLE_VALUE);
		System.out.println(HomePageTitle);
		return HomePageTitle;
	}
	
	public String getHomePageURL() {
//		String HomePageURL = driver.getCurrentUrl();
		String HomePageURL = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.USER_PROFILE_PAGE_URL_FRACTION_VALUE);
		System.out.println(HomePageURL);
		return HomePageURL;
	}
	
//	Encapsulation -> Accession private locators by public methods
	public boolean isLogoutLinkExist() {
//		return driver.findElement(LogoutLink).isDisplayed();
		return eleUtil.waitForElementVisible(LogoutLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public boolean isJoinWithUsExist() {
//		return driver.findElement(JoinWithUs).isDisplayed();
		return eleUtil.waitForElementVisible(JoinWithUs, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();

	}
	
	public List<String> getUserProfilePageEditLinksList() {
		
//		List<WebElement> userProfilePageEditLinksList = driver.findElements(EditLinks);
		List<WebElement> userProfilePageEditLinksList = eleUtil.waitForElementsVisible(EditLinks, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> userProfilePageEditLinksValueList = new ArrayList<String>();
		for(WebElement e : userProfilePageEditLinksList) {
			String text = e.getText();
			userProfilePageEditLinksValueList.add(text);
		}
			return userProfilePageEditLinksValueList;
	}
	
	
}


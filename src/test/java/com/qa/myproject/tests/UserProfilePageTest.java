package com.qa.myproject.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;

public class UserProfilePageTest extends BaseTest {

	/**
	 * We have to first login to land user profile page. But it will disturb loginPageTest(already logged in) 
	 * So use a lower level annotation @BeforeClass. It execute after the @BeforeTest. 
	 * loginPage not pointing to NULL. Bcas object already created
	 * in BaseTest having driver SID 123 
	 * loginPage referred by the homePage reference. Created in BaseTest(for reuse), inherited and used here. 
	 * DO NOT CREATE OBJECT FOR EVERY METHOD
	 */

	@BeforeClass
	public void userProfilePageSetup() {
		userProfilePage = loginPage.doLogin("faisal", "Mf$9788241519");
	}

	@Test
	public void userProfilePageTitleTest() {
		String actTitle = userProfilePage.getHomePageTitle();
		Assert.assertEquals(actTitle, "faisal user profile");
	}

	@Test
	public void userProfilePageURLTest() {
		String actURL = userProfilePage.getHomePageURL();
		Assert.assertTrue(actURL.contains("/user/profile"));
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(userProfilePage.isLogoutLinkExist());
	}
	
	@Test
	public void homePageHeadersTest() {
		List<String> actualHomeHeaderList = userProfilePage.getUserProfilePageEditLinksList();
		Assert.assertEquals(actualHomeHeaderList.size(), 3);
		
	}
}

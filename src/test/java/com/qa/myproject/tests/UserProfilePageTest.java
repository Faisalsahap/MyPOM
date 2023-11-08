package com.qa.myproject.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;
import com.qa.myproject.constants.AppConstants;

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
		userProfilePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		//protected prop allows us to use the prop in child class

	}

	@Test(priority = 1)
	public void userProfilePageTitleTest() {
		String actTitle = userProfilePage.getHomePageTitle();
		Assert.assertEquals(actTitle,AppConstants.USER_PROFILE_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void userProfilePageURLTest() {
		String actURL = userProfilePage.getHomePageURL();
		Assert.assertTrue(actURL.contains(AppConstants.USER_PROFILE_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test(priority = 3)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(userProfilePage.isLogoutLinkExist());
	}
	
	@Test(priority = 4)
	public void userProfileEditLinksTest() {
		List<String> actualUserEditLinkList = userProfilePage.getUserProfilePageEditLinksList();
//		Assert.assertEquals(actualUserEditLinkList.size(), 3);
		Assert.assertEquals(actualUserEditLinkList.size(), AppConstants.USER_PROFILE_HEADERS_COUNT);
		
	}
	
	@Test(priority = 5)
	public void userProfileEditLinkValueTest() {
		List<String> actualUserEditLinkList = userProfilePage.getUserProfilePageEditLinksList();
		System.out.println("User profile page edit link list: " + actualUserEditLinkList);
//		Assert.assertEquals(actualArrayList, expectedArrayList);
		Assert.assertEquals(actualUserEditLinkList, AppConstants.EXPECTED_USER_PROFILE_HEADERS_LIST);
		
	}
	
}

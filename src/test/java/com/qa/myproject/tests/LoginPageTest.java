package com.qa.myproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;
import com.qa.myproject.constants.AppConstants;


/**
 * Inherit the parent class properties(Base Test).
 * DO NOT CREATE UNNECESSARY OBJECTS IN TEST CLASS. (Not a good practice to create a object for every TC)
 * CREATE THE OBJECTS IN BASE TEST.
 * TESTNG RESPONSIBILITY -> WRITING TEST CASES AND ASSERTIONS.
 * Test should not have any selenium code
 * 
 */
public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void LoginPageTitleTest() {

		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void LoginPageURLTest() {

		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
//	@Test 
//	public void ForgotPwdLinkExistTest() {
//		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
//		
//	}
	
	/**
	 * Can assert only if the method return something.
	 */
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin("faisal", "Mf$9788241519");
	}
}

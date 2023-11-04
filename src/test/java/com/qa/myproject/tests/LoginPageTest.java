package com.qa.myproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;


/**
 * Inherit the parent class properties(Base Test).
 * DO NOT CREATE UNNECESSARY OBJECTS IN TEST CLASS. (Not a good practice to create a object for every TC)
 * CREATE THE OBJECTS IN BASE TEST.
 * TESTNG RESPONSIBILITY -> WRITING TEST CASES AND ASSERTIONS.
 * 
 */
public class LoginPageTest extends BaseTest {

	@Test
	public void LoginPageTitleTest() {

		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Sign in to your Yaabitech account");
	}

	@Test
	public void LoginPageURLTest() {

		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("/user/login?logred"));
	}
	
//	@Test 
//	public void ForgotPwdLinkExistTest() {
//		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
//		
//	}
	
	/**
	 * Can assert only if the method return something.
	 */
	@Test
	public void loginTest() {
		loginPage.doLogin("faisal", "Mf$9788241519");
	}
}

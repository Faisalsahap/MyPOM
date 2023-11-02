package com.qa.myproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void LoginPageTitleTest() {

		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}

	@Test
	public void LoginPageURLTest() {

		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("route=account/login"));
	}
	
	@Test 
	public void ForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}
	
	@Test
	public void loginTest() {
		loginPage.doLogin("mangaleswari86@gmail.com", "Mf$9788241519");
	}
}

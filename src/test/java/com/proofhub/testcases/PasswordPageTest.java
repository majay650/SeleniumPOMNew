package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.TestBase;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;

public class PasswordPageTest extends TestBase {

	UsernamePage usernamePage;
	PasswordPage passwordPage;

	public PasswordPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		usernamePage = new UsernamePage();
		passwordPage = usernamePage.enterUsername(prop.getProperty("username"));
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void verifyLoginButtonOnPasswordPageTest() {
		Assert.assertTrue(passwordPage.validateLoginButton());
	}

	@Test(priority = 2)
	public void verifyBackToLoginLinkTest() {
		Assert.assertTrue(passwordPage.validateBackToLoginLink());
	}
	
	@Test(priority=3)
	public void login() {
		passwordPage.login(prop.getProperty("password"));
	}
	
	
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

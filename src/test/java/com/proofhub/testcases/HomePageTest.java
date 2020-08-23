package com.proofhub.testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.TestBase;
import com.proofhub.pages.HomePage;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;
import com.proofhub.util.TestUtil;

public class HomePageTest extends TestBase{
	UsernamePage usernamePage;
	PasswordPage passwordPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		usernamePage = new UsernamePage();
		passwordPage = usernamePage.enterUsername(prop.getProperty("username"));
		homePage = passwordPage.login(prop.getProperty("password"));
		Thread.sleep(2000);
	}
	
	@Test
	public void validateHomePageAfterLogin() {
		Assert.assertTrue(homePage.validatePlusIconOnHomePage());
	}
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

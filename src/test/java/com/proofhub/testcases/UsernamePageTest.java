package com.proofhub.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.proofhub.base.TestBase;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;

public class UsernamePageTest extends TestBase {

	UsernamePage usernamePage;
	PasswordPage passwordPage;
	WebDriverWait wait;

	public UsernamePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		usernamePage = new UsernamePage();
	}

	@Test(priority=1)
	public void usernamePageTitleTest() throws InterruptedException {
		String title = usernamePage.getUsernamePageTitle();
		Assert.assertEquals(title, "todo12");
	}

	@Test(priority=2)
	public void uiElementsTest() {
		boolean companyName = usernamePage.validateCompanyNameOnUsernamePage();
		Assert.assertTrue(companyName);
		boolean usernameTextfield = usernamePage.validateUsernameTextField();
		Assert.assertTrue(usernameTextfield, "Username textfield is displayed");
		String companyNameText = usernamePage.getCompanyNameText();
		Assert.assertEquals(companyNameText, "todo15");
	}

	@Test(priority=3)
	public void usernamePage() throws InterruptedException {
		passwordPage = usernamePage.enterUsername(prop.getProperty("username11"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

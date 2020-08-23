package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.TestBase;
import com.proofhub.pages.HomePage;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.ProjectsAssignedToMePage;
import com.proofhub.pages.UsernamePage;

public class ProjectsAssignedToMeTest extends TestBase {
	UsernamePage usernamePage;
	PasswordPage passwordPage;
	HomePage homePage;
	ProjectsAssignedToMePage projectsAssignedToMePage;
	
	public ProjectsAssignedToMeTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		usernamePage = new UsernamePage();
		passwordPage = usernamePage.enterUsername(prop.getProperty("username"));
		homePage = passwordPage.login(prop.getProperty("password"));
		Thread.sleep(2000);
	}
	
	
	@Test
	public void validateAssignedToMePageLoadedTest() throws InterruptedException {
		projectsAssignedToMePage = homePage.goToProjects();
		Assert.assertTrue(projectsAssignedToMePage.validateAssignedToMePageLoaded());
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

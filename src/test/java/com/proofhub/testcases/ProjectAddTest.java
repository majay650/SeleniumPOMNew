package com.proofhub.testcases;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.proofhub.base.TestBase;
import com.proofhub.pages.HomePage;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.ProjectAddPage;
import com.proofhub.pages.ProjectsAssignedToMePage;
import com.proofhub.pages.UsernamePage;
import com.proofhub.util.TestUtil;

public class ProjectAddTest extends TestBase{
	UsernamePage usernamePage;
	PasswordPage passwordPage;
	HomePage homePage;
	ProjectsAssignedToMePage projectsAssignedToMePage = new ProjectsAssignedToMePage();
	String sheetName = "Projects";

	public ProjectAddTest() {
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
	
	
	@Test(priority=1)
	public void validateAddProjectScreenOpenedTest() throws InterruptedException {
		ProjectAddPage projectAddPage = new ProjectAddPage() ;
		 projectsAssignedToMePage= homePage.goToProjects();
		projectsAssignedToMePage.goToAddProjectScreen();
		Assert.assertTrue(projectAddPage.verifyAddProjectScreenOpened());
	}
	
	
	@DataProvider
	public Object[][] getProofhubTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getProofhubTestData")
	public void addProjectWithMandatoryFieldsTest(String title) throws InterruptedException {
		ProjectAddPage projectAddPage = new ProjectAddPage() ;
		projectsAssignedToMePage= homePage.goToProjects();
		projectsAssignedToMePage.goToAddProjectScreen();
		projectAddPage.addProjectWithMandatoryFields(title);
		Thread.sleep(10000);

	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

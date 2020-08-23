package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.TestBase;

public class HomePage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@FindBy(xpath="//span[@id='quickAddBtn-btnIconEl']")
	WebElement plusIcon;
	
	@FindBy(xpath="//div[@class='leftMenuItem']//span[@class='icon fas fa-home h-me']")
	WebElement leftPanelMeLink;

	@FindBy(xpath="//div[@class='leftMenuItem']//span[@class='icon fas fa-folder h-projects']")
	WebElement leftPanelProjectsLink;
	
	@FindBy(xpath="//div[@class='leftMenuItem']//span[@class='icon fas fa-globe h-everything']")
	WebElement leftPanelEverythingLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean validatePlusIconOnHomePage() {
//		 wait.until(ExpectedConditions.visibilityOf(plusIcon));
		return plusIcon.isDisplayed();
	}
	
public WebElement getPlusIcon() {
	return plusIcon;
}
	
	public ProjectsAssignedToMePage goToProjects() throws InterruptedException {
		ProjectsAssignedToMePage projectsAssignedToMePage = new ProjectsAssignedToMePage();
		leftPanelProjectsLink.click();
		Actions action = new Actions(driver);
		WebElement we = projectsAssignedToMePage.getAssignedToMeTab();
		action.moveToElement(we).build().perform();

		return new ProjectsAssignedToMePage();
	}
	
}

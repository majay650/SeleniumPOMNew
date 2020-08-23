package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proofhub.base.TestBase;

public class ProjectsAssignedToMePage extends TestBase{

	@FindBy(xpath="//span[text()='Assigned to me']")
	WebElement assignedToMeTab;
	
	@FindBy(xpath="//span[text()='Add']")
	WebElement addButton;
	
	@FindBy(xpath="//span[text()='Project']")
	WebElement addProject;
	
	public ProjectsAssignedToMePage() {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAssignedToMeTab() {
		return assignedToMeTab;
	}
	
public Boolean validateAssignedToMePageLoaded() {
	return assignedToMeTab.isDisplayed();
}

public void goToAddProjectScreen() {
	addButton.click();
	addProject.click();
//	return new ProjectAddPage();
}


}

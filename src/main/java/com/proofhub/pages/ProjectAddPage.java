package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.proofhub.base.TestBase;
import com.proofhub.util.TestUtil;

public class ProjectAddPage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@FindBy(xpath="//input[@name='title']")
	WebElement addProjectTitleTextField;
	
	@FindBy(xpath="//a[@tabindex='10']")
	WebElement addProjectButton;

	@FindBy(xpath="//div[contains(@id,'projectAddEdit') and text()='Add project']")
	WebElement addProjectScreenTitle;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement addProjectTitleTextfield;	
	
	@FindBy(xpath="//a[@tabindex='10']")
	WebElement addProjectAddButton;	
	
	public ProjectAddPage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyAddProjectScreenOpened() {
		return addProjectScreenTitle.isDisplayed();
	}
		
	
	public void addProjectWithMandatoryFields(String title) {
		wait.until(ExpectedConditions.visibilityOf(addProjectTitleTextfield));
		addProjectTitleTextfield.sendKeys(title);
		wait.until(ExpectedConditions.elementToBeClickable(addProjectButton));
		addProjectButton.click();
		
	}
	
	
	
	
}




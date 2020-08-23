package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.TestBase;

public class PasswordPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@FindBy(xpath="//span[text()='LOG IN']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@name='userPassword']")
	WebElement passwordTextfield;
	
	@FindBy(linkText="Back to login")
	WebElement backToLoginLink;
	
	public PasswordPage() {
	PageFactory.initElements(driver, this);
}
	
	//Actions to be performed on password page
	
	public Boolean validateLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		return loginButton.isDisplayed();
	}
	
	public Boolean validateBackToLoginLink() {
		wait.until(ExpectedConditions.visibilityOf(backToLoginLink));
		return backToLoginLink.isDisplayed();
	}
	
	public HomePage login(String password) {
		passwordTextfield.sendKeys(password);
		loginButton.click();
		return new HomePage();
		
	}
	

}

package com.proofhub.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.TestBase;

public class UsernamePage extends TestBase{


	//page factory or elements of username page
	@FindBy(xpath="//input[@name='userNameEmail']")
	WebElement usernameTextField;
	
	@FindBy(xpath="//span[text()='NEXT']")
	WebElement nextButton;
	
	@FindBy(linkText ="Need help?")
	WebElement needHelpLink;

	@FindBy(xpath="//div[@class='companyName']")
	WebElement companyName;
	
	public UsernamePage() {
	PageFactory.initElements(driver, this);
}
	
	
	//Methods/actions to be performed on username page
public String getUsernamePageTitle() {
	return driver.getTitle();
}	

public Boolean validateNextButton() {
	return nextButton.isDisplayed();
}
	
public Boolean validateUsernameTextField() {
	return usernameTextField.isDisplayed();
}

public WebElement getUsernameTextField() {
	return usernameTextField;
}

public Boolean validateCompanyNameOnUsernamePage() {
	return companyName.isDisplayed();
}

public String getCompanyNameText() {
	return companyName.getText();
}

public PasswordPage enterUsername(String username) {
	usernameTextField.sendKeys(username);
	nextButton.click();
	return new PasswordPage();
}

}

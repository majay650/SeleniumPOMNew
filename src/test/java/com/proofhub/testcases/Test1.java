package com.proofhub.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.proofhub.base.TestBase;
import com.proofhub.pages.UsernamePage;

public class Test1 extends TestBase{

	
	UsernamePage usernamePage;

	public Test1() {
		super();
	}

//	@BeforeMethod
//	public void setUp() {
//		initialization();
//		usernamePage = new UsernamePage();
//	}
	
	@Test
	public void userNamePageUIElementsTest() throws InterruptedException {
		initialization();
		Thread.sleep(8000);
		usernamePage.getUsernameTextField().sendKeys("aaaaaaaaaaa");
		Thread.sleep(5000);
}
}

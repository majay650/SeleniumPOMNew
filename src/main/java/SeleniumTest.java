import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@BeforeMethod
	public void openBrowser() {
		driver.get("https://www.google.com");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void googleSearchTest() throws InterruptedException {
		
		WebElement searchTextfield = driver.findElement(By.xpath("//input[@title='Search']"));
		searchTextfield.sendKeys("Selenium");

		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Google Search']")));
		searchButton.click();
		
		WebElement seleniumLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.selenium.dev/']")));
		seleniumLink.click();
		
		//Assert the selenium logo on page
		
		WebElement seleniumLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='logo logo-large' and @src='/images/selenium_logo_large.png']")));
		Assert.assertTrue(seleniumLogo.isDisplayed());
		
		WebElement aboutText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav-item']//span")));
		String atualText = aboutText.getText();
		Assert.assertEquals(atualText, "About");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}

package com.proofhub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {	
		  prop = new Properties();
		 FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\ajay.thakur1\\eclipse-workspace\\AjayProofhubAutomation\\src\\main\\java\\com\\proofhub\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		if (prop.getProperty("browser").equals("chrome")) {
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();
			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);
			 driver = new ChromeDriver(options);
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			 driver = new FirefoxDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
		
	}



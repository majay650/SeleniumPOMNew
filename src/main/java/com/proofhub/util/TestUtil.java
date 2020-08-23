package com.proofhub.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.proofhub.base.TestBase;

public class TestUtil extends TestBase{
static Workbook book;
static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
		file = new FileInputStream("C:\\Users\\ajay.thakur1\\eclipse-workspace\\NaveenProofhubAutomation\\src\\main\\java\\com\\proofhub\\testdata\\SeleniumData.xlsx");
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
		for (int i=0; i<sheet.getLastRowNum();i++) {
			for (int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				System.out.println("ajay");
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshot() throws IOException{
		//Call getScreenshotAs method to create image file
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		String currentDir = System.getProperty("user.dir");
		//Copy file at destination
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis()+".png"));
		}
	
}

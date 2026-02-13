package org.test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.reuse.BaseClass;

public class TestClass extends BaseClass {
	public static void main(String[] args) throws IOException, AWTException {
		
		openChrome();
		launchUrl("https://www.prettylittlething.com/");
		captureScreenshot("screenshot1");
		//onetrust-accept-btn-handler
		WebElement acceptAll = driver.findElement(By.id("onetrust-accept-btn-handler"));
		clickElement(acceptAll);
		WebElement account = driver.findElement(By.xpath("//span[text()='Account'][2]"));
		clickElement(account);
		captureScreenshot("screenshot2");
		WebElement emailTxt= driver.findElement(By.id("login-email"));
		emailTxt.sendKeys(readFromExcel("sheet1", 2, 2)); 
		WebElement pass= driver.findElement(By.id("login-password"));
		pass.sendKeys(readFromExcel("sheet1", 2, 3));
		captureScreenshot("screenshot3"); 
		//Sign In
		WebElement cont= driver.findElement(By.xpath("//div[text()='Sign In']"));
		clickElement(cont);
		captureScreenshot("screenshot4");
		//CLOTHING
		WebElement sel= driver.findElement(By.xpath("//a[text()='CLOTHING']"));
		clickElement(sel);
		captureScreenshot("screenshot5");
	
	}

}

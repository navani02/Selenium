package org.reuse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static void openChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
	}

	public static void launchUrl(String url) {
		driver.get(url); 
	}

	public static void passValue(WebElement ele, String data) {
		ele.sendKeys(data); 
	}

	public static void printCurrentUrl() {
		driver.getCurrentUrl();
	}

	public static void printTitle() {
		driver.getTitle();
	}

	public static void closeCurrentWindow() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static void getElementText(WebElement element) {
		String text = element.getText();

	}

	public static void getElementAttribute(WebElement element) {
		String text = element.getAttribute("value");
	}
	
	public static void ThreadSleep() throws InterruptedException {
		Thread.sleep(10000);
	}

	// Robot 

	public static void enter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void tab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public static void selectAll() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void copy() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

	public static void cut() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void paste() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void shift() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT); 
	}

	// TakeScreenShot
	public static void captureScreenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File temp = screenshot.getScreenshotAs(OutputType.FILE);
		File project = new File("C:\\Users\\Aparna\\eclipse-workspace\\Framework10ambatch\\PomScreenshot\\" + name + ".png");
		FileUtils.copyFile(temp, project); 
	}

	// Frames
	public static void frameIndex(int index) {
		WebDriver frameDriver = driver.switchTo().frame(index);
	}

	public static void frameLocator(String frameId) {
		WebDriver frameDriver = driver.switchTo().frame(frameId);
	}

	public static void frameWebEle(WebElement element) {
		WebDriver frameDriver = driver.switchTo().frame(element);
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void jsclick(WebElement ele) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", ele);
	}

	public static void jsSendkeys(WebElement ele, String data) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + data + "')", ele);
	}

	public static void jsGetAttribute(WebElement ele) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].getAttribute('value')", ele);
	}

	public static void jsScroll(WebElement ele, boolean status) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(" + status + ")", ele);
	}

	// Alert
	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void getTextAlert() {
		Alert alert = driver.switchTo().alert();
		String textValue = alert.getText();
	}

	public static void sendkeysAlert(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}

	// Actions
	public static void mousehover(WebElement element) {
		Actions mouseActions = new Actions(driver);
		mouseActions.moveToElement(element).perform();
	}

	public static void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
		Actions mouseActions = new Actions(driver);
		mouseActions.dragAndDrop(sourceElement, targetElement).perform();
	}

	public static void doubleClickElement(WebElement element) {
		Actions mouseActions = new Actions(driver);
		mouseActions.doubleClick(element).perform();
	}

	public static void rightClickElement(WebElement element) {
		Actions mouseActions = new Actions(driver);
		mouseActions.contextClick(element).perform();
	}

	public static void shiftPress() {
		Actions mouseActions = new Actions(driver);
		mouseActions.keyDown(Keys.SHIFT).perform();
	}

	public static void shiftRelease() {
		Actions mouseActions = new Actions(driver);
		mouseActions.keyUp(Keys.SHIFT).perform();
	}

	// Windows Handling

	public static void parentId() {
		String parentWindow = driver.getWindowHandle();
	}

	public static void allWindowId() {
		Set<String> allWindow = driver.getWindowHandles();
	}

	// DropDown
	public static void pickByIndex(WebElement element, int index) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.selectByIndex(index);
	}

	public static void pickByVisibletext(WebElement element, String visibletext) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.selectByValue(visibletext);
	}

	public static void pickByValue(WebElement element, String visibletext) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.selectByValue(visibletext);
	}

	public static void checkMultipleSelect(WebElement element) {
		Select dropdownSelect = new Select(element);
		boolean multiple = dropdownSelect.isMultiple();
	}

	public static void fetchOptions(WebElement element) {
		Select dropdownSelect = new Select(element);
		List<WebElement> options = dropdownSelect.getOptions();
	}

	public static void fetchAllSelectedOption(WebElement element) {
		Select dropdownSelect = new Select(element);
		List<WebElement> allSelectedOptions = dropdownSelect.getAllSelectedOptions();
	}

	public static void fetchFirstSelectedOption(WebElement element) {
		Select dropdownSelect = new Select(element);
		WebElement firstSelectedOption = dropdownSelect.getFirstSelectedOption();
	}

	public static void deselectAllOptions(WebElement element) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.deselectAll();
	}

	public static void deselectItemByIndex(WebElement element, int index) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.deselectByIndex(index);
	}

	public static void deselectItemByVisibletext(WebElement element, String visibletext) {
		Select dropdownSelect = new Select(element);
		dropdownSelect.deselectByValue(visibletext);
	}

	public static void deselectItemByValue(WebElement dropdownEle, String visibletext) {
		Select dropdownSelect = new Select(dropdownEle);
		dropdownSelect.deselectByValue(visibletext);
	}

	// wait
	public static void setImplicitWait(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}

	public static void waitForElementVisible(int timeInSeconds, String condition) {
		WebDriverWait waitObj = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
	}

	public static void fluentWaitForElement(int timeInSeconds, int pollingInMillis) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeInSeconds)).pollingEvery(Duration.ofMillis(pollingInMillis))
				.ignoring(Throwable.class);
	}

	public static String readFromExcel(String ele,int ro,int ce) throws IOException {
		
		//Locate the File --> Create object for File
				File f = new File("C:\\Users\\Aparna\\eclipse-workspace\\Framework10ambatch\\ExcelFolder\\TestDatas.xlsx");
				//Read that File --> Create object for FileInputStream
				FileInputStream fis = new FileInputStream(f);
				//Read that book --> create Object for Workbook-i -- XSSFWorkbook
			    Workbook w = new XSSFWorkbook(fis);
			    //Get the sheet from book  --> call getSheet()
			    Sheet sh = w.getSheet(ele);
				//Get the Row from Sheet ==> Call getRow()
			    
			    	Row r = sh.getRow(ro);  
			    	
			    		//Get the cell from row ==> Call getCell()
					    Cell c = r.getCell(ce);
					    int type = c.getCellType();
					    String value ="";
					    if(type==1) {
					    	value = c.getStringCellValue();
					    }
					    else if(DateUtil.isCellDateFormatted(c)){
					    	Date dd = c.getDateCellValue();
					    	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					    	value = sdf.format(dd);      
					    }
					    else {
					    	double number = c.getNumericCellValue();
					    	long l = (long)number;
					    	value = String.valueOf(l);
					    }
					    	System.out.println(value);
					    	return value;
	}
}

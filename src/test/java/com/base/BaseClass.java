package com.base;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Kandasamy
 * @description Used to maintain all the reusable methods
 * 
 */
public class BaseClass {

	protected static WebDriver driver;

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;

		}

	}

	public static void enterUrl(String url) {
		driver.get(url);
	}

	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	public static void quitWindow() {
		driver.quit();

	}

	public static void closeWindow() {
		driver.close();
	}

	public void elementSendkeys(WebElement element, String Data) {
		element.sendKeys(Data);

	}

	public void clear(WebElement element) {
		element.clear();

	}

	public static void elementClick(WebElement element) {
		element.click();

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public WebElement FindById(String Attributevalue) {
		WebElement element = driver.findElement(By.id(Attributevalue));
		return element;

	}

	public WebElement elementFindByName(String AttributeValue) {
		WebElement element = driver.findElement(By.name(AttributeValue));
		return element;

	}

	public WebElement elementFindByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;

	}

	public WebElement elementFindByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;

	}

	public WebElement elementFindByTag(WebElement element, String tagName) {
		driver.findElement(By.tagName(tagName));
		return element;
	}

	public WebElement elementFindByTagName(WebElement element, String tagName) {
		driver.findElements(By.tagName(tagName));
		return element;

	}

	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public String getText(WebElement element) {

		String text = element.getText();
		return text;

	}

	public String elementGetAttribute(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public String elementGetAttribute(WebElement element, String Attribute) {

		String attribute = element.getAttribute("attributename");
		return attribute;

	}
	// ***********DROPDOWN********************************

	Select select;

	public void SelectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void SelectOptionByAttribute(WebElement element, String Value) {
		select = new Select(element);
		select.selectByValue(Value);

	}

	public void SelectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public List<WebElement> SelectGetOptions() {
		List<WebElement> options = select.getOptions();
		return options;

	}

	public List<WebElement> selectGetAllSelectedOptions() {
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;

	}

	public WebElement selectGetFirstSelectedOption() {
		WebElement element = select.getFirstSelectedOption();
		return element;

	}

	public boolean isMultiple() {
		boolean multiple = select.isMultiple();
		return multiple;

	}

	public void deselectByIndex(int index) {
		select.deselectByIndex(index);
	}

	public void deselectByValue(String value) {
		select.deselectByValue(value);
	}

	public void deselectByVisibleText(String text) {
		select.deselectByVisibleText(text);
	}

	public void deselectAll() {
		select.deselectAll();
	}

	// ***************************************javascript**********************************

	public void SendKeysJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);

	}

	public void ClickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);

	}

	public Object getAttributeJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object object = executor.executeScript("argument[0].getAttribute('value')", element);
		return object;

	}

	public void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);

	}

	public void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);

	}

	// *****************ACTIONS***********************

	Actions actions;

	public void moveToElement(WebElement element, String Xpath) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void DragAndDrop(WebElement source, WebElement destination) {

		actions.dragAndDrop(source, destination);
	}

	public void DoubleClick() {
		actions.doubleClick();
	}

	public void sendKeys(WebElement element, String data) {
		actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(data).keyUp(Keys.SHIFT).perform();
	}

	public void contextClick(WebElement element) {
		actions.contextClick().perform();

	}

	// *****************NAVIGATE***********************

	Navigation navigate;

	public void Navigate(String url) {
		driver.navigate();
		navigate.to(url);

	}

	public void NavigateBack() {
		navigate.back();

	}

	public void NavigateForward() {
		navigate.forward();

	}

	public void NavigateRefresh() {
		navigate.refresh();

	}

	public WebElement isDisplayed(WebElement element, String attributevalue) {
		WebElement element2 = driver.findElement(By.id("attributevalue"));
		element2.isDisplayed();
		return element2;

	}

	public WebElement isEnabled(WebElement element, String attributevalue) {
		WebElement element3 = driver.findElement(By.id("attributevalue"));
		element3.isEnabled();
		return element3;
	}

	public WebElement isSelected(WebElement element, String attributevalue) {
		WebElement element4 = driver.findElement(By.id("attributevalue"));
		element4.isSelected();
		return element4;
	}

	Robot robot;

	public void robotClass() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.KEY_PRESSED);
	}

	// ************************ALERT******************************
	Alert alert;

	public void alert() {
		driver.switchTo().alert().accept();

	}

	public String alertgetText() {
		String text = alert.getText();
		return text;

	}

	public void alertAccept() {
		alert.accept();
	}

	public void alertDismiss() {
		alert.dismiss();

	}

	public void alertSendkeys() {
		alert.sendKeys("value");
		alert.accept();
	}

	// *************************frames*****************************

	public void frameName(String value) {
		driver.switchTo().frame(value);

	}

	public WebElement frameElement(WebElement element) {
		WebElement element1 = driver.findElement(By.xpath("string"));

		driver.switchTo().frame(element1);
		return element1;

	}

	public List<WebElement> frameIntIndex(WebElement element, int index) {
		List<WebElement> findElements = driver.findElements(By.tagName("value"));
		driver.switchTo().frame(index);
		return findElements;
	}

	private void parentframe() {
		driver.switchTo().parentFrame();
	}

	private void defaultframe() {
		driver.switchTo().defaultContent();
	}

	// ***********************windowhandling******************************

	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> Listwindow = new ArrayList<String>();
		Listwindow.addAll(windowHandles);

		String child = Listwindow.get(0);

		driver.switchTo().window(child);

	}

	// ****************************webtable********************************

	public String tableRows(List<WebElement> element, String text) {
		List<WebElement> tableRows = driver.findElements(By.tagName("attributevalue"));
		String text1 = tableRows.get(1).getText();
		return text1;

	}

	// ***************************Excel*************************************

	public String readValueExcel(String SheetName, int rownum, int cellnum) throws IOException {

		String res = " ";

		File file = new File("C:\\Users\\Kandasamy\\eclipse-workspace\\FirstDayMaven\\Excel\\AdactinTask.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(SheetName);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:

			res = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(dateCellValue);

			} else {
				double d = cell.getNumericCellValue();

				long check = Math.round(d);

				if (check == d) {

					res = String.valueOf(check);

				} else {
					res = String.valueOf(d);

				}

			}

			break;

		default:
			break;
		}
		return res;

	}

	// -------------------------------------------------------------------------

	public void updateValue(String sheetName, int rownum, int cellnum, String old, String newdata) throws IOException {

		File file = new File("C:\\Users\\Kandasamy\\eclipse-workspace\\FirstDayMaven\\Excel\\framework sample.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		cell.getCellType();

		String Value = cell.getStringCellValue();

		if (Value == "old") {
			cell.setCellValue("newdata");

		}

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);

	}

	// ----------------------------------------------------------------------------------

	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {

		File file = new File("C:\\Users\\Kandasamy\\eclipse-workspace\\FirstDayMaven\\Excel\\AdactinTask.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		Cell cell = row.createCell(cellnum);

		cell.setCellValue(data);

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);

	}

	// ----------------------------------------------------------------------------------------

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties"));

		String value = (String) properties.get(key);

		return value;

	}

}

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
 * @date 07/09/2022
 * 
 */
public class BaseClass {
	/**
	 * @description used to launch the drivers using different browsers
	 * @param browsertype
	 * 
	 */

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

	/**
	 * @description used to enter url
	 * @param url
	 */
	public static void enterUrl(String url) {
		driver.get(url);
	}

	/**
	 * @description used to maximize window
	 */
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @description used to quit window
	 */

	public static void quitWindow() {
		driver.quit();

	}

	/**
	 * @description used to close window
	 */

	public static void closeWindow() {
		driver.close();
	}

	/**
	 * @description reusable method for element sendkeys
	 * @param element
	 * @param Data
	 */
	public void elementSendkeys(WebElement element, String Data) {
		element.sendKeys(Data);

	}

	/**
	 * @description reusable method for clear
	 * @param element
	 */

	public void clear(WebElement element) {
		element.clear();

	}

	/**
	 * @description reusable method for click
	 * @param element
	 */

	public static void elementClick(WebElement element) {
		element.click();

	}

	/**
	 * @description reusable method for getTitle
	 * @return title
	 */

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	/**
	 * @description reusable method for FindByID
	 * @param Attributevalue
	 * @return webelement
	 */

	public WebElement FindById(String Attributevalue) {
		WebElement element = driver.findElement(By.id(Attributevalue));
		return element;

	}

	/**
	 * @description reusable method for element find by name
	 * @param AttributeValue
	 * @return web element
	 */
	public WebElement elementFindByName(String AttributeValue) {
		WebElement element = driver.findElement(By.name(AttributeValue));
		return element;

	}

	/**
	 * @description reusable method for element find by xpath
	 * @param xpath
	 * @return element
	 */
	public WebElement elementFindByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;

	}

	/**
	 * @description reusable method for element find by class name
	 * @param classname
	 * @return element
	 */

	public WebElement elementFindByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;

	}

	/**
	 * @description reusable method for element find by tag
	 * @param element
	 * @param tagName
	 * @return element
	 */
	public WebElement elementFindByTag(WebElement element, String tagName) {
		driver.findElement(By.tagName(tagName));
		return element;
	}

	/**
	 * @description reusable method for element find by tag
	 * @param element
	 * @param tagName
	 * @return
	 */

	public WebElement elementFindByTagName(WebElement element, String tagName) {
		driver.findElements(By.tagName(tagName));
		return element;

	}

	/**
	 * @description reusable method for getUrl
	 * @return currentUrl
	 */

	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	/**
	 * @description reusable method for gettext
	 * @return text
	 */
	public String getText(WebElement element) {

		String text = element.getText();
		return text;

	}

	/**
	 * @description reusable method for get attribute using value
	 * @param element
	 * @return
	 */
	public String elementGetAttribute(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	/**
	 * @description reusable method for get attribute using attribute name
	 * @param element
	 * @return
	 */
	public String elementGetAttribute(WebElement element, String Attribute) {

		String attribute = element.getAttribute("attributename");
		return attribute;

	}
	// ***********DROPDOWN********************************

	Select select;

	/**
	 * @description used to maintain reusable method for select option by text
	 * @param element
	 * @param text
	 */
	public void SelectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * @description used to maintain reusable method for select option by attribute
	 * @param element
	 * @param Value
	 */
	public void SelectOptionByAttribute(WebElement element, String Value) {
		select = new Select(element);
		select.selectByValue(Value);

	}

	/**
	 * @description used to maintain reusable method for select option by index
	 * @param element
	 * @param index
	 */

	public void SelectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * @description used to maintain reusable method for select option by index
	 * @return options
	 */

	public List<WebElement> SelectGetOptions() {
		List<WebElement> options = select.getOptions();
		return options;

	}

	/**
	 * @description used to maintain reusable method for select get all selected
	 *              options
	 * @return allselectedoptions
	 */

	public List<WebElement> selectGetAllSelectedOptions() {
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;

	}

	/**
	 * @description used to maintain reusable method for select get first selected
	 *              option
	 * @return element
	 */
	public WebElement selectGetFirstSelectedOption() {
		WebElement element = select.getFirstSelectedOption();
		return element;

	}

	/**
	 * @description used to check select is multiple
	 * @return
	 */
	public boolean isMultiple() {
		boolean multiple = select.isMultiple();
		return multiple;

	}

	/**
	 * @description used to maintain reusable method deselect by index
	 * @param index
	 */

	public void deselectByIndex(int index) {
		select.deselectByIndex(index);
	}

	/**
	 * @description used to maintain reusable method deselect by value
	 * @param value
	 */
	public void deselectByValue(String value) {
		select.deselectByValue(value);
	}

	/**
	 * @description used to maintain reusable method deselect by visible text
	 * @param text
	 */

	public void deselectByVisibleText(String text) {
		select.deselectByVisibleText(text);
	}

	/**
	 * @description used to maintain reusable method deselectAll
	 * @param index
	 */
	public void deselectAll() {
		select.deselectAll();
	}

	// ***************************************javascript**********************************
	/**
	 * @description used to maintain javascript element send keys
	 * @param element
	 * @param text
	 */
	public void SendKeysJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);

	}

	/**
	 * @description used to maintain javascript click
	 * @param element
	 */

	public void ClickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);

	}

	/**
	 * @description used to maintain javascript getAttribute
	 * @param element
	 * @return object
	 */

	public Object getAttributeJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object object = executor.executeScript("argument[0].getAttribute('value')", element);
		return object;

	}

	/**
	 * @description used to maintain javascript scrolldown
	 * @param element
	 */
	public void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);

	}

	/**
	 * @description used to maintain javascript scrollup
	 * @param element
	 */
	public void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);

	}

	// *****************ACTIONS***********************

	Actions actions;

	/**
	 * @description used to maintain actions move to element
	 * @param element
	 * @param Xpath
	 */

	public void moveToElement(WebElement element, String Xpath) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	/**
	 * @description used to maintain actions drag and drop
	 * @param source
	 * @param destination
	 */

	public void DragAndDrop(WebElement source, WebElement destination) {

		actions.dragAndDrop(source, destination);
	}

	/**
	 * @description used to maintain double click
	 */
	public void DoubleClick() {
		actions.doubleClick();
	}

	/**
	 * @description used to maintain sendkeys in actions
	 * @param element
	 * @param data
	 */

	public void sendKeys(WebElement element, String data) {
		actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(data).keyUp(Keys.SHIFT).perform();
	}

	/**
	 * @description used to maintain context click
	 * @param element
	 */

	public void contextClick(WebElement element) {
		actions.contextClick().perform();

	}

	// *****************NAVIGATE***********************

	Navigation navigate;

	/**
	 * @description used to open url using navigate
	 * @param url
	 */

	public void Navigate(String url) {
		driver.navigate();
		navigate.to(url);

	}

	/**
	 * @description used to go back using navigate
	 */
	public void NavigateBack() {
		navigate.back();

	}

	/**
	 * @description used to go forward using navigate
	 */
	public void NavigateForward() {
		navigate.forward();

	}

	/**
	 * @description used to go refresh using navigate
	 */
	public void NavigateRefresh() {
		navigate.refresh();

	}

	/**
	 * @description used to check webelement is displayed
	 * @param element
	 * @param attributevalue
	 * @return element
	 */
	public WebElement isDisplayed(WebElement element, String attributevalue) {
		WebElement element2 = driver.findElement(By.id("attributevalue"));
		element2.isDisplayed();
		return element2;

	}

	/**
	 * @description used to check webelement is enabled
	 * @param element
	 * @param attributevalue
	 * @return element
	 */

	public WebElement isEnabled(WebElement element, String attributevalue) {
		WebElement element3 = driver.findElement(By.id("attributevalue"));
		element3.isEnabled();
		return element3;
	}

	/**
	 * @description used to check webelement is selected
	 * @param element
	 * @param attributevalue
	 * @return element
	 */
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

	/**
	 * @description used to switch to alert and accept
	 */
	public void alert() {
		driver.switchTo().alert().accept();

	}

	/**
	 * @description used to alert get text
	 * @return text
	 */

	public String alertgetText() {
		String text = alert.getText();
		return text;

	}

	/**
	 * @description used to switch to alert accept
	 */
	public void alertAccept() {
		alert.accept();
	}

	/**
	 * @description used to switch to alert dismiss
	 */
	public void alertDismiss() {
		alert.dismiss();

	}

	/**
	 * @description used to switch to alert sendkeys and accept
	 */
	public void alertSendkeys() {
		alert.sendKeys("value");
		alert.accept();
	}

	// *************************frames*****************************
	/**
	 * @description used for switch to frame using value
	 * @param value
	 */
	public void frameName(String value) {
		driver.switchTo().frame(value);

	}

	/**
	 * @description used for switch to frame using web element
	 * @param element
	 * @return element1
	 */
	public WebElement frameElement(WebElement element) {
		WebElement element1 = driver.findElement(By.xpath("string"));

		driver.switchTo().frame(element1);
		return element1;

	}

	/**
	 * @description used for switch to frames using index
	 * @param element
	 * @param index
	 * @return find elements
	 */
	public List<WebElement> frameIntIndex(WebElement element, int index) {
		List<WebElement> findElements = driver.findElements(By.tagName("value"));
		driver.switchTo().frame(index);
		return findElements;
	}

	/**
	 * @description switch to parent frame
	 */

	private void parentframe() {
		driver.switchTo().parentFrame();
	}

	/**
	 * @description switch to default frame
	 */

	private void defaultframe() {
		driver.switchTo().defaultContent();
	}

	// ***********************windowhandling******************************
	/**
	 * @description used for getting window handle
	 * @return window handle
	 */
	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * @description used for getting window handles
	 */

	public void getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> Listwindow = new ArrayList<String>();
		Listwindow.addAll(windowHandles);

		String child = Listwindow.get(0);

		driver.switchTo().window(child);

	}

	// ****************************webtable********************************
	/**
	 * @description used for webtable
	 * @param element
	 * @param text
	 * @return text1
	 */
	public String tableRows(List<WebElement> element, String text) {
		List<WebElement> tableRows = driver.findElements(By.tagName("attributevalue"));
		String text1 = tableRows.get(1).getText();
		return text1;

	}

	// ***************************Excel*************************************
	/**
	 * @description used to maitain read value using excel
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
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
	/**
	 * @description used to maintain update value using excel
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param old
	 * @param newdata
	 * @throws IOException
	 */
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
	/**
	 * @description used to maintain write value in excel
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 */
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
	/**
	 * @description used to read the values from the property file
	 * @param key
	 * @return value
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties"));

		String value = (String) properties.get(key);

		return value;

	}

}

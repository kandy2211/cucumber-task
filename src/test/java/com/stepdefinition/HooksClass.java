package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @description used to maintain hooks class
 * @author Kandasamy
 * @date 07/09/2022
 *
 */
public class HooksClass extends BaseClass {
	/**
	 * @description this method used to launch browser and url
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	public void launchBrowser() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browserType"));

		enterUrl(getPropertyFileValue("url"));

		maximizewindow();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	/**
	 * @description this method used to take screenshot after each scenario
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(b, "image/png", "every scenario");

	}

}

package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browserType"));

		enterUrl(getPropertyFileValue("url"));
		
		maximizewindow();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("User should perform login {string} , {string}")
	public void userShouldPerformLogin(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	@When("User should perform login {string} , {string} with Enter Key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) throws AWTException {

		pom.getLoginPage().loginWithEnter(username, password);

	}

	@Then("User should verify after login error contains {string}")
	public void userShouldVerifyAfterLoginErrorContains(String errorMsg) {

		String error = pom.getLoginPage().getErrorMsg().getText();
		System.out.println("print:"+error);

		Assert.assertTrue("invalidLoginMsg", error.contains(errorMsg));

	}

}
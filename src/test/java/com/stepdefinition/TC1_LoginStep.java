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

/**
 * 
 * @author Kandasamy
 * @description used to maintain login step related methods
 * @date 07/09/2022
 *
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description this method used to launch the browser and open url
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @date 07/09/2022
	 */
	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {

	}

	/**
	 * @description this method used to perform login
	 * @param username
	 * @param password
	 * @date 07/09/2022
	 */
	@When("User should perform login {string} , {string}")
	public void userShouldPerformLogin(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	/**
	 * @description this method used to perform login with enter key
	 * @param username
	 * @param password
	 * @throws AWTException
	 * @date 07/09/2022
	 */

	@When("User should perform login {string} , {string} with Enter Key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) throws AWTException {

		pom.getLoginPage().loginWithEnter(username, password);

	}

	/**
	 * @description this method used to verify login error message
	 * @param errorMsg
	 * @date 07/09/2022
	 */
	@Then("User should verify after login error contains {string}")
	public void userShouldVerifyAfterLoginErrorContains(String errorMsg) {

		String error = pom.getLoginPage().getErrorMsg().getText();
		System.out.println("print:" + error);

		Assert.assertTrue("invalidLoginMsg", error.contains(errorMsg));

	}

}
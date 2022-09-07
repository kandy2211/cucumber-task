package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Kandasamy
 * @description used to maintain select hotel step related methods
 * @date 07/09/2022
 *
 */
public class TC3_SelectHotelStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description this method used to select hotel name and click continue
	 * @date 07/09/2022
	 */
	@Then("User should select hotel name and click continue")
	public void userShouldSelectHotelNameAndClickContinue() {
		pom.getSelectHotelPage().selectHotelWithHotelName();

	}

	/**
	 * @description this method navigates to book hotel page and verify message
	 * @param msgBookHotel
	 * @date 07/09/2022
	 */

	@Then("User should navigate to book hotel page and verify {string} message")
	public void userShouldNavigateToBookHotelPageAndVerifyMessage(String msgBookHotel) {

		String bookHotelMsg = pom.getBookHotelPage().getBookHotelMsg().getText();
		Assert.assertEquals("bookHotelMsg", msgBookHotel, bookHotelMsg);
	}

	/**
	 * @description this method used to click continue without selecting hotel name
	 * @date 07/09/2022
	 */
	@Then("User should click continue without selecting hotel name")
	public void userShouldClickContinueWithoutSelectingHotelName() {
		pom.getSelectHotelPage().selectHotelWithoutHotelName();

	}

	/**
	 * @description this method used to please select hotel error message
	 * @date 07/09/2022
	 * @param pleaseSelectHotel
	 */
	@Then("User should verify {string} error message")
	public void userShouldVerifyErrorMessage(String pleaseSelectHotel) {

		String pleaseSelectHotelMsg = pom.getSelectHotelPage().getPleaseSelectHotel().getText();

		Assert.assertEquals("select hotel errormsg", pleaseSelectHotel, pleaseSelectHotelMsg);

	}

}

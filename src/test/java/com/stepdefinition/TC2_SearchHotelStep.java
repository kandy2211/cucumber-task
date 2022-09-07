package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Kandasamy
 * @description used to maintain search step related methods
 * @date 07/09/2022
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description this method used to enter search hotel details
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param roomnos
	 * @param checkin
	 * @param checkout
	 * @param adults
	 * @param children
	 * @date 07/09/2022
	 */

	@When("User should enter search hotel details {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterSearchHotelDetailsAnd(String location, String hotels, String roomType, String roomnos,
			String checkin, String checkout, String adults, String children) {

		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, roomnos, checkin, checkout, adults, children);

	}

	/**
	 * @description this method navigates to select hotel page and verify message
	 * @param expSelectHotelMsg
	 * @date 07/09/2022
	 */

	@Then("User should navigate to select hotel page and verify {string} message")
	public void userShouldNavigateToSelectHotelPageAndVerifyMessage(String expSelectHotelMsg) {
		String actualselecthoteltext = pom.getSelectHotelPage().getSelectHotelMsg().getText();
		System.out.println("print:" + actualselecthoteltext);
		Assert.assertEquals("verify select hotel msg", expSelectHotelMsg, actualselecthoteltext);

	}

	/**
	 * @description this method used to enter search hotel mandatory fields
	 * @param location
	 * @param roomnos
	 * @param checkin
	 * @param checkout
	 * @param adults
	 * @date 07/09/2022
	 */

	@When("User should enter mandatory fields of search hotel {string},{string},{string},{string} and {string}")
	public void userShouldEnterMandatoryFieldsOfSearchHotelAnd(String location, String roomnos, String checkin,
			String checkout, String adults) {

		pom.getSearchHotelPage().searchHotelMandatoryFields(location, roomnos, checkin, checkout, adults);

	}

	/**
	 * @description this method used to verify date error message
	 * @param checkinBefore
	 * @param checkinAfter
	 * @date 07/09/2022
	 */

	@Then("User should verify date error message  {string},{string}")
	public void userShouldVerifyDateErrorMessage(String checkinBefore, String checkinAfter) {
		String checkInDateBefore = pom.getSearchHotelPage().getDateBefore().getText();
		Assert.assertEquals("date checking", checkinBefore, checkInDateBefore);

		String checkInDateAfter = pom.getSearchHotelPage().getDateAfter().getText();
		Assert.assertEquals("date checking", checkinAfter, checkInDateAfter);

	}

	/**
	 * @description this method used to click search button without any fields
	 * @date 07/09/2022
	 */
	@When("User should click search button without selecting all fields")
	public void userShouldClickSearchButtonWithoutSelectingAllFields() {

		pom.getSearchHotelPage().searchHotelWithoutAnyFields();

	}

	/**
	 * @description this method used to verify location error message
	 * @param locationmsg
	 */
	@Then("User should verify error message  {string}")
	public void userShouldVerifyErrorMessage(String locationmsg) {

		String locationerrormsg = pom.getSearchHotelPage().getLocationmsg().getText();

		Assert.assertEquals("locationerrormsg", locationmsg, locationerrormsg);

	}

}

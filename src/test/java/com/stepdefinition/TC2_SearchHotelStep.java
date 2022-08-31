package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	@When("User should enter search hotel details {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterSearchHotelDetailsAnd(String location, String hotels, String roomType, String roomnos,
			String checkin, String checkout, String adults, String children) {
		
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, roomnos, checkin, checkout, adults, children);
		
	

	}

	@Then("User should navigate to select hotel page and verify {string} message")
	public void userShouldNavigateToSelectHotelPageAndVerifyMessage(String expSelectHotelMsg) {
		String actualselecthoteltext = pom.getSelectHotelPage().getSelectHotelMsg().getText();
		System.out.println("print:"+actualselecthoteltext);
		Assert.assertEquals("verify select hotel msg", expSelectHotelMsg,actualselecthoteltext );
		

	}

	@When("User should enter mandatory fields of search hotel {string},{string},{string},{string} and {string}")
	public void userShouldEnterMandatoryFieldsOfSearchHotelAnd(String location, String roomnos, String checkin,
			String checkout, String adults) {
		
		pom.getSearchHotelPage().searchHotelMandatoryFields(location, roomnos, checkin, checkout, adults);

	}

	@Then("User should verify date error message  {string},{string}")
	public void userShouldVerifyDateErrorMessage(String checkinBefore, String checkinAfter) {
		String checkInDateBefore = pom.getSearchHotelPage().getDateBefore().getText();
		Assert.assertEquals("date checking", checkinBefore,checkInDateBefore );
		
		String checkInDateAfter = pom.getSearchHotelPage().getDateAfter().getText();
		Assert.assertEquals("date checking",checkinAfter , checkInDateAfter);

	}

	@When("User should click search button without selecting all fields")
	public void userShouldClickSearchButtonWithoutSelectingAllFields() {
		
		pom.getSearchHotelPage().searchHotelWithoutAnyFields();

	}

	@Then("User should verify error message  {string}")
	public void userShouldVerifyErrorMessage(String locationmsg) {
		
		String locationerrormsg = pom.getSearchHotelPage().getLocationmsg().getText();
		
		Assert.assertEquals("locationerrormsg",locationmsg , locationerrormsg);

	}

}

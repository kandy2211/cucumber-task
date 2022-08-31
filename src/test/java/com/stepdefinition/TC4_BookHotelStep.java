package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should enter book hotel credentials {string},{string} and {string}")
	public void userShouldEnterBookHotelCredentialsAnd(String firstname, String lastname, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> details = dataTable.asMaps();
		Map<String, String> card = details.get(1);
		String cardno = card.get("Credit Card No");
		String cardtype = card.get("Credit Card Type");
		String expmonth = card.get("ExpiryMonth");
		String expyear = card.get("ExpiryYear");
		String cvv = card.get("CVV");

		pom.getBookHotelPage().bookHotel(firstname, lastname, address, cardno, cardtype, expmonth, expyear, cvv);

	}

	@Then("User should navigate to booking confirmation page and verify {string} message")
	public void userShouldNavigateToBookingConfirmationPageAndVerifyMessage(String bookingConfirm) {

		String bookingConfirmMsg = pom.getBookingConfirmationPage().getBookingConfirmationMsg().getText();
		Assert.assertEquals("booking confirm verify", bookingConfirm, bookingConfirmMsg);
	}

	@Then("User should click book now without entering any fields")
	public void userShouldClickBookNowWithoutEnteringAnyFields() {

		pom.getBookHotelPage().bookHotelWithoutAnyFields();

	}

	@Then("User should verify error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessagesAnd(String firstnameError, String lastnameError, String addressError, String cardnoerror,
			String cardtypeError, String cardmontherror, String cvvError) {

		String firstNameMsg = pom.getBookHotelPage().getEnterFirstNameErrorMsg().getText();
		Assert.assertEquals("verify firstname error msg", firstnameError, firstNameMsg);
		
		String lastNameMsg = pom.getBookHotelPage().getEnterLastNameErrorMsg().getText();
		Assert.assertEquals("verify lastname error msg", lastnameError, lastNameMsg);
		
		 String addressErrorMsg = pom.getBookHotelPage().getAddressErrorMsg().getText();
		 Assert.assertEquals("verify address error msg",addressError , addressErrorMsg);
		 
		 String cardnoErrorMsg = pom.getBookHotelPage().getEntercardNo().getText();
		 Assert.assertEquals("verify card no error msg",cardnoerror , cardnoErrorMsg);
		 
		 String cardtypeErrorMsg = pom.getBookHotelPage().getEnterCardType().getText();
		 Assert.assertEquals("verify card type error msg", cardtypeError, cardtypeErrorMsg);
		 
		 String cardExpiryMonth = pom.getBookHotelPage().getEnterCardMonth().getText();
		 Assert.assertEquals("verify card month error msg",cardmontherror , cardExpiryMonth);
		
		 String cvvErrorMsg = pom.getBookHotelPage().getEnterCVV().getText();
		 Assert.assertEquals("verify cvv error msg",cvvError , cvvErrorMsg);
		

	}

}

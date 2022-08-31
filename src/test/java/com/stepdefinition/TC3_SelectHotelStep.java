package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep {
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should select hotel name and click continue")
	public void userShouldSelectHotelNameAndClickContinue() {
		pom.getSelectHotelPage().selectHotelWithHotelName();
		

	}

	@Then("User should navigate to book hotel page and verify {string} message")
	public void userShouldNavigateToBookHotelPageAndVerifyMessage(String msgBookHotel) {
		
		String bookHotelMsg = pom.getBookHotelPage().getBookHotelMsg().getText();
		Assert.assertEquals("bookHotelMsg", msgBookHotel, bookHotelMsg);
	}

	@Then("User should click continue without selecting hotel name")
	public void userShouldClickContinueWithoutSelectingHotelName() {
		pom.getSelectHotelPage().selectHotelWithoutHotelName();

	}

	@Then("User should verify {string} error message")
	public void userShouldVerifyErrorMessage(String pleaseSelectHotel) {
		
		  String pleaseSelectHotelMsg = pom.getSelectHotelPage().getPleaseSelectHotel().getText();
		
		Assert.assertEquals("select hotel errormsg", pleaseSelectHotel, pleaseSelectHotelMsg);

	}

}

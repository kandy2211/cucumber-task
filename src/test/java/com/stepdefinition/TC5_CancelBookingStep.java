package com.stepdefinition;

import org.junit.Assert;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep {
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User should navigate to Booked Itinerary page and cancel booking using order id")
	public void userShouldNavigateToBookedItineraryPageAndCancelBookingUsingOrderId() {
		
		String bookingId = pom.getBookingConfirmationPage().bookingConfirm();
		
		pom.getCancelBookingPage().bookingCancel(bookingId);
		
	    
	}
	@Then("User should verify the cancel booking success message {string}")
	public void userShouldVerifyTheCancelBookingSuccessMessage(String cancelMsg) {
	    String cancelBookMsg = pom.getCancelBookingPage().getCancelBookMsg().getText();
	    
	    Assert.assertEquals("verify cancel booking msg", cancelMsg, cancelBookMsg);
	}
	
	@Then("User should navigate to Booked Itinerary page and cancel booking using existing order id {string}")
	public void userShouldNavigateToBookedItineraryPageAndCancelBookingUsingExistingOrderId(String ExistingOrderId) {
		
		pom.getCancelBookingPage().bookingCancel(ExistingOrderId);
	  
	}
	

}

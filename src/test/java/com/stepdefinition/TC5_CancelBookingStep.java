package com.stepdefinition;

import org.junit.Assert;

import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Kandasamy
 * @description used to maintain cancel booking step related methods
 * @date 07/09/2022
 *
 */
public class TC5_CancelBookingStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @description this method used to navigate booked itinerary page and cancel
	 *              booking using orderId
	 * @date 07/09/2022
	 */

	@Then("User should navigate to Booked Itinerary page and cancel booking using order id")
	public void userShouldNavigateToBookedItineraryPageAndCancelBookingUsingOrderId() {

		String bookingId = pom.getBookingConfirmationPage().bookingConfirm();

		pom.getCancelBookingPage().bookingCancel(bookingId);

	}

	/**
	 * @description this method used to verify cancel booking success message
	 * @param cancelMsg
	 */
	@Then("User should verify the cancel booking success message {string}")
	public void userShouldVerifyTheCancelBookingSuccessMessage(String cancelMsg) {
		String cancelBookMsg = pom.getCancelBookingPage().getCancelBookMsg().getText();

		Assert.assertEquals("verify cancel booking msg", cancelMsg, cancelBookMsg);
	}

	/**
	 * @description this method to cancel booking using existing order id
	 * @param ExistingOrderId
	 */
	@Then("User should navigate to Booked Itinerary page and cancel booking using existing order id {string}")
	public void userShouldNavigateToBookedItineraryPageAndCancelBookingUsingExistingOrderId(String ExistingOrderId) {

		pom.getCancelBookingPage().bookingCancel(ExistingOrderId);

	}

}

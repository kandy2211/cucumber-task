package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "order_id_text")
	private WebElement idBox;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookedItinerary;

	@FindBy(id = "search_result_error")
	private WebElement cancelBookMsg;

	public WebElement getIdBox() {
		return idBox;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnBookedItinerary() {
		return btnBookedItinerary;
	}

	public WebElement getCancelBookMsg() {
		return cancelBookMsg;
	}

	public void bookingCancel(String orderid) {

		elementClick(getBtnBookedItinerary());

		elementSendkeys(idBox, orderid);

		elementClick(btnGo);

		elementClick(btnCancel);

		alert();

	}
}

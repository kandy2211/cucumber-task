package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement bookingConfirmationMsg;

	@FindBy(xpath = "//input[@id='order_no']")
	private WebElement orderno;

	

	public WebElement getOrderno() {
		return orderno;
	}

	public WebElement getBookingConfirmationMsg() {
		return bookingConfirmationMsg;
	}

	

	public String bookingConfirm() {

		String orderId = elementGetAttribute(getOrderno());
		return orderId;

	}

}

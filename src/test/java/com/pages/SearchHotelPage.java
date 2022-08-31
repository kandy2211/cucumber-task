package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement welcomemsg;

	@FindBy(xpath = "//span[text()='Please Select a Location']")
	private WebElement locationmsg;

	@FindBy(xpath = "//span[contains(text(),'Check-In Date shall be before')]")
	private WebElement dateBefore;

	@FindBy(xpath = "//span[contains(text(),'Check-Out Date shall be after ')]")
	private WebElement dateAfter;

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnhotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement roomNos;

	@FindBy(id = "datepick_in")
	private WebElement checkIn;

	@FindBy(id = "datepick_out")
	private WebElement checkOut;

	@FindBy(id = "adult_room")
	private WebElement adultPerRoom;

	@FindBy(id = "child_room")
	private WebElement childPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getWelcomemsg() {
		return welcomemsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getHotels() {
		return dDnhotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getChildPerRoom() {
		return childPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getLocationmsg() {
		return locationmsg;
	}

	public WebElement getDateBefore() {
		return dateBefore;
	}

	public WebElement getDateAfter() {
		return dateAfter;
	}

	public void searchHotel(String location, String hotels, String roomType, String roomnos, String checkin,
			String checkout, String adults, String children) {

		

		SelectOptionByText(getdDnLocation(), location);

		SelectOptionByText(getHotels(), hotels);

		SelectOptionByText(getRoomType(), roomType);

		SelectOptionByText(getRoomNos(), roomnos);

		clear(getCheckIn());

		elementSendkeys(getCheckIn(), checkin);

		clear(getCheckOut());

		elementSendkeys(getCheckOut(), checkout);

		SelectOptionByText(getAdultPerRoom(), adults);

		SelectOptionByText(getChildPerRoom(), children);

		elementClick(btnSubmit);

	}

	public void searchHotelMandatoryFields(String location, String roomnos, String checkin, String checkout,
			String adults) {

		SelectOptionByText(getdDnLocation(), location);

		SelectOptionByText(getRoomNos(), roomnos);

		clear(getCheckIn());

		elementSendkeys(getCheckIn(), checkin);

		clear(getCheckOut());

		elementSendkeys(getCheckOut(), checkout);

		SelectOptionByText(getAdultPerRoom(), adults);

		elementClick(btnSubmit);

	}

	public void searchHotelWithoutAnyFields() {

		elementClick(btnSubmit);
	}

}

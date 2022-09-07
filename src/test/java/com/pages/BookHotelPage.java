package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.base.BaseClass;
/**
 * 
 * @author Kandasamy
 * @description used to maintain book hotel web elements
 * @date 07/09/2022
 *
 */
public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement bookHotelMsg;

	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement enterFirstNameErrorMsg;

	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement enterLastNameErrorMsg;

	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement addressErrorMsg;

	@FindBy(xpath = "//label[contains(text(),'Please Enter your 16')]")
	private WebElement entercardNo;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement enterCardType;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement enterCardMonth;

	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement enterCVV;

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement cardno;

	@FindBy(id = "cc_type")
	private WebElement cardtype;

	@FindBy(id = "cc_exp_month")
	private WebElement expmonth;

	@FindBy(id = "cc_exp_year")
	private WebElement expyear;

	@FindBy(id = "cc_cvv")
	private WebElement cvv;

	@FindBy(id = "book_now")
	private WebElement bookNow;

	public WebElement getBookHotelMsg() {
		return bookHotelMsg;
	}

	public WebElement getEnterFirstNameErrorMsg() {
		return enterFirstNameErrorMsg;
	}

	public WebElement getEnterLastNameErrorMsg() {
		return enterLastNameErrorMsg;
	}

	public WebElement getAddressErrorMsg() {
		return addressErrorMsg;
	}

	public WebElement getEntercardNo() {
		return entercardNo;
	}

	public WebElement getEnterCardType() {
		return enterCardType;
	}

	public WebElement getEnterCardMonth() {
		return enterCardMonth;
	}

	public WebElement getEnterCVV() {
		return enterCVV;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardno() {
		return cardno;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public void bookHotel(String firstname, String lastname, String address, String cardno, String cardtype,
			String expmonth, String expyear, String cvv) {

		elementSendkeys(getFirstName(), firstname);

		elementSendkeys(getLastName(), lastname);

		elementSendkeys(getAddress(), address);

		elementSendkeys(getCardno(), cardno);

		elementSendkeys(getCardtype(), cardtype);

		elementSendkeys(getExpmonth(), expmonth);

		elementSendkeys(getExpyear(), expyear);

		elementSendkeys(getCvv(), cvv);

		elementClick(bookNow);

	}

	public void bookHotelWithoutAnyFields() {

		elementClick(bookNow);

	}

}

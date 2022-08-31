package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement selectHotelMsg;
	
	@FindBy(xpath = "//label[text()='Please Select a Hotel']")
	private WebElement pleaseSelectHotel;
	

	public WebElement getPleaseSelectHotel() {
		return pleaseSelectHotel;
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnRadio;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public WebElement getSelectHotelMsg() {
		return selectHotelMsg;
	}

	public void selectHotelWithHotelName() {
		elementGetAttribute(getSelectHotelMsg());

		elementClick(btnRadio);

		elementClick(btnContinue);

	}

	public void selectHotelWithoutHotelName() {
		

		elementClick(btnContinue);

	}
}

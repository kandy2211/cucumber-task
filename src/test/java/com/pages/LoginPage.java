package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Kandasamy
 * @description used to maintain Login page webelements 
 * @date 07/09/2022
 */
public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")

	private WebElement txtUserName;

	@FindBy(id = "password")

	private WebElement txtPassword;

	@FindBy(id = "login")

	private WebElement btnLogin;

	@FindBy(xpath = "//b[contains (text(),'Invalid Login details')]")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String username, String password) {

		elementSendkeys(getTxtUserName(), username);

		elementSendkeys(getTxtPassword(), password);

		elementClick(getBtnLogin());

	}

	public void loginWithEnter(String username, String password) throws AWTException {

		elementSendkeys(getTxtUserName(), username);

		elementSendkeys(getTxtPassword(), password);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

}

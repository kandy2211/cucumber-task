package com.stepdefinition;
import org.junit.Assert;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Kandasamy
 * @description used to maintain common steps
 * @date 07/09/2022
 *
 */
public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login {string}")
	public void userShouldVerifyAfterLogin(String string) {
		
		Assert.assertEquals("verify after login msg", string, elementGetAttribute(pom.getSearchHotelPage().getWelcomemsg()));

		
		

	}

}

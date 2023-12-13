package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(partialLinkText = "Logout")
	private WebElement btnLogOut = null;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogOut() throws Exception {
		Thread.sleep(2000);
		btnLogOut.click();
	}
}

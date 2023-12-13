package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement textUserName = null;

	@FindBy(id = "password")
	private WebElement textPassword = null;

	// @FindBy(id = "Registration Desk")
	@FindBy(id = "Verwaltung")
	private WebElement lnkRegister = null;

	@FindBy(id = "loginButton")
	private WebElement btnLogin = null;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogin(String username, String password) {
		textUserName.sendKeys(username);
		textPassword.sendKeys(password);
		lnkRegister.click();
		btnLogin.click();
	}
}

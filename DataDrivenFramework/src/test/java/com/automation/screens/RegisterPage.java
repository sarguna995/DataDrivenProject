package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPage {

	@FindBy(partialLinkText = "Register a patient")
	private WebElement lnkRegister = null;

	@FindBy(name = "givenName")
	private WebElement textGivenName = null;

	@FindBy(name = "familyName")
	private WebElement textFamilyName = null;

	@FindBy(id = "next-button")
	private WebElement btnNext = null;

	@FindBy(name = "gender")
	private WebElement textGender = null;

	@FindBy(name = "birthdateDay")
	private WebElement textDate = null;

	@FindBy(name = "birthdateMonth")
	private WebElement textMonth = null;

	@FindBy(name = "birthdateYear")
	private WebElement textYear = null;

	@FindBy(id = "address1")
	private WebElement textAddress = null;

	@FindBy(id = "submit")
	private WebElement btnConfirm = null;

	@FindBy(xpath = "//em[text()='Patient ID']/../span")
	private WebElement textPatientId = null;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void registerPatientDetails(String givenName, String familyName, String gender, String date, String month,
			String year, String address) throws Exception {

		Thread.sleep(2000);
		lnkRegister.click();

		textGivenName.sendKeys(givenName);
		textFamilyName.sendKeys(familyName);
		Thread.sleep(2000);
		btnNext.click();

		textGender.sendKeys(gender);
		Thread.sleep(2000);
		btnNext.click();

		textDate.sendKeys(date);
		textMonth.sendKeys(month);
		textYear.sendKeys(year);
		Thread.sleep(2000);
		btnNext.click();

		textAddress.sendKeys(address);
		Thread.sleep(2000);
		btnNext.click();

		btnNext.click();
		btnNext.click();

		btnConfirm.click();

		Thread.sleep(5000);

		String id = textPatientId.getText();
		Reporter.log(id);
		Assert.assertNotNull(id);

		Thread.sleep(5000);

	}

}

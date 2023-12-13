package com.automation.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.RootScript;
import com.automation.helper.Excelhelper;
import com.automation.screens.LoginPage;
import com.automation.screens.LogoutPage;
import com.automation.screens.RegisterPage;

public class TC_002_CreateRecordPOM extends RootScript {

	@Test(dataProvider = "getTestData")
	public void createRecord(String username, String password, String givenName, String familyName, String gender,
			String date, String month, String year, String address) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLogin(username, password);

		RegisterPage page = new RegisterPage(driver);
		page.registerPatientDetails(givenName, familyName, gender, date, month, year, address);

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickOnLogOut();
	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {

		return Excelhelper.excelhelper("D:\\desktop1\\testdata.xlsx", "Sheet1");

	}

}

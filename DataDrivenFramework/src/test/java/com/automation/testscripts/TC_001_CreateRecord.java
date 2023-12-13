package com.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.RootScript;
import com.automation.helper.Excelhelper;

public class TC_001_CreateRecord extends RootScript {

	@Test(dataProvider = "getTestData")
	public void createRecord(String username, String password, String givenName, String familyName, String gender,
			String day, String month, String year, String address) throws Exception {

		// login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();

		Thread.sleep(2000);

		// Register
		driver.findElement(By.partialLinkText("Register a patient")).click();
		driver.findElement(By.name("givenName")).sendKeys(givenName);
		driver.findElement(By.name("familyName")).sendKeys(familyName);
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("gender")).sendKeys(gender);
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("birthdateDay")).sendKeys(day);
		driver.findElement(By.name("birthdateMonth")).sendKeys(month);
		driver.findElement(By.name("birthdateYear")).sendKeys(year);
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("address1")).sendKeys(address);
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("next-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("submit")).click();

		Thread.sleep(5000);

		WebElement patientId = driver.findElement(By.xpath("//em[text()='Patient ID']/../span"));
		String id = patientId.getText();
		Reporter.log(id);
		Assert.assertNotNull(id);
		Thread.sleep(5000);

		driver.findElement(By.partialLinkText("Logout")).click();

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {

		return Excelhelper.excelhelper("D:\\desktop1\\testdata.xlsx", "Sheet1");

	}
}

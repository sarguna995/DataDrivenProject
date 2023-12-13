package com.automation.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RootScript {

	protected WebDriver driver = null;

	// open browser

	@Parameters({"Browser"})
	@BeforeTest
	public void openBrowser(@Optional("chrome") String broswer) {

		switch (broswer) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://demo.openmrs.org/openmrs/login.htm");

	}

	// close browser

	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(2000);

		driver.quit();
	}
}

package com.rijo.maven.LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

	WebDriver driver;

	@BeforeMethod
	public void set() {

		// Basic Setup for selenium

		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");

		// opens the browser
		driver = new EdgeDriver();

		// Load url on the browser that was opened

		driver.get("https://www.google.com/");

		// Maximize the screen

		driver.manage().window().maximize();

	}

	@Test

	public void test1() {

		String titleOfThePage = driver.getTitle();

		System.out.println("The title of the page is: " + titleOfThePage);

		Assert.assertEquals(titleOfThePage, "Google", "Title doesn't match");

	}

	@AfterMethod

	public void teardown() {

		// close the browser

		driver.close();

	}
}

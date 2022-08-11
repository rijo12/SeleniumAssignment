package com.rijo.maven.LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationClass {

	WebDriver driver;

	@BeforeMethod
	public void set() {

		// Basic Setup for selenium

		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");

		// opens the browser
		driver = new EdgeDriver();

		// Load url on the browser that was opened

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// maximise the screen

		driver.manage().window().maximize();

	}

	@Test

	public void test1() {

		// We can use the below one instead of get method.

		driver.navigate().to("https://www.google.com/");

		// move back

		driver.navigate().back();

		sleep();

		// move forward

		driver.navigate().forward();
		
		sleep();

		// refresh

		driver.navigate().refresh();

	}

	@AfterMethod

	public void teardown() {

		// close the browser

		driver.close();

	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.rijo.maven.LearningSelenium;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMethodsExampleSingleClick {
	WebDriver driver;

	Actions ac;

	@BeforeMethod
	public void set() {

		// Basic Setup for selenium

		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");

		// opens the browser
		driver = new EdgeDriver();

		ac = new Actions(driver);

		// Load url on the browser that was opened

		driver.get("https://demoqa.com/buttons");

		// maximise the screen

		driver.manage().window().maximize();

	}

	@Test
	public void rightClick() {

		WebElement singleClick = driver.findElement(By.cssSelector("div.col-12.mt-4.col-md-6>div:nth-of-type(2)>div:nth-of-type(3) button"));

		ac.click(singleClick).perform();
		
		sleep();

		WebElement singleClickMessage = driver.findElement(By.id("dynamicClickMessage"));

		String singleMessage = singleClickMessage.getText();

		Assert.assertEquals(singleMessage, "You have done a dynamic click", "No Match");

	}

	public void sleep() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@AfterMethod

	public void teardown() {

		// close the browser

		driver.close();

	}

}

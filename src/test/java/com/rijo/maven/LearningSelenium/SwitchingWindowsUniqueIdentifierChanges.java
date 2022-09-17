package com.rijo.maven.LearningSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchingWindowsUniqueIdentifierChanges {
	
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

		driver.get("https://demoqa.com/browser-windows");

		// maximise the screen

		driver.manage().window().maximize();

	}
	
	@Test
	
	public void windowChange() {
		
		String parentWindow= driver.getWindowHandle();
		
		System.out.println("ParentWindow: "+parentWindow);
		
		driver.findElement(By.id("tabButton")).click();
		
//		WebDriverWait wait= new WebDriverWait(driver, 10);
//		
//		WebElement tabbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
		
		
		
		
		Set<String> windows= driver.getWindowHandles();
		
		for(String tabs :windows) {
			
			if(!tabs.equals(parentWindow)) {
				
				driver.switchTo().window(tabs);
			}
			String textFromnewTab= driver.findElement(By.id("sampleHeading")).getText();
			
			System.out.println(textFromnewTab);
			
		}
		for(String tabs1 :windows) {
			
			if(tabs1.equals(parentWindow)) {
				
				driver.switchTo().window(tabs1);
			}
		}
		Set<String> windows12=driver.getWindowHandles();
	}

	
	@AfterMethod

	public void teardown() {

		// close the browser

		driver.close();

	}

}

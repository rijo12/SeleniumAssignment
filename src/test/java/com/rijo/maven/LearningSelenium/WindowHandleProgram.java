package com.rijo.maven.LearningSelenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleProgram {
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

			driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

			// maximize the screen

			driver.manage().window().maximize();

		}

		@Test
		public void windowHandleTest() {
			
			String childWindowOne="";

			String parentWindowHandle = driver.getWindowHandle();

			System.out.println("Parent WindowHandle: " + parentWindowHandle);
			
			driver.findElement(By.id("tab Button")).click();

			Set<String> allWindowHandles = driver.getWindowHandles();
			
			for( String tabs: allWindowHandles) {
				
				if(!tabs.equals(parentWindowHandle)) {
					
					driver.switchTo().window(tabs);
					
					childWindowOne=tabs;
				}
			}
			
			WebDriverWait wait= new WebDriverWait(driver, 5);
			
			WebElement tabbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab Button")));
			
			tabbutton.click();
			
			
			allWindowHandles=driver.getWindowHandles();
			
			for (String newTab: allWindowHandles) {
				
				if(!newTab.equals(parentWindowHandle)||!newTab.equals(childWindowOne)) {
					
					driver.switchTo().window(newTab);
				}
			}

			
			String textFromSecondTab = driver.findElement(By.name("")).getText();

			System.out.println(textFromSecondTab);

		}

		@AfterMethod

		public void teardown() {

			// close the browser

			driver.close();

		}

	}

}

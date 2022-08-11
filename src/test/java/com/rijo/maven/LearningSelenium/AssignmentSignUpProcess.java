package com.rijo.maven.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentSignUpProcess {

	WebDriver driver;

	Actions ac;

	@BeforeMethod
	public void set() {

		// Basic Setup for selenium

		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");

		// opens the browser
		driver = new EdgeDriver();

		// create an object for action class with driver as input arguement
		ac = new Actions(driver);

		// Load url on the browser that was opened

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// Maximize the screen

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

	}

	@Test
	public void signUp() {

		// sign up process

		WebElement firstNameField = driver.findElement(By.id("input-firstname"));

		firstNameField.sendKeys("Anoop");

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));

		lastNameField.sendKeys("Vadakkan");

		WebElement eMailField = driver.findElement(By.id("input-email"));

		eMailField.sendKeys("anoopvadakkan@gmail.com");

		WebElement telephoneNumberField = driver.findElement(By.id("input-telephone"));

		telephoneNumberField.sendKeys("2587852110");

		WebElement passwordField = driver.findElement(By.id("input-password"));

		passwordField.sendKeys("Anoop12#");

		WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));

		passwordConfirmField.sendKeys("Anoop12#");

		WebElement newsLetterSubscribeYes = driver.findElement(By.cssSelector("label.radio-inline input"));

		ac.click(newsLetterSubscribeYes).perform();

		WebElement privacyPolicyCheck = driver.findElement(By.cssSelector("div.buttons input"));

		ac.click(privacyPolicyCheck).perform();

		WebElement continueButton = driver.findElement(By.cssSelector("div.buttons input.btn"));

		continueButton.click();

	}

	@Test
	public void purchase() {
		// Login using registered email and password

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		WebElement myAccountClick = driver
				.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(2) a span.hidden-xs"));

		ac.click(myAccountClick).perform();

		WebElement loginClick = driver
				.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(2) ul >li:nth-of-type(2) a"));

		ac.click(loginClick).perform();

		WebElement eMailLoginField = driver.findElement(By.cssSelector("div.form-group #input-email"));

		eMailLoginField.sendKeys("anoopvadakkan@gmail.com");

		WebElement passwordLoginField = driver.findElement(By.cssSelector("div.form-group #input-password"));

		passwordLoginField.sendKeys("Anoop12#");

		driver.findElement(By.cssSelector("input.btn.btn-primary")).submit();

		// Purchase two phones from the website

		WebElement purchasePhone = driver.findElement(By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(6) a"));

		ac.click(purchasePhone).perform();

		WebElement purchasePhoneHTC = driver.findElement(By.cssSelector("div.caption a"));

		ac.click(purchasePhoneHTC).perform();

		WebElement purchasePhoneHTCAddToCart = driver.findElement(By.id("button-cart"));

		ac.click(purchasePhoneHTCAddToCart).perform();

		driver.navigate().back();

		WebElement purchaseIPhone = driver
				.findElement(By.cssSelector("div.col-sm-9>div:nth-of-type(2)>div:nth-of-type(2) div.caption a"));

		ac.click(purchaseIPhone).perform();

		WebElement purchaseIPhoneAddToCart = driver.findElement(By.id("button-cart"));

		ac.click(purchaseIPhoneAddToCart).perform();

		WebElement cartClick = driver.findElement(By.id("cart-total"));

		ac.click(cartClick).perform();

		WebElement viewCart = driver
				.findElement(By.cssSelector("ul.dropdown-menu.pull-right li:nth-of-type(2) a strong"));

		ac.click(viewCart).perform();

		driver.findElement(By.cssSelector("div.buttons.clearfix div.pull-right a")).click();

		// Billing details

		WebElement firstNameFieldBilling= driver.findElement(By.cssSelector("#input-payment-firstname"));
		
		firstNameFieldBilling.sendKeys("Anoop");
		
		WebElement lastNameFieldBilling= driver.findElement(By.cssSelector("#input-payment-lastname"));
		
		lastNameFieldBilling.sendKeys("Vadakkan");
		
		WebElement companyFieldBilling= driver.findElement(By.cssSelector("#input-payment-company"));
		
		companyFieldBilling.sendKeys("ABC");
		
		WebElement addressField1Billing= driver.findElement(By.cssSelector("#input-payment-address-1"));
		
		addressField1Billing.sendKeys("Camp field");
		
		WebElement cityFieldBilling= driver.findElement(By.cssSelector("#input-payment-city"));
		
		cityFieldBilling.sendKeys("Toronto");
		
		WebElement postCodeFieldBilling= driver.findElement(By.cssSelector("#input-payment-postcode"));
		
		postCodeFieldBilling.sendKeys("M6T 5P7");
		
		// Creating the select class to select one option from dropdown window
		
		Select countryDropDownSelect= new Select(driver.findElement(By.cssSelector("#input-payment-country")));
		
		countryDropDownSelect.selectByValue("38");
		
		Select regionDropDownSelect= new Select(driver.findElement(By.cssSelector("#input-payment-zone")));
		
		regionDropDownSelect.selectByValue("610");
		

		driver.findElement(By.id("button-payment-address")).click();

		driver.findElement(By.id("button-shipping-address")).click();

		driver.findElement(By.id("button-shipping-method")).click();

		sleep();

		driver.findElement(By.cssSelector("#collapse-payment-method div:nth-of-type(2) input")).click();

		driver.findElement(By.id("button-payment-method")).click();

		driver.findElement(By.id("button-confirm")).click();

		WebElement placedOrderPosition = driver.findElement(By.cssSelector("#common-success>div div h1"));

		String placedOrderMessage = placedOrderPosition.getText();

		Assert.assertEquals(placedOrderMessage, "Your order has been placed!", "Order Not Placed");

		WebElement myAccount = driver.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(2) span"));

		ac.click(myAccount).perform();

		// Log Out

		WebElement logout = driver.findElement(By.cssSelector("ul.list-inline li:nth-of-type(5) a"));

		ac.click(logout).perform();

		WebElement logOutM = driver.findElement(By.cssSelector("#common-success #content h1"));

		String logOutMessage = logOutM.getText();

		Assert.assertEquals(logOutMessage, "Account Logout", "Not Successfully Logged Out");

	}

	public void sleep() {
		try {
			Thread.sleep(5000);
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

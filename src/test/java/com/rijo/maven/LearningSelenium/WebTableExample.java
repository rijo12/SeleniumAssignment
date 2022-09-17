package com.rijo.maven.LearningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableExample {
	
	WebDriver driver;
	
	@BeforeMethod
	public void set() {

		// Basic Setup for selenium

		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");

		// opens the browser
		driver = new EdgeDriver();


		// Load url on the browser that was opened

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// maximise the screen

		driver.manage().window().maximize();

	}
	@Test
	
//	public void WebtableExample() {
		
//		List<WebElement> noOfRows= driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
//		
//		List<WebElement> noOfColumns= driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//th"));
//		
//		System.out.println("no.of rows: "+noOfRows.size());
//		
//		System.out.println("no.of columns: "+noOfColumns.size());
//		
//		String xPathBefore="//table[@id='customers']//tbody//tr[";
//		
//		String xPathAfter="]//td[";
//		
//		for(int i=2;i<=noOfRows.size();i++) {
//			
//			for(int j=1;j<=noOfColumns.size();j++) {
//				
//				WebElement element= driver.findElement(By.xpath(xPathBefore+i+xPathAfter+j+"]"));
//				
//		//		System.out.println(element.getText());
//				
//				if(element.getText().equals("India")) {
//					
//					System.out.println("India is Present");
//				}
//				
//			}
//			
//		}
//		
//		
//	}
//	
		
		public void webTableTest2() {
			WebElement element = getCellFromCustomerTable("Island Trading", Table_example.CONTACT);
			System.out.println(element.getText());
		}
			public WebElement getCellFromCustomerTable(String companyName, Table_example column) {

				int columnIndex = getIndexForColumn(column);
				int companyColumnIndex = getIndexForColumn(Table_example.COMPANY);

				if (columnIndex < 0) {
					return null;
				}
				//finding rows
				List<WebElement> rows = driver.findElements(By.cssSelector("table[class='ws-table-all'] tr"));
//iterating over rows to get the cells by tag name td
				
				for (int i = 1; i < rows.size(); i++) {
					List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
					if (cells.size() < columnIndex || cells.size() < companyColumnIndex) {
						continue;
					}
					//get the first value using row 
					// starting from leftmost column
					String[] devicesIds = cells.get(companyColumnIndex).getText().split("\n");
					
					
					for (int j = 0; j < devicesIds.length; j++) {
						if (devicesIds[j].equals(companyName)) {
							
							//here returning the repective value using column index already found
							return cells.get(columnIndex);
						}
					}

			}

				System.out.println(String.format("Can't find row, which contains Company name = %s", companyName));

				return null;

			}

			private int getIndexForColumn(Table_example column) {
				List<WebElement> headers = null;

				headers = driver.findElements(By.cssSelector("div.table-responsive>table>thead>tr td"));
				for (WebElement header : headers) {
					if (column.getText().equals(header.getText())) {
						return headers.indexOf(header);

					}
				}

				return -1;
			}

			public enum Table_example {
				COMPANY("Company"), 
				CONTACT("Contact"), 
				COUNTRY("Country");

				private String value;

				Table_example(String value) {
					this.value = value;
				}

				public String getText() {
					return value;
				}

			}

	@AfterMethod

	public void teardown() {

		// close the browser

		driver.close();

	}

}

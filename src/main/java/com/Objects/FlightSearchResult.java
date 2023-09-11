package com.Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class FlightSearchResult extends ActionWeb {

	WebDriver driver;

	public FlightSearchResult(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void printList() {
		waiting(driver.findElement(By.xpath("//div[@class='cntnt ']")));
		List<WebElement> pricesList = driver
				.findElements(By.xpath("//div[@class='price']//span[2]"));
		for (WebElement webElement : pricesList) {
			String price = webElement.getText();
			System.out.println(price);
		}
		System.out.println("Size of the price list is : " + pricesList.size());
	}

}

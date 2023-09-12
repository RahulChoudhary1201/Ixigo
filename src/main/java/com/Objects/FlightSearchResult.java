package com.Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class FlightSearchResult extends ActionWeb {

	private WebDriver driver;

	public FlightSearchResult(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private By bookBtn = By.xpath("(//button[@class='c-btn u-link  enabled'][contains(text(),'Book')])[1]");
	
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getFlightsDetails() {
		waiting(driver.findElement(By.xpath("//div[@class='cntnt ']")));
		List<WebElement> pricesList = driver
				.findElements(By.xpath("//div[@class='price']//span[2]"));
		ArrayList<String> arr = new ArrayList<String>();
		for (WebElement webElement : pricesList) {
			String price = webElement.getText();
			arr.add(price);
		}
		Collections.sort(arr);
		return arr.get(0);
	}
	
	public FlightBooking bookFlight() {
		driver.findElement(bookBtn).click();
		waitingForTitle("Review Flight Details");
		return new FlightBooking(driver);
		
		
	}
}

package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ActionWeb;

public class FlightBooking extends ActionWeb {

	private WebDriver driver;

	public FlightBooking(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By flightName = By.xpath("//div[@class='info']");
	private By duration = By.xpath("//div[@class='duration']");
	private By flightDelay = By.xpath("//div[contains(@class,'delay-info')]");
	private By totalFare = By.xpath(
			"(//div[@class='c-price-display u-text-ellipsis ']/span)[6]");
	private By continueBooking = By.xpath("(//div[@class='u-ripple'])[2]");
	private By errorMsg = By.xpath("//div[@class='form-error-msg']");

	public String getTitle() {
		return driver.getTitle();
	}

	public String getFlightName() {
		return driver.findElement(flightName).getText();
	}

	public String getFlightDuration() {
		return driver.findElement(duration).getText();
	}

	public String getFlightDelay() {
		return driver.findElement(flightDelay).getText();
	}

	public String getTotalPrice() {
		return driver.findElement(totalFare).getText();
	}

	public String getErrorMsg() {
		return driver.findElement(errorMsg).getText();
	}

	public void continueBookBtn() {
		driver.findElement(continueBooking).click();
		login();
	}
}

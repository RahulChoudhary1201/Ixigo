package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class TrainBooking extends ActionWeb {

	private WebDriver driver;

	public TrainBooking(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By srcTextInput = By.xpath("//input[@placeholder='Leaving from']");
	private By suggestedEle = By.xpath(
			"(//div[contains(@class,'result-row train-station u-box-result')  and @data-acindex='0'])[1]");
	private By destTextInput = By.xpath("//input[@placeholder='Going to']");
	private By suggDestEleXpath = By.xpath(
			"(//div[contains(@class,'result-row train-station u-box-result')  and @data-acindex='0'])[2]");
	private By clearBtn = By
			.xpath("//div[@class='clear-input ixi-icon-cross']");
	private By searchBtn = By.xpath("//button[contains(text(),'Search')]");

	public String getTrainPageTitle() {
		waitingForTitle("Train Ticket Booking Online, Use IRCTC Login | ixigo");
		return driver.getTitle();
	}

	public void setSrcAndDest(String src, String dest)
			throws InterruptedException {
		driver.findElement(clearBtn).click();
		driver.findElement(srcTextInput).sendKeys(src);
		waiting(driver.findElement(suggestedEle));
		Thread.sleep(1000);
		WebElement suggSrc = driver.findElement(suggestedEle);
		if (suggSrc.isDisplayed()) {
			suggSrc.click();
		}
		driver.findElement(destTextInput).sendKeys(dest);
		waiting(driver.findElement(suggDestEleXpath));
		Thread.sleep(1000);
		WebElement suggDest = driver.findElement(suggDestEleXpath);
		if (suggDest.isDisplayed()) {
			suggDest.click();
		}
	}

	public TrainSearchResult searchClick() {
		driver.findElement(searchBtn).click();
		return new TrainSearchResult(driver);
	}

}

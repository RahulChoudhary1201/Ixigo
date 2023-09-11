package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class HomePage extends ActionWeb {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By src = By
			.xpath("(//input[@placeholder='Enter city or airport'])[1]");
	private By dest = By
			.xpath("(//input[@placeholder='Enter city or airport'])[2]");
	private By searchBtn = By.xpath(
			"//button[normalize-space()='Search']//div[@class='u-ripple']");
	private By clearBtn = By
			.xpath("(//div[@class='clear-input ixi-icon-cross'])[1]");
	private By suggestedEle = By.xpath("(//div[@data-acindex='0'])[1]");
	private By sEleDestination = By.xpath("(//div[@data-acindex='0'])[2]");
	private By monthYear = By.xpath("//div[@class='rd-month-label']");
	private By nextBtn = By.xpath("//button[@class='ixi-icon-arrow rd-next']");
	private By passNumber = By.xpath(
			"//span[contains(@class,'counter-item u-text-center u-ib')  and @data-val='2']");
	private By className = By.cssSelector(".radio-list-item[data-index='1']");

	public String getTitle() {
		return driver.getTitle();
	}

	public void setSourceAndDest(String source, String destination)
			throws InterruptedException {
		driver.findElement(clearBtn).click();
		Type(driver.findElement(src), source);
		waiting(driver.findElement(suggestedEle));
		driver.findElement(suggestedEle).click();
		Type(driver.findElement(dest), destination);
		Thread.sleep(1000);
		driver.findElement(sEleDestination).click();
	}

	public void setDate(String day, String monthInput, String year) {
		while (true) {
			WebElement monYr = driver.findElement(monthYear);
			String monYrText = monYr.getText();
			String[] month = monYrText.split(" ");
			String monthText = month[0];
			String yearText = month[1];

			if (monthText.equalsIgnoreCase(monthInput)
					&& yearText.equalsIgnoreCase(year)) {
				break;
			} else {
				driver.findElement(nextBtn).click();
			}

		}
		WebElement dayEle = driver.findElement(By.xpath(
				"//div[@class='day has-info' and text()='" + day + "']"));
		dayEle.click();
	}

	public FlightSearchResult setPassAndClass() {
		waiting(driver.findElement(passNumber));
		driver.findElement(passNumber).click();
		driver.findElement(className).click();
		driver.findElement(searchBtn).click();
		return new FlightSearchResult(driver);
	}

}

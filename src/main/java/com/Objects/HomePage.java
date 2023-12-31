package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	private By passNumber = By.xpath(
			"//span[contains(@class,'counter-item u-text-center u-ib')  and @data-val='2']");
	private By className = By.cssSelector(".radio-list-item[data-index='1']");
	private By offersIcon = By.xpath("//a[@href='/offers']");
	private By helpCenter = By.xpath("(//a[@href='/help-center'])[1]");
	private By trainIcon = By.xpath("//a[@href='/trains']");
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void setSourceAndDest(String source, String destination)
			throws InterruptedException {
		driver.findElement(clearBtn).click();
		Type(driver.findElement(src), source);
		waiting(driver.findElement(suggestedEle));
		Thread.sleep(1000);
		driver.findElement(suggestedEle).click();
		Type(driver.findElement(dest), destination);
		Thread.sleep(1000);
		driver.findElement(sEleDestination).click();
	}

	public FlightSearchResult setPassAndClass() {
		waiting(driver.findElement(passNumber));
		driver.findElement(passNumber).click();
		driver.findElement(className).click();
		driver.findElement(searchBtn).click();
		return new FlightSearchResult(driver);
	}

	public OffersPage navigatingToOffersPage() {
		try {
			navigateToHome();
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(offersIcon).click();
		return new OffersPage(driver);

	}
	
	public CustomerServicePage navigateToCustomerService() {
		try {
			navigateToHome();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(helpCenter).click();
		return new CustomerServicePage(driver);
		
	}
	
	public TrainBooking navigateToTrains() {
		try {
			navigateToHome();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(trainIcon).click();
		return new TrainBooking(driver);
	}

}

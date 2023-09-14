package com.Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class OffersPage extends ActionWeb{
	
	private WebDriver driver;
	
	
	public OffersPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	private By allOfferHeading = By.xpath("//div[@class='post-list']//h2/a");
	private static List<WebElement> offerList;
	
	public String getOfferPageTitle() {
		return driver.getTitle();
	}
	public int getTotalNumberOfOffers() {
		offerList = driver.findElements(allOfferHeading);
		return offerList.size();
	}
	
	public void displayOffersName() {
		int i=1;
		offerList = driver.findElements(allOfferHeading);
		for (WebElement webElement : offerList) {
			String text = webElement.getText();
			System.out.println(i+". Offer's Name: "+text);
			i++;
		}
	}
	
	
}

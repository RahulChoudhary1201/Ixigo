package com.Objects;

import java.io.IOException;
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
	
	public void displayOffersName() throws IOException, InterruptedException {
		int i=1;
		WebElement allOffers = driver.findElement(By.xpath("//div[@class='post-list']"));
		scrollingToWebElement(allOffers);
		takeScreenShots(allOffers,allOffers.getAttribute("class"));
		offerList = driver.findElements(allOfferHeading);
		for (WebElement webElement : offerList) {
			String text = webElement.getText();
			System.out.println(i+". Offer's Name: "+text);
			i++;
		}
	}
	
	
}

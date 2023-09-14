package com.Objects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class CustomerServicePage extends ActionWeb {
	private WebDriver driver;
	
	private By servicesIcon = By.xpath("//div[@class='home-menu']");
	private By aboutHeading = By.xpath("//div[@class='about-heading']");
	private By questionListXpath = By.xpath("//div[@class='item-question']");
	private By answerXpath = By.xpath("//div[@class='item-answer']");
	
	
	public CustomerServicePage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	public String getTitle() {
		waitingForTitle("ixigo Customer Care Service | Chat or Call Based Support for Flight, Train, Bus Booking Related Queries");
		return driver.getTitle();
	}
	
	public void verifyCustServicesIcons() throws IOException {
		WebElement sIcons= driver.findElement(servicesIcon);
		takeScreenShots(sIcons, sIcons.getAttribute("class"));
	}
	
	public void verifyFAQs() {
		scrollingToWebElement(driver.findElement(aboutHeading));
		List<WebElement> questions = driver.findElements(questionListXpath);
		for(int i=0;i<questions.size();i++) {
			questions.get(i).click();
			WebElement ans = driver.findElement(answerXpath);
			if(ans.isDisplayed()) {
				continue;
			}
		}
	}
	
}

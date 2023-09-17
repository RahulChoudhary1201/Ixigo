package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ActionWeb;

public class TrainSearchResult extends ActionWeb {
	private WebDriver driver;
	public TrainSearchResult(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private By coachClass3A = By.xpath("//div[@class='checkbox-list-item ']/span[text()='3A']");
	private By quotaXPath = By.xpath("//div[@class='radio-list-item  ']/span[text()='Lower Berth']");
	private By trainNamesXpath = By.xpath("//div[@class='name-number']"); //-> list
	private By trainClassXpath = By.xpath("//div[contains(@class,'train-class-main')]/div/span[@class='train-class']");//-> list
	private By trainTimingDate = By.xpath("//div[@class='train-status-main']/div[@class='train-timing margin']"); //->list
	private By availSeats = By.xpath("//div[@class='train-status-main']/div[contains(text(),'AVL')]"); // -> list
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void selectTrain() {
		waiting(driver.findElement(trainNamesXpath));
		driver.findElement(coachClass3A).click();
		waiting(driver.findElement(trainNamesXpath));
		driver.findElement(quotaXPath).click();
		waiting(driver.findElement(trainNamesXpath));
		driver.findElement(trainClassXpath).click();
		
		
		
	}
	
}

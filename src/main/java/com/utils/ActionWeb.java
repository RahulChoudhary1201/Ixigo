package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWeb {
	private static WebDriver driver;

	public ActionWeb(WebDriver driver) {
		ActionWeb.driver = driver;
	}

	public void Type(WebElement webElement, String text) {
		webElement.sendKeys(text);
	}

	public void waiting(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitingForTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void navigateToHome() {
		driver.navigate().to("https://www.ixigo.com/");
		waitingForTitle("ixigo - Best Travel Website, Book Flights, Trains & Buses Online");
	}
	
}

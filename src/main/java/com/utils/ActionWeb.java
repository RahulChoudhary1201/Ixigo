package com.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
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
	
	public void takeScreenShots(WebElement ele,String name) throws IOException {
		File source=ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png"));
	}
	
	public void scrollingToWebElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}

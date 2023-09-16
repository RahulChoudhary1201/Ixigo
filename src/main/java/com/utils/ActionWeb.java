package com.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWeb {
	private static WebDriver driver;
	protected Logger log = LogManager.getLogger(getClass());
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
		waitingForTitle(
				"ixigo - Best Travel Website, Book Flights, Trains & Buses Online");
	}

	public void takeScreenShots(WebElement ele, String name)
			throws IOException {
		File source = ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")
				+ "\\ScreenShots\\" + name + ".png"));
	}

	public void scrollingToWebElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getErrorMsg() {
		return driver.findElement(By.xpath("//div[@class='form-error-msg']"))
				.getText();
	}
	public void login() {
		waiting(driver.findElement(
				By.xpath("//input[@class='c-input u-v-align-bottom']")));
		driver.findElement(
				By.xpath("//input[@class='c-input u-v-align-bottom']"))
				.sendKeys("1234567890");

		try {
			WebElement loginBtn = driver.findElement(
					By.xpath("//div[@class='login-button']/button"));
			if (loginBtn.isEnabled()) {
				loginBtn.click();
				try {
					if (driver
							.findElement(
									By.xpath("//div[@class='form-error-msg']"))
							.isDisplayed()) {
						return;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				waiting(driver.findElement(
						By.xpath("//div[@class='otp-input-group']")));
				for (int i = 0; i < 6; i++) {
					driver.findElement(By.xpath("//input[@id='otp-" + i + "']"))
							.sendKeys("" + i + "");
				}
				waiting(driver.findElement(
						By.xpath("//div[@class='form-error-msg']")));
			}
		} catch (Exception e) {
			System.out.println("Login Failed");
		} finally {
			System.out.println("Login failed because " + getErrorMsg());
		}

	}
	public void setDate(String day, String monthInput, String year) {
		while (true) {
			WebElement monYr = driver
					.findElement(By.xpath("//div[@class='rd-month-label']"));
			String monYrText = monYr.getText();
			String[] month = monYrText.split(" ");
			String monthText = month[0];
			String yearText = month[1];

			if (monthText.equalsIgnoreCase(monthInput)
					&& yearText.equalsIgnoreCase(year)) {
				break;
			} else {
				driver.findElement(
						By.xpath("//button[@class='ixi-icon-arrow rd-next']"))
						.click();
			}

		}
		WebElement dayEle = driver.findElement(
				By.xpath("(//div[contains(@class,'day')][contains(text(),'"
						+ day + "')])[1]"));
		dayEle.click();
	}

}

package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ActionWeb;

public class FlightBooking extends ActionWeb{

	private WebDriver driver;

	public FlightBooking(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private By flightName = By.xpath("//div[@class='info']");
	private By duration = By.xpath("//div[@class='duration']");
	private By flightDelay = By.xpath("//div[@class='delay-info on-time']");
	private By totalFare = By.xpath("(//div[@class='c-price-display u-text-ellipsis ']/span)[6]");
	private By continueBooking = By.xpath("(//div[@class='u-ripple'])[2]");
	private By errorMsg = By.xpath("//div[@class='form-error-msg']");
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getFlightName() {
		return driver.findElement(flightName).getText();
	}

	public String getFlightDuration() {
		return driver.findElement(duration).getText();
	}
	
	public String getFlightDelay() {
		return driver.findElement(flightDelay).getText();
	}
	
	public String getTotalPrice() {
		return driver.findElement(totalFare).getText();
	}
	
	public String getErrorMsg() {
		return driver.findElement(errorMsg).getText();
	}
	
	public void continueBookBtn() {
		driver.findElement(continueBooking).click();
		waiting(driver.findElement(By.xpath("//input[@class='c-input u-v-align-bottom']")));
		driver.findElement(By.xpath("//input[@class='c-input u-v-align-bottom']")).sendKeys("1234567890");
		WebElement loginBtn=driver.findElement(By.xpath("//div[@class='login-button']/button"));
		if(loginBtn.isEnabled()) {
			loginBtn.click();
		}
		try {
			waiting(driver.findElement(By.xpath("//div[@class='otp-input-group']")));
			for (int i = 0; i < 6; i++) {
				driver.findElement(By.xpath("//input[@id='otp-" + i + "']"))
						.sendKeys("" + i + "");
			}
			waiting(driver.findElement(By.xpath("//div[@class=\"form-error-msg\"]")));
			String text = getErrorMsg();
			System.out.println(text);
			
			
		} catch (Exception e) {
			System.out.println("Login Failed");
		}
		finally {
			String msg = getErrorMsg();
			System.out.println(msg);
		}
		
	}
}

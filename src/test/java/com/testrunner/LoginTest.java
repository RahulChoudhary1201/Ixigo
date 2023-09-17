package com.testrunner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.utils.ActionWeb;

//This is for testing the classes and methods
public class LoginTest extends BaseClass {
	By errorMsg = By.xpath("//div[@class='form-error-msg']");
	public String getErrorMsg() {
		return driver.findElement(errorMsg).getText();
	}
	@Test
	public void clickOnLogin() throws InterruptedException {
		ActionWeb aw = new ActionWeb(driver);
		driver.findElement(By.xpath("//span[@class='login-txt']")).click();
		aw.login();

	}

}

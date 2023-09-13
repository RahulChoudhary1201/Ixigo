package com.testrunner;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.utils.ActionWeb;

public class LoginTest extends BaseClass {

	@Test
	public void clickOnLogin() throws InterruptedException {
		ActionWeb aw = new ActionWeb(driver);
		driver.findElement(By.xpath("//span[@class='login-txt']")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);
		}
		aw.waiting(driver.findElement(
				By.xpath("//input[@class='c-input u-v-align-bottom']")));
		
		

		

		
		
	}

}

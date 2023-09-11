package com.testrunner;

import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.baseclass.BaseClass;

public class HomePageTest extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.setSourceAndDest("mumbai", "Raipur");
		hp.setDate("22","December","2023");
		hp.setPassAndClass();
		Thread.sleep(3000);
	}

}

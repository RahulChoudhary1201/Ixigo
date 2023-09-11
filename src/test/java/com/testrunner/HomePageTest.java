package com.testrunner;

import org.testng.annotations.Test;

import com.Objects.FlightSearchResult;
import com.Objects.HomePage;
import com.baseclass.BaseClass;

public class HomePageTest extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.setSourceAndDest("mumbai", "Goa");
		hp.setDate("22", "December", "2023");
		FlightSearchResult fsr = hp.setPassAndClass();
		fsr.printList();
		Thread.sleep(3000);
	}

}

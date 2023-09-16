package com.testrunner;

import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.Objects.TrainBooking;
import com.baseclass.BaseClass;

public class TrainBookingTest extends BaseClass{
	
	@Test(dependsOnGroups = {"offer"}, groups = {"train"})
//	@Test
	public void srcAnddestSettingTest() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		TrainBooking tb= hp.navigateToTrains();
		String title = tb.getTrainPageTitle();
		System.out.println(title);
		tb.setSrcAndDest("Pune", "Durg");
		tb.setDate("22", "December", "2023");
		tb.searchClick();
		Thread.sleep(5000);
	}

}

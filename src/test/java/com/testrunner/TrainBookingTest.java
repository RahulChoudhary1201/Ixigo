package com.testrunner;

import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.Objects.TrainBooking;
import com.Objects.TrainSearchResult;
import com.baseclass.BaseClass;

public class TrainBookingTest extends BaseClass {
	TrainSearchResult tsr;
	@Test(dependsOnGroups = {"offer"}, groups = {"train"})
//	 @Test
	public void srcAnddestSettingTest() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		TrainBooking tb = hp.navigateToTrains();
		String title = tb.getTrainPageTitle();
		System.out.println(title);
		tb.setSrcAndDest("Pune", "Durg");
		tb.setDate("22", "December", "2023");
		tsr = tb.searchClick();
	}
	
	@Test(dependsOnMethods = {"srcAnddestSettingTest"})
	public void trainSearch() throws InterruptedException {
		String title = tsr.getTitle();
		System.out.println(title);
		tsr.selectTrain();
		Thread.sleep(2000);
	}

}

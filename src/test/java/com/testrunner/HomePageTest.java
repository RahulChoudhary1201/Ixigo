package com.testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Objects.FlightBooking;
import com.Objects.FlightSearchResult;
import com.Objects.HomePage;
import com.baseclass.BaseClass;
import com.utils.ActionWeb;

public class HomePageTest extends BaseClass {

	FlightSearchResult fsr;
	FlightBooking fb;

	@Test(priority = 0)
	public void test1() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		String homeTitle = hp.getTitle();
		Assert.assertEquals(homeTitle,
				"ixigo - Best Travel Website, Book Flights, Trains & Buses Online");
		hp.setSourceAndDest("mumbai", "Goa");
		hp.setDate("22", "December", "2023");
		fsr = hp.setPassAndClass();
	}

	@Test(priority = 1)
	public void test2() {
		ActionWeb aw = new ActionWeb(driver);
		aw.waitingForTitle("Pune - Goa, Business Flights, 22 Dec");
		String flightTitle = fsr.getTitle();
		Assert.assertEquals(flightTitle,
				"Pune - Goa, Business Flights, 22 Dec");
		String flight = fsr.getFlightsDetails();
		System.out.println("Cheapest flight we Found is: " + flight);
	}
	@Test(priority = 2)
	public void test3() {
		fb = fsr.bookFlight();
		String fbTitle=fb.getTitle();
		System.out.println("Got the Page Title: "+fbTitle);
		String flightName = fb.getFlightName();
		System.out.println("Flight Name: "+flightName);
		String duration = fb.getFlightDuration();
		System.out.println("Flights Duration: "+duration);
		String fDelay=fb.getFlightDelay();
		System.out.println("Flights Delay: "+fDelay);
		String totalPrice = fb.getTotalPrice();
		System.out.println("Total Price of flight: "+totalPrice);
		fb.continueBookBtn();
	}

}

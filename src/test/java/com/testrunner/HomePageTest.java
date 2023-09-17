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

	@Test( groups="flight")
	public void EnteringDetailsTest() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		log.info("Getting the Home page title.");
		String homeTitle = hp.getTitle();
		Assert.assertEquals(homeTitle,
				"ixigo - Best Travel Website, Book Flights, Trains & Buses Online");
		log.info("Title Verified");
		log.info("Setting source and destination.");
		hp.setSourceAndDest("mumbai", "Goa");
		log.info("Setting up date.");
		hp.setDate("22", "December", "2023");
		log.info("Setting the Passenger number and Class for travelling.");
		fsr = hp.setPassAndClass();
		log.info("Clicked on search button.");
	}

	@Test(dependsOnMethods = {"EnteringDetailsTest"},groups="flight")
	public void CheapestFlightTest() {
		ActionWeb aw = new ActionWeb(driver);
		log.info("Waiting for flight page title");
		aw.waitingForTitle("Mumbai - Goa, Business Flights, 22 Dec");
		log.info("Getting FlightsPage title.");
		String flightTitle = fsr.getTitle();
		Assert.assertEquals(flightTitle,
				"Mumbai - Goa, Business Flights, 22 Dec");
		log.info("Title verified");
		log.info("Getting flights details");
		String flight = fsr.getFlightsDetails();
		System.out.println("Cheapest flight we Found is: " + flight);
		log.info("Found the cheapest flight.");
	}
	@Test(dependsOnMethods = {"CheapestFlightTest"},groups="flight")
	public void BookingFlightTest() {
		log.info("Clicked on book flight Button.");
		fb = fsr.bookFlight();
		log.info("Getting the title of Flight booking page.");
		String fbTitle=fb.getTitle();
		log.info("Printing the title of page.");
		System.out.println("Got the Page Title: "+fbTitle);
		log.info("Getting Flight Name.");
		String flightName = fb.getFlightName();
		log.info("Printing flight name to console.");
		System.out.println("Flight Name: "+flightName);
		log.info("Getting flights duration.");
		String duration = fb.getFlightDuration();
		log.info("Printing duration to console.");
		System.out.println("Flights Duration: "+duration);
		log.info("Getting flight delay.");
		String fDelay=fb.getFlightDelay();
		log.info("Printing flights delay.");
		System.out.println("Flights Delay: "+fDelay);
		log.info("Getting total flight price.");
		String totalPrice = fb.getTotalPrice();
		log.info("Printing total price of flight.");
		System.out.println("Total Price of flight: "+totalPrice);
		log.info("Clicking continue button.");
		fb.continueBookBtn();
		log.info("Trying to login.");
	}

}

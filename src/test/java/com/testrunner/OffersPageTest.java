package com.testrunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.Objects.OffersPage;
import com.baseclass.BaseClass;

public class OffersPageTest extends BaseClass {

	@Test(dependsOnGroups = {"flight"}, groups="offer")
	public void OfferDetailsTest() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		log.info("Navigating to Offers Page.");
		OffersPage ofp = hp.navigatingToOffersPage();
		log.info("Getting the title of Offers Page.");
		String offerPageTitle = ofp.getOfferPageTitle();
		log.info("Verifying the title");
		Assert.assertEquals(offerPageTitle, "ixigo Offers, Coupons, Latest ixigo Offers in 2023 - ixigo.com");
		log.info("Printing the information about Offers.");
		System.out.println("Total Number of offer's displayed: "+ofp.getTotalNumberOfOffers());
		ofp.displayOffersName();
		log.info("Offer Displayed to console Successfully.");
	}

}

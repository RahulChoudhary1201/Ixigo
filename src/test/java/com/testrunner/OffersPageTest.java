package com.testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.Objects.OffersPage;
import com.baseclass.BaseClass;

public class OffersPageTest extends BaseClass {

	@Test(dependsOnGroups = {"flight"})
	public void OfferDetailsTest() {
		HomePage hp = new HomePage(driver);
		OffersPage ofp = hp.navigatingToOffersPage();
		String offerPageTitle = ofp.getOfferPageTitle();
		Assert.assertEquals(offerPageTitle, "ixigo Offers, Coupons, Latest ixigo Offers in Sept 2023 - ixigo.com");
		System.out.println("Total Number of offer's displayed: "+ofp.getTotalNumberOfOffers());
		ofp.displayOffersName();
	}

}

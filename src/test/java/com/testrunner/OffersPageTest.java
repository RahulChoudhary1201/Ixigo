package com.testrunner;

import org.testng.annotations.Test;

import com.Objects.HomePage;
import com.Objects.OffersPage;
import com.baseclass.BaseClass;

public class OffersPageTest extends BaseClass {

	@Test
	public void OfferDetailsTest() {
		HomePage hp = new HomePage(driver);
		OffersPage ofp = hp.navigatingToOffersPage();
		System.out.println("Title: "+ driver.getTitle());
	}

}

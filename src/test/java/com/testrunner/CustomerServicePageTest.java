package com.testrunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Objects.CustomerServicePage;
import com.Objects.HomePage;
import com.baseclass.BaseClass;

public class CustomerServicePageTest extends BaseClass {

	@Test(dependsOnGroups  = {"offer"},groups = {"offer"})
	public void VerifyService() throws IOException {
		HomePage hp = new HomePage(driver);
		log.info("Navigating to Customer Service Page.");
		CustomerServicePage csp = hp.navigateToCustomerService();
		log.info("Getting the title of Customer Service Page");
		String title = csp.getTitle();
		log.info("Title Verifying");
		Assert.assertEquals(title, "ixigo Customer Care Service | Chat or Call Based Support for Flight, Train, Bus Booking Related Queries");
		log.info("Title Verified");
		log.info("Taking Screenshot of Icons");
		csp.verifyCustServicesIcons();
		log.info("SS Successfull.");
		log.info("Verifying the All the questions by opening each one.");
		csp.verifyFAQs();
		log.info("Questions Verified.");
	}

}

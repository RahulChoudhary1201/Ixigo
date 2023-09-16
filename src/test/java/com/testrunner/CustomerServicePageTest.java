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
		CustomerServicePage csp = hp.navigateToCustomerService();
		String title = csp.getTitle();
		Assert.assertEquals(title, "ixigo Customer Care Service | Chat or Call Based Support for Flight, Train, Bus Booking Related Queries");
		csp.verifyCustServicesIcons();
		csp.verifyFAQs();
	}

}

package com.Objects;

import org.openqa.selenium.WebDriver;

import com.utils.ActionWeb;

public class OffersPage extends ActionWeb{
	
	private WebDriver driver;
	
	public OffersPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}

}

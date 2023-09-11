package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String name, String url) {
		switch (name) {
			case "chrome" :
				driver = initChromeDriver(url);
				break;

			case "edge" :
				driver = initEdgeDriver(url);
				break;
			case "firefox" :
				driver = initFireFoxDriver(url);
				break;
			default :
				System.out.println("Cannot Invoke " + name
						+ " browser, Invoking ChromeDriver...");
				driver = initChromeDriver(url);
		}
	}
	private static WebDriver initChromeDriver(String url) {
		System.out.println("Invoking ChromeDriver with new profile...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;

	}
	private static WebDriver initEdgeDriver(String url) {
		System.out.println("Invoking EdgeDriver with new profile...");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;

	}
	private static WebDriver initFireFoxDriver(String url) {
		System.out.println("Invoking FirefoxDriver with new profile...");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;

	}

	@Parameters({"browserName", "url"})
	@BeforeSuite
	public void startingBrowser(String browserName, String url) {
		try {
			setDriver(browserName, url);
		} catch (Exception e) {
			System.out.println("Error..... " + e.getStackTrace());
		}
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

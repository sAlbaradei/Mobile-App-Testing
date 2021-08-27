package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class sendKey {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("deviceName", "Pixel_3_API_24");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome"); 

		//capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of
																							// your app (you can get it
																							// from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
		driver.get("https://www.amazon.com");
		WebElement SearchBox = driver.findElement(By.xpath("//input[contains(@id,'search-keywords')]"));
		SearchBox.sendKeys("mobile");
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}

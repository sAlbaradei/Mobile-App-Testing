package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class calTest {

	AppiumDriver <MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_24");
		//capabilities.setCapability("platformVersion", "10");
		//capabilities.setCapability("deviceName", "Galaxy S9");
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("udid", "2354926b0b057ece");

		capabilities.setCapability("appPackage", "com.android.calculator2");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); 
		
		URL url = new URL ("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		

	}

	@Test
	public void testCal() throws Exception {
		//driver.get("https://www.google.com");
		
	}

	@AfterClass
	public void teardown() {
		// close the app
	//	driver.quit();
	}
}

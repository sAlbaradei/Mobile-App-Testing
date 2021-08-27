package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class twitter {
	AppiumDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "10.0");
		capabilities.setCapability("deviceName", "Galaxy S9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		// Create RemoteWebDriver instance and connect to the Appium server
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void login() throws Exception {
		driver.get("https://mobile.twitter.com/login");

		Thread.sleep(3000);
		driver.findElement(By.name("session[username_or_email]")).sendKeys("siro");
		driver.findElement(By.name("session[password]")).sendKeys("****");
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.hideKeyboard();
		driver.findElement(By
				.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div/span/span"))
				.click();
		Thread.sleep(3000);
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}

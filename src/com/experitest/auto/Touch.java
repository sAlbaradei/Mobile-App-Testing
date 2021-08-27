package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Touch {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("deviceName", "Pixel_3_API_24");
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.contacts");  
		// activity of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity"); // This is Launcher
		
        //Create RemoteWebDriver instance and connect to the Appium server
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Test
	public void touch() throws Exception {
		WebElement element = driver.findElement(By.id("com.android.contacts:id/menu_search"));
		//WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Play Store']"));
		Thread.sleep(5000);
		new Actions(driver).click(element).perform();
		Thread.sleep(3000);
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}

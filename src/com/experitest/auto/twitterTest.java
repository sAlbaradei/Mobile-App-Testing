package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class twitterTest {
    WebDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException {
    // Set up desired capabilities and pass the Android app-activity and app-package
    // to Appium
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	capabilities.setCapability("VERSION", "7.0");
	capabilities.setCapability("deviceName", "Pixel_3_API_24");
    capabilities.setCapability("platformName", "Android");
//Create RemoteWebDriver instance and connect to the Appium server
        // It will launch the Calculator App in Android Device using the configurations
        // specified in Desired Capabilities
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarah\\Downloads\\chromedriver.exe");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

@Test
public void TestSendKeys() throws InterruptedException {
    driver.get("https://twitter.com/");
    Thread.sleep(3000);
driver.findElement(
            By.xpath("//[@id=\"layers\"]/div/div/div/div/div[2]/div[1]/div/span/span/span"))
            .click();
    driver.findElement(
            By.xpath("//[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/div[4]/span/span"))
            .click();
    driver.findElement(
            By.xpath("//[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[3]/a/div/span/span"))
            .click();

    driver.findElement(By.name("session[username_or_email]")).sendKeys("5005@gmail.com");
    driver.findElement(By.name("session[password]"))
            .sendKeys("1234567890");
    driver.findElement(By
            .xpath("//[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div/span/span"))
            .click();

}
}
package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class noon {
	
	WebDriver driver;
	

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		// Set up desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "10.0");
		capabilities.setCapability("deviceName", "Galaxy S9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		
		// Create RemoteWebDriver instance and connect to the Appium server
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarah\\Downloads\\chromedriver.exe");

	}

	@Test
	public void noonTest() throws Exception {
		//Launch the website
		driver.get("https://www.noon.com/saudi-en/");
		
		//Get the search box element and send an item
		WebElement search =  driver.findElement(By.id("searchBar"));
		search.sendKeys("electronics");
		driver.findElement(By.xpath("//*[@id=\"searchBar\"]")).sendKeys(Keys.ENTER);

		//Click on an electronic item
		WebElement electronics =  driver.findElement(By.xpath("//*[@id=\"productBox-N20675892A\"]/div/div[1]/div[1]/div/div/div/img"));
		electronics.click();
		WebElement cart =  driver.findElement(By.className("cart-button"));
		cart.click();
		Thread.sleep(3000);
		
		//Search and click a beauty item
		search.sendKeys("beauty"+"\n");
		WebElement beauty =  driver.findElement(By.xpath("//*[@id=\"productBox-N43772904A\"]/div/div[1]/div[1]/div/div/div/img"));
		beauty.click();
		WebElement cart2 =  driver.findElement(By.className("cart-button"));
		cart2.click();
		Thread.sleep(3000);
		
		//Search and click a groceries item
		search.sendKeys("groceries"+"\n");
		WebElement groceries =  driver.findElement(By.xpath("//*[@id=\"productBox-N43362854A\"]/div/div[1]/div[1]/div/div/div/img"));
		groceries.click();
		WebElement cart3 =  driver.findElement(By.className("cart-button"));
		cart3.click();
		Thread.sleep(3000);
		
		//Search and click a home item
		search.sendKeys("home"+"\n");
		WebElement home =  driver.findElement(By.xpath("//*[@id=\"productBox-N32048618A\"]/div/div[1]/div[1]/div/div/div/img"));
		home.click();
		WebElement cart4 =  driver.findElement(By.className("cart-button"));
		cart4.click();
		Thread.sleep(9000);
		
		//Search and click a school item
		search.sendKeys("school"+"\n");
		WebElement schoolgoods =  driver.findElement(By.xpath("//*[@id=\"productBox-N20609833A\"]/div/div[1]/div[1]/div/div/div/img"));
		schoolgoods.click();
		WebElement cart5 =  driver.findElement(By.className("cart-button"));
		cart5.click();
		Thread.sleep(3000);
		
		//Click on checkout button
		WebElement checkout =  driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div[2]/div/div[1]/div[2]/button[1]"));
		checkout.click();
		Thread.sleep(3000);
		
		//Click on buy button
		WebElement buy =  driver.findElement(By.className("ripple"));
		buy.click();
		Thread.sleep(3000);
		
		//Enter email address
		WebElement email =  driver.findElement(By.name("email"));
		email.sendKeys("sara.abdulla_b@hotmail.com");
		Thread.sleep(3000);
		
		//Enter the passowrd
		WebElement pass =  driver.findElement(By.name("password"));
		pass.sendKeys("1s2a3r4a");
		Thread.sleep(3000);
		
		//Click on signin button
		WebElement signin =  driver.findElement(By.id("submitLoginFormBtn"));
		signin.click();
		Thread.sleep(3000);
		
		//Click on Continue button
		WebElement con =  driver.findElement(By.xpath("//button[@aria-label='Continue']"));
		con.click();
		Thread.sleep(3000);
		
		//Click on add new card button
		WebElement addcard =  driver.findElement(By.xpath("//button[@aria-label='Add a New Card']"));
		addcard.click();
		Thread.sleep(3000);
		
		//Enter wrong card number
		WebElement card =  driver.findElement(By.id("ccNumber"));
		card.sendKeys("12345667");
		Thread.sleep(3000);
		
		// expected error text
		String exp = "Invalid card number";
		// identify actual error message
		WebElement m = driver.findElement(By.className("textError"));
		String act = m.getText();
		System.out.println("Error message is: " + act);
		// verify error message with Assertion
		Assert.assertEquals(exp, act);


	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}

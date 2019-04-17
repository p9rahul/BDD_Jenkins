package com.pom.ajay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Rahul\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}

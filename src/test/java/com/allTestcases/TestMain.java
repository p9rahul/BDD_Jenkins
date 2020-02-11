package com.allTestcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ExcelUtility.ExcelUtil;
import ExcelUtility.ExecutionContext;

public class TestMain {

	ExcelUtil excelData = new ExcelUtil();
	ExecutionContext context = new ExecutionContext();

	@Test
	public void tc1() throws InterruptedException {

		String chromeDriverExePath = System.getProperty("user.dir")+"\\src\\test\\resources\\DriversFile\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverExePath);
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Rahul\\eclipse-workspace\\BDD_Jenkins\\src\\main\\resources\\WebServicesFolder\\MyHome.html");
		driver.manage().window().maximize();

		excelData.loadExcel("Sheet2");
		this.context.testdata = excelData.readData("TestCase", "TC1");
		driver.findElement(By.id("Fname")).sendKeys(
				this.context.testdata.get("FirstName").toString());
		driver.findElement(By.id("lastname")).sendKeys(
				this.context.testdata.get("LastName").toString());

		Thread.sleep(3000);
		this.context.testdata = excelData.readData("TestCase", "TC2");
//		driver.findElement(By.id("Fname")).clear();
		driver.findElement(By.id("Fname")).sendKeys(
				this.context.testdata.get("FirstName").toString());
//		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(this.context.testdata.get("LastName").toString());

		Thread.sleep(3000);
		this.context.testdata = excelData.readData("TestCase", "TC3");
		driver.findElement(By.id("Fname")).clear();
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("Fname")).sendKeys(
				this.context.testdata.get("FirstName").toString());
		driver.findElement(By.id("lastname")).sendKeys(
				this.context.testdata.get("LastName").toString());
	}
}

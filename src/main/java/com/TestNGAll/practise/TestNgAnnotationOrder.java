package com.TestNGAll.practise;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotationOrder {

	
	

	@Test
	public void m1()
	{
		System.out.println("Test1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void m12()
	{
		System.out.println("Test2");
		Assert.assertTrue(true);
	}
	
	@Test
	public void m13()
	{
		System.out.println("Test13");
		boolean status=false;
		Assert.assertTrue(status);
	}
	
	@Test
	public void m14()
	{
		System.out.println("Test13");
		Assert.assertEquals("ram", "Ram", "string not equals");
	}
	
	@BeforeTest
	public void m2()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void m3()
	{
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void m4()
	{
		System.out.println("before class");
	}
	
	@AfterClass
	public void m5()
	{
		System.out.println("after class");
	}
	
	@BeforeSuite
	public void m6()
	{
		System.out.println("Before suite");
	}
	
	@AfterSuite
	public void m7()
	{
		System.out.println("After suite");
	}
	
	
	@BeforeMethod
	public void m8()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void m9()
	{
		System.out.println("After method");
	}
	
	@BeforeGroups
	public void m10()
	{
		System.out.println("Before groups");
	}
	
	@AfterGroups
	public void m11()
	{
		System.out.println("After groups");
	}
}
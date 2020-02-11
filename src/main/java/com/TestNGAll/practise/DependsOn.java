package com.TestNGAll.practise;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOn {
	
	@Test
	public void tc1()
	{
		System.out.println("tc1");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods={"tc1"})
	public void tc2()
	{
		System.out.println("tc2");
	}
	
	@Test(dependsOnMethods={"tc1","tc2"})
	public void tc3()
	{
		System.out.println("tc3");
	}
	
	@Test
	public void tc4()
	{
		System.out.println("tc4");
	}

}

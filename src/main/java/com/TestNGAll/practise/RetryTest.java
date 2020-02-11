package com.TestNGAll.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

	@Test
	public void tc1()
	{
		Assert.assertTrue(true);
	}
	
	@Test
	public void tc2()
	{
		Assert.assertTrue(false);
	}
}

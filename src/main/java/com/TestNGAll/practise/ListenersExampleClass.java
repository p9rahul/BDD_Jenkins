package com.TestNGAll.practise;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenersExampleClass {
	
	@Test
	public void tc1()
	{
		
	}
	
	@Test
	public void tc2()
	{
		throw new SkipException("skip this test case");
	}
	
	@Test
	public void tc3()
	{
		
	}
	
	@Test
	public void tc4()
	{
		
	}

}

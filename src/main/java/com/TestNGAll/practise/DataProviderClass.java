package com.TestNGAll.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	// if you want to execute you script with multiple set up then go for
	//return type 2-d object array
	//array of 2-d object
	
	@DataProvider
	public Object[][] dataProviderEample()
	{
		Object[][] data =new Object[2][2];
		
		data[0][0]="ram";
		data[0][1]="kumar";
		
		data[1][0]="amit";
		data[1][1]="kumar";
		
		return data;
	}
	
	@Test(dataProvider="dataProviderEample")
	public void tc1(String s1,String s2)
	{
		System.out.println(s1 +" "+s2);
	}
}


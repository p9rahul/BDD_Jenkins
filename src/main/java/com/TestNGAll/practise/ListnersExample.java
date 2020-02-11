package com.TestNGAll.practise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersExample implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart - " +getMethodName(result));
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test cases success - " +getMethodName(result));
		
	}

	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("test case fail");
		}
	}

	public void onTestSkipped(ITestResult result) {
		if(result.getStatus() == ITestResult.SKIP)
		{
			System.out.println("skip test cases");
		}
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public static String getMethodName(ITestResult result)
	{
		
		return result.getMethod().getConstructorOrMethod().getName();
		
	}

}

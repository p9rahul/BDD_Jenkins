package com.TestNGAll.practise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersExample implements ITestListener{
	
	/*why ?
	 listen event based on your annotation 
	 implements  -> ITestListener -> add unimplemented method
	 
	 */

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
				
	}

	public void onTestFailure(ITestResult result) {
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	

}

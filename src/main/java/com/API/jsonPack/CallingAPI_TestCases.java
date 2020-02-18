package com.API.jsonPack;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import ExcelUtility.ExecutionContext;

public class CallingAPI_TestCases {
	
	//make JsonUtility as singleton becasue going forward we will not create object of this but will use same object
	JsonUtility jsonUtility = new JsonUtility();
	
	@Test
	public void apiTC1() {

		jsonUtility.getRequest("https://reqres.in/api/users?page=2");

		String empDetails = jsonUtility.getValueFromResponse(JsonPOM.id) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.first_name) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.last_name) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.firstEmail);
		
		System.out.println(empDetails);
	}
	
	@Test(dependsOnMethods={"apiTC1"})
	public void apiTC2() {

		String empDetails = jsonUtility.getValueFromResponse(JsonPOM.id) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.first_name) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.last_name) + " "
				+ jsonUtility.getValueFromResponse(JsonPOM.firstEmail);
		
		System.out.println(empDetails);
	}
	
	@Test (dependsOnMethods={"apiTC2"})
	public void apiTC3() {

		/*Advantage of keeping json response in ExecutionContext variable is to use as and when required.
		-Steps to implement 
		1) create ExecutionContext class
		2) Declare a variable inside -public static String jsonResponseAll=null;
		3) Set value in this in a different class. ExecutionContext context = new ExecutionContext();
		4) Call this when it required in other class- ExecutionContext.jsonResponseAll
		*/
		System.out.println(ExecutionContext.jsonResponseAll);
		
		//
		System.out.println(JsonPath.read(ExecutionContext.jsonResponseAll,"$..data[0].first_name" ).toString().replaceAll("[^\\dA-Za-z@.$]", ""));
	}

}

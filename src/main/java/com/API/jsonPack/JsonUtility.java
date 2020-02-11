package com.API.jsonPack;

import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import ExcelUtility.ExecutionContext;

public class JsonUtility {
	
	ExecutionContext context = new ExecutionContext();
	Response serviceResponse;

	/* Q) How to find json path? URL - https://jsonpath.com */

	public void getRequest(String url) {
		try {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		 serviceResponse = requestSpecification.get(url);
		 this.context.jsonResponseAll = serviceResponse.body().asString();
		}catch(Exception e) {
			System.out.println ( "Service is down \n"+e.getMessage());
			System.exit(1);
		}
	}

	public String getValueFromResponse(String jsonPath) {
		return JsonPath.read(this.context.jsonResponseAll, jsonPath).toString().replaceAll("[^\\dA-Za-z@.$]", "");

		/*
		 * replace("[", "").replace("]", "") regx remove all characters except digit,
		 * ato z @ and dot - [^\\dA-Za-z@.$] -- \\d -all digit
		 * 
		 */
	}

	public Response postRequest(String url, String bodyString) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.body(bodyString.toString());
		Response response = requestSpecification.post(url);
		return response;
	}
	
	public int findStatusCode() {		
		return serviceResponse.getStatusCode();
	}
}

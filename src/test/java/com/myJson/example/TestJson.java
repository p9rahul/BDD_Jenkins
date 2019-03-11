package com.myJson.example;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestJson {

	public static void main(String[] args) {
		
//		https://jsonplaceholder.typicode.com/todos
		
		RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
		Response response = (Response) requestSpecification.get("http://api.plos.org/search?q=title:DNA").body();
//		System.out.println(response.toString())
		
		JsonPath path = response.jsonPath();
//		System.out.println(path.get("response.docs"));
		List<Object> allList = path.getList("response.docs");
		System.out.println(allList.size());
		for(int i=0;i<allList.size();i++)
		{
			//get all ids
//			System.out.println(path.get("response.docs["+i+"].id"));
			System.out.println(path.get("response.docs["+i+"].author_display[0]"));
		}

//		System.out.println(path.get("title").toString());
//		System.out.println(path.get("$"));
//		System.out.println(path.get("$.").toString());
//		System.out.println("Get all title list - " + path.getList("title"));
//		System.out.println(path.get("[2].id"));
//		System.out.println(path.getList("$.").size());  //200
//		System.out.println(path.getJsonObject("id"));   //200
//		List<Object> allCount = path.getList("title");
//		System.out.println(allCount.size());
//		for(int i=0;i<allCount.size();i++){
//			System.out.println("id - " +path.get("["+i+"].id") +" --- title --------"+ path.get("["+i+"].title"));
//		}
		
		
			
	}

}

package com.wv.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class JiraAutomationDemo {
	
	@Test
	public void login(){
		
		RestAssured.baseURI = "http://localhost:8080";
		
		String response = given().log().all().header("Content-Type","application/json")
		.body("{ \"username\": \"kit.shreyasjoshi\", \"password\": \"Laibhari@123\" }")
		.when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath jp = new JsonPath(response);
		String cookieVal = jp.getString("session.value");
		
		given().log().all().
	}

}

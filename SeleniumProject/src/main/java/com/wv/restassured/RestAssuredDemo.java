package com.wv.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import com.jsonbody.Payload;

public class RestAssuredDemo {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Payload.getBody()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jp = new JsonPath(response);
		String placeId = jp.getString("place_id");
		
		given().relaxedHTTPSValidation().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(Payload.getUpdateBody(placeId)).when()
		.put("maps/api/place/update/json").then().log().all()
		.assertThat().statusCode(200);
		
		given().relaxedHTTPSValidation().log().all()
		.queryParams("key", "qaclick123", "place_id", placeId)
		.get("maps/api/place/get/json").then().log().all()
		.assertThat().statusCode(200);
	}

}

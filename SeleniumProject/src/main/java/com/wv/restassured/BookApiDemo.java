package com.wv.restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jsonbody.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class BookApiDemo {
	
	@Test(dataProvider="BookInfo")
	public void test_addBook(String isbn, String asin){
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().header("Content-Type","application/json")
		.body(Payload.addBook(isbn,asin)).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().asString();
		
		JsonPath jp = new JsonPath(response);
		String bookId = jp.getString("ID");
		//BZRM-FF43-TZ7T-O4K0 jira server id
	}
	
	@DataProvider(name="BookInfo")
	public Object[][] testData(){
		
		return new Object[][] {{"dsfdsf","234"},{"sdfsf","567"},{"gdgh","24354"}};
	}

}

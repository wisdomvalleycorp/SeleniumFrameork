package com.wv.restassured;

import com.jsonbody.Payload;

import io.restassured.path.json.JsonPath;

public class JsonPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath jp = new JsonPath(Payload.getComplexJson());
		int count = jp.getInt("courses.size()");
		for(int i=0; i<count;i++){
			System.out.println("Course Title "+jp.get("courses["+i+"].title"));
			System.out.println("Course price "+jp.get("courses["+i+"].price"));
		}

	}

}

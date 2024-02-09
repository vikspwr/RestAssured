package com.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.routes.Routes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeEndPoints {
	
	public static Response fetchAllEmployee() {
		
		Response response = given()
			.contentType(ContentType.JSON)
		
		.when()
			.get(Routes.fetchAllEmployee);
		
		return response;
	}
	

}

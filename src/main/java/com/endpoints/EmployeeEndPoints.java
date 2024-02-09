package com.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.payload.EmployeeData;
import com.routes.Routes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeEndPoints {

	public static Response fetchAllEmployee() {

		Response response = given().contentType(ContentType.JSON)

				.when().get(Routes.fetchAllEmployee);

		return response;
	}

	public static Response fetchSingleEmployee(String id) {

		Response response = given().contentType(ContentType.JSON).pathParam("empId", id).when()
				.get(Routes.fetchSingleEmployee);

		return response;

	}

	public static Response createEmployee(EmployeeData data) {

		Response response = given().contentType(ContentType.JSON).body(data).when().post(Routes.createNewEmployee);
		return response;
	}

	public static Response deleteEmployee(String id) {

		Response response = given().contentType(ContentType.JSON).pathParam("empId", id).when()
				.delete(Routes.deleteExistingEmployee);

		return response;

	}

	public static Response updateEmployee(EmployeeData data, String id) {

		Response response = given().contentType(ContentType.JSON).pathParam("empId", id).body(data).when()
				.put(Routes.updateExistingEmployee);

		return response;

	}

}

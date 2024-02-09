package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.EmployeeEndPoints;

import io.restassured.response.Response;

public class TestEmployeeEndPoints {

	public static Logger logger = LogManager.getLogger(TestEmployeeEndPoints.class);;

	@Test
	public void verifyFetchAllEmployee() {
		
		Response response = EmployeeEndPoints.fetchAllEmployee();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	

}

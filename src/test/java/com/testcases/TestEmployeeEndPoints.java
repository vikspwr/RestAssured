package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.endpoints.EmployeeEndPoints;
import com.payload.EmployeeData;

import io.restassured.response.Response;

public class TestEmployeeEndPoints {

	public static Logger logger = LogManager.getLogger(TestEmployeeEndPoints.class);;

	@Test(priority = 1)
	public void verifyFetchAllEmployee() {

		Response response = EmployeeEndPoints.fetchAllEmployee();
		Assert.assertEquals(response.getStatusCode(), 200);

		response.then().log().body();

	}

	@Test(priority = 2)
	public void verifyFetchSingleEmployee() {
		SoftAssert sa = new SoftAssert();
		Response response = EmployeeEndPoints.fetchSingleEmployee("1");
		response.then().log().body();
		sa.assertEquals(response.getStatusCode(), 200);
		String name = response.jsonPath().get("name").toString();
		sa.assertEquals(name, "Vikas");
		sa.assertAll();
	}

	@Test(priority = 3)
	public void verifyCreateEmployee() {
		EmployeeData data = new EmployeeData();

		String[] courses = { "Java", "Selenium" };
		data.setId("101");
		data.setName("xyz");
		data.setMarried("married");
		data.setCompany("cname");
		data.setSalary("60000");
		data.setCourses(courses);
		data.setAddress("Ngn");

		Response response = EmployeeEndPoints.createEmployee(data);

		Assert.assertEquals(response.getStatusCode(), 201);

	}

	@Test(priority = 6, dataProvider = "GetData", dataProviderClass = EmployeeData.class)
	public void verifyCreateEmployeeDD(String id, String name, String salary, String married, String address,
			String company,String course1,String course2) {
		EmployeeData data = new EmployeeData();

		String[] courses = { course1, course2 };
		data.setId(id);
		data.setName(name);
		data.setMarried(married);
		data.setCompany(company);
		data.setSalary(salary);
		data.setCourses(courses);
		data.setAddress(address);

		Response response = EmployeeEndPoints.createEmployee(data);

		Assert.assertEquals(response.getStatusCode(), 201);

	}

	@Test(priority = 5)
	public void verifyDeleteEmployee() {

		Response response = EmployeeEndPoints.deleteEmployee("0d6a");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void verifyUpdateEmployee() {

		EmployeeData data = new EmployeeData();

		String[] courses = { "OOps", "Selenium" };

		data.setName("xyzupdated");
		data.setMarried("marriedupdated");
		data.setCompany("cnameupdated");
		data.setSalary("70000");
		data.setCourses(courses);
		data.setAddress("Pune");

		Response response = EmployeeEndPoints.updateEmployee(data, "101");

		Assert.assertEquals(response.getStatusCode(), 200);

	}
}

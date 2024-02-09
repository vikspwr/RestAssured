package com.payload;

import org.testng.annotations.DataProvider;

import com.utilities.ExcelReader;

public class EmployeeData {

	private String id;
	private String name;
	private String salary;
	private String married;
	private String address;
	private String company;
	private String[] courses;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	@DataProvider(name = "GetData")
	public static String[][] getDataFromExcel() {

		ExcelReader reader = new ExcelReader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/EmpData.xlsx");
		int noOfRows = reader.getRowCount("Sheet1");
		int noOfColumns = reader.getColumnCount("Sheet1", 1);

		String[][] createEmpData = new String[noOfRows][noOfColumns];

		for (int i = 1; i <= noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				createEmpData[i - 1][j] = reader.getCellData("Sheet1", i, j);
			}
		}

		return createEmpData;

	}

}

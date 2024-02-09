package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utilities.ExtentReportManager;

public class MyListener extends ExtentReportManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.GREY));
	}

	public void onStart(ITestContext context) {
		ExtentReportManager.generateReport("D:/SeleniumProjects/RestAssuredFramework/TestReports/Report.html", "My Doc Title", "My Report Name");
	}

	public void onFinish(ITestContext context) {
		ExtentReportManager.saveReport();
	}

}

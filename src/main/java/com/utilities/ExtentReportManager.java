package com.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager{
	
	public static ExtentReports reports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	
	public static void generateReport(String reportPath,String docTitle, String reportName) {
		
		reports = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(new File(reportPath));
		sparkReporter.config().setDocumentTitle(docTitle);
		sparkReporter.config().setReportName(reportName);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("MM-dd-yyyy hh:mm:ss");
		
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Operating System", System.getProperty("os.name"));
		reports.setSystemInfo("Tester", "Vikas S Pawar");
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("Tech", "Rest Assured");
	}
	
	public static void saveReport() {
		reports.flush();
	}

}

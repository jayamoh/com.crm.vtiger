package com.crm.practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {

	public static void main(String[] args) {
		//step1: create template and configure
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("reportname");
		spark.config().setTheme(Theme.DARK);
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows 10");
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("browser version", "108");
		report.setSystemInfo("reporter name", "vannur");
		report.flush();

	}

}

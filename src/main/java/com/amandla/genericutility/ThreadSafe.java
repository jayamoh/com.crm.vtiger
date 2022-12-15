package com.amandla.genericutility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {

	private static ThreadLocal<WebDriverUtility> webdriverUtility=new ThreadLocal<WebDriverUtility>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public static WebDriverUtility getWebDriverUtility() {
		return webdriverUtility.get();
	}
	public static void setWebDriverUtility(WebDriverUtility swebdriverUtility) {
		webdriverUtility.set(swebdriverUtility);
	}
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest test) {

		extentTest.set(test);
	}
}

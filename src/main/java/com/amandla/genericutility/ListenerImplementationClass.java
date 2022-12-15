package com.amandla.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class contains all the implementation methods of ITestListener interface
 * @author VANNUR
 *
 */
public class ListenerImplementationClass  implements ITestListener {
	private ExtentReports report;
	private ExtentTest test;


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestStart");
		test=report.createTest(result.getMethod().getMethodName());//crating multiple tabs
		ThreadSafe.setExtentTest(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSuccess");
		//test.pass(result.getMethod().getMethodName()+" is passed"); 
		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailure");
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+" is failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable());
		String screenshot=ThreadSafe.getWebDriverUtility().takesScreenShot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot,result.getMethod().getMethodName());//it is used to get the screenshot in the report directly without capturing from the path
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println(Thread.currentThread().getId()+" onTestSkipped");
		//test.skip(result.getMethod().getMethodName()+" is skipped");
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+" is skipped");
		//test.skip(result.getThrowable());
		ThreadSafe.getExtentTest().pass(result.getThrowable());
		String screenshot=ThreadSafe.getWebDriverUtility().takesScreenShot(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().addScreenCaptureFromPath(screenshot); //this method is used to add the screen shot to the report captured from the path
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"onStart---> test");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("report name");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows 10");
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("browser version", "108");
		report.setSystemInfo("reporter name", "vannur");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"onFinish---> test");
		report.flush();
	}

}

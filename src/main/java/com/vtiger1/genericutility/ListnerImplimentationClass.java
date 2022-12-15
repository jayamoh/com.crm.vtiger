package com.vtiger1.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplimentationClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("execution starts from here");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
EventFiringWebDriver eventDriver=new EventFiringWebDriver(WebDriverUtility.sdriver);
File src = eventDriver.getScreenshotAs(OutputType.FILE);
File dest = new File("./screenshot/testscript.png");
try {
	FileUtils.copyFile(src, dest);
}catch(IOException e) {
	e.printStackTrace();
}

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}

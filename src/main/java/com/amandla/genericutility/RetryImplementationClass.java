package com.amandla.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class contains implementation method of IRetryAnalyzer functional interface
 * @author VANNUR
 *
 */
public class RetryImplementationClass implements IRetryAnalyzer{
	int count=0;
	int retryLimit=3;
	/**
	 * this method is used to execute failed test method multiple times
	 */
	@Override
	public boolean retry(ITestResult result) {

		if (count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

}

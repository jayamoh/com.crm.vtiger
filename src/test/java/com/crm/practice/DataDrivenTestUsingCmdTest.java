package com.crm.practice;

import org.testng.annotations.Test;

public class DataDrivenTestUsingCmdTest {
	@Test
	public void getDataFromCMD() {
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println("url is: "+url);
		System.out.println("username is: "+username);
		System.out.println("password is: "+password);

	}

}

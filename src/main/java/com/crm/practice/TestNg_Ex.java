package com.crm.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_Ex {
	@BeforeSuite
	public void beforetest() {
		System.out.println("before suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeclass");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
}

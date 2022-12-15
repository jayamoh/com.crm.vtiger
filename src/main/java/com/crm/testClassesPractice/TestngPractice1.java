package com.crm.testClassesPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPractice1 {

@BeforeSuite(groups="baseclass",alwaysRun=true)
public  void suiteSetup() {
	System.out.println("Before Suite");
}
@AfterSuite(groups="baseclass",alwaysRun=true)
public  void suiteTearDown() {
	System.out.println("After Suite");
}

@BeforeTest(groups="baseclass",alwaysRun=true)
public  void testSetup() {
	System.out.println("Before Test");
}
@AfterTest(groups="baseclass",alwaysRun=true)
public  void testTearDown() {
	System.out.println("After Test");
}

@BeforeClass(groups="baseclass",alwaysRun=true)
public  void classSetup() {
System.out.println("Before Class");
}
@AfterClass(groups="baseclass",alwaysRun=true)
public  void classTearDown() {
System.out.println("After  Class");
}

@BeforeMethod(groups="baseclass",alwaysRun=true)
public  void methodSetup() {
	System.out.println("Before Method");
}
@BeforeMethod(groups="baseclass",alwaysRun=true)
public  void methodTearDown() {
	System.out.println("After Method");
}
@Test
public void test1() {
	System.out.println("Test1");
}
@Test
public void test2() {
	System.out.println("Test2");
}
@Test
public void test3() {
	System.out.println("Test3");
}



}

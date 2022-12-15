package com.crm.testClassesPractice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.IConstantPath;

public class TestNGPractice2 {
	@Test(dataProvider="getData")
	public void test2(String userName,int passWord) {
		System.out.println("user Name==>"+userName);
		System.out.println("pwd Word==>"+passWord);
	}

 
	@DataProvider
	public String[][] getData(){
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH);
	String[][] arr=excelUtility.getDataFromExcel("Sheet1");
	return arr;
	}@Test(groups= {"sanity","chrome"})
	public void test() {
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(10, 11);
		System.out.println("Test before");
		Assert.assertEquals("A", "A");
		//Assert.assertTrue("Test Before".contains("Test"));
		//Assert.assertTrue("Test Before".contains("test"),"Expected is test inside TestBefore");
		//System.out.println(" Test after ");
		Reporter.log("Test After",true);
		softAssert.assertAll();
		//System.out.println(" Test after ");
	}
	@Parameters("browser")
	@Test(groups="sanity")
	public void test2(String browser) {
		System.out.println("Test2");
	}
	@Test(groups="reg")
	public void test3() {
		Reporter.log("test3",true);
	}
}

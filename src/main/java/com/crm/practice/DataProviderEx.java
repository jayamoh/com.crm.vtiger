package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amandla.genericutility.ExcelUtility;
import com.amandla.genericutility.IConstantPath;
import com.amandla.genericutility.ThreadSafe;

public class DataProviderEx {
	//priority,invocation count,dependsOnMethods,alwaysRun,description

	/*priority----it is used to give priority for the methods and the default priority will be 0 and if we give -ve values than it will execute 
	 * first -ve methods based on priority and than positive methods 
	 * default value of priority is 0
	 */
	/*invocationCount--- it is used to execute the methods multiple times, the default value of invocation count is 1 so, all the methods 
	 * will be execute only once until we increase invocation count
	 * default value of invocation count is 1
	 */
	/*
	 * dependsOnMethods--it is used to make current method to depend on another method we usually use this when we have precondition 
	 * for a particular TestCase Ex:----contacts with organization here in order execute contact testCase method we need 
	 * create organization as a Pre condition hence we use dependesOnMethod for this kind of example
	 */
	/*
	 * alwaysRun--- it is used to execute testMethod even if current method depends on another method(i.e, if depends on method will fail
	 * also the current method will execute)
	 */
	/*
	 * description----it is used to give the description for the test method
	 */
	/*
	 * dataProvider-- it is used to read the data if @DataProvider annotation method returns and here dataProvide name we can as method name or @DataProvider name
	 */

	//@Test(dataProvider = "test2") //here we can give method name if we don't have any name for @DataProvider annotation
	@Test(dataProvider = "data1")
	public void test1(String username,String password) {
		//		System.out.println("user name ---->"+username+"    password ------>"+password);
		ThreadSafe.getExtentTest().createNode("user name ---->"+username+"    password ------>"+password);
	}
	@DataProvider(name = "data1")
	public Object[][] test2() {
		Object[][] ob=new Object[3][2];
		ob[0][0]="admin";
		ob[0][1]="manager";
		ob[1][0]="admin1";
		ob[1][1]="manager1";
		ob[2][0]="admin2";
		ob[2][1]="manager2";
		return ob;

	}
	@Test(dataProvider = "getDataFromExcel")
	public void test2(String username,String password) {
			System.out.println("user name ---->"+username+"    password ------>"+password);
		ThreadSafe.getExtentTest().createNode("user name ---->"+username+"    password ------>"+password);
	}
	@DataProvider
	public String[][] getDataFromExcel() {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		return excelUtility.getDataFromExcel("sheet1");


	}
}

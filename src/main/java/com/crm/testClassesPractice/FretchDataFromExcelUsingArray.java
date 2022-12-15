package com.crm.testClassesPractice;

import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.IConstantPath;

public class FretchDataFromExcelUsingArray {

	public static void main(String[] args) {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		String[][] ar=excelUtility.getDataFromExcel("Sheet1");
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.println(ar[i][j]);
			}
		}
	}

}

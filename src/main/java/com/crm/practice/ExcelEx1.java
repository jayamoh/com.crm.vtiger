package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelEx1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//physical file into the object
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		int row=workbook.getSheet("Sheet1").getLastRowNum();//based on index
		System.out.println(row);
		int cell=workbook.getSheet("Sheet1").getRow(1).getLastCellNum(); //count of the cells
		System.out.println(cell);
		for (int i=0; i <=row;i++) {
			Row row1=workbook.getSheet("Sheet1").getRow(1);
			for (int j = 0; j <=cell-1; j++) {
				System.out.println(row1.getCell(j).getStringCellValue());
			}
			break;
		}





	}

}

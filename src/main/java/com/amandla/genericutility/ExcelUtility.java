package com.amandla.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains excel reusable methods
 * @author VANNUR
 *
 */
public class ExcelUtility {
	private FileInputStream fis;
	private Workbook workbook;
	private FileOutputStream fos;
	private DataFormatter df;
	/**
	 * this method is used to open excel
	 * @param excelPath
	 * @return 
	 */
	public Workbook openExcel(String excelPath ) {
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e1) {
			try {
				fis = new FileInputStream(excelPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}
	/**
	 * this method is used to read multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public String[][] getDataFromExcel(String sheetName){
		df=new DataFormatter();
		int row_num=workbook.getSheet(sheetName).getLastRowNum(); //10
		int cell_num=workbook.getSheet(sheetName).getRow(1).getLastCellNum(); //2
		String[][] arr=new String[row_num][cell_num];
		for (int i = 0; i <row_num; i++) {
			for (int j = 0; j <cell_num; j++) {
				arr[i][j]=df.formatCellValue(workbook.getSheet(sheetName).getRow(i+1).getCell(j));
			}
		}
		return arr;
	}
	/**
	 * this method is used to fetch the data from excel using row and cell index
	 * @param excelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String excelPath,String sheetName,int rowNum,int cellNum){

		openExcel(excelPath);
		df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
	}

	/**
	 * this method is used to set the data back to excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 */
	public void setDataBackToExcel(String excelPath,String sheetName,int rowNum,int cellNum,String cellValue)
	{

		workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(cellValue);

		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * this method is used to close the excel workbook
	 */
	public void closeExcel() {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
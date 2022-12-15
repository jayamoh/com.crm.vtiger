package com.vtiger1.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author jay
 *
 *
 */
public class ExcelUtility {
	private FileInputStream fis;
	private Workbook workbook;
	private FileOutputStream fos;
	private DataFormatter df;

	/**
	 * this method is used to fetch the data from excel using row and cell index
	 * @param excelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String excelPath,String sheetName,int rowNum,int cellNum){

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
	
		
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
	}
	
	public Workbook openExcel(String excelPath) {

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
	 * this method is used to set the data back to excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 */
	public void setDataBackToExcel(String excelPath,String sheetName,int rowNum,int cellNum,String cellValue)
	{
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
	public String[][] getDataFromExcel(String sheetName){
		df=new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum();//return index==>index
		short lastCellNumber = sheet.getRow(0).getLastCellNum();//return count/size==>count-1
		String[][] arr=new String[lastRowNumber][lastCellNumber];
		for(int i=0;i<lastRowNumber;i++) {
			for(int j=0;j<lastCellNumber;j++) {
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return arr;
	}
}
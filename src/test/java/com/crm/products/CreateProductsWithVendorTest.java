package com.crm.products;




import java.io.IOException;


import org.openqa.selenium.WebDriver;

import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.FeatureFileUtility;
import com.vtiger1.genericutility.IConstantPath;
import com.vtiger1.genericutility.PropertyFileKeys;
import com.vtiger1.genericutility.SheetName;
import com.vtiger1.genericutility.WebDriverUtility;
import com.vtiger1.objectrepository.CommonPage;
import com.vtiger1.objectrepository.CreateProductsPage;
import com.vtiger1.objectrepository.CreatingNewProductPage;
import com.vtiger1.objectrepository.LoginPage;
import com.vtiger1.objectrepository.ProductInformationPage;
/**
 * it is used to test an CreateProductsWithVendor module
 * @author jay
 *
 */

public class CreateProductsWithVendorTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		//creating object of genericUtility classes
		FeatureFileUtility property=new FeatureFileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		//reading data from property file
		String username = property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.convertToString());
		String password=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.convertToString());
		String url=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//reading data from excel file
		String expectedStartDate=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 1);
		String expectedEndDate=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 2);
		String excepetedProductcat=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 3);
		String expectedProductName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 4);
		String expectedVendorName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 5);
		//launching application
		WebDriver driver=webdriverUtility.launchApplication("chrome", 10, url);
		//creating object of objectRepository classes related to Products module
		LoginPage loginPage=new LoginPage(driver);
		CommonPage commonPage=new CommonPage(driver);
		CreateProductsPage createProductsPage=new CreateProductsPage(driver);
		CreatingNewProductPage creatingNewProductPage=new CreatingNewProductPage(driver);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		//login to application
		loginPage.loginAction(username, password);
		//clicking on products tab
		commonPage.clickProductsTab();
		//clicking on create new products icon
		createProductsPage.clickCreateProductsIcon();
		//filling all the details in creating new products page with vendor name
		creatingNewProductPage.enterIntoProductNameTextField(expectedProductName);
		creatingNewProductPage.enterIntoSalesStartDateTextField(expectedStartDate);
		creatingNewProductPage.selectFromProductCategoryDropdown(webdriverUtility, excepetedProductcat);
		creatingNewProductPage.enterIntoSalesEndtDateTextField(expectedEndDate);
		creatingNewProductPage.clickOnVendorNameLookupIcon();
		creatingNewProductPage.enterTextInVendorNameSearchTextBox(webdriverUtility, "module=Vendors", expectedVendorName);
    	creatingNewProductPage.clickOnsearchNowButton(driver, expectedVendorName);
		webdriverUtility.handlingWindowsBasedOnUrl("module=Products");		
		creatingNewProductPage.clickOnSaveButton();
		webdriverUtility.waitCondition(10);
		productInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//fetching data from product information page
		String acutalProductName= productInformationPage.getProductNameTextField();
		String actualStartDate= productInformationPage.getStartDateTextFiled();
		String actualEndDate= productInformationPage.getEndDataTextField();
		String actualEVendorName= productInformationPage.getvendorNameLink();	
		//verification and validation
		if (acutalProductName.equals(expectedProductName) && actualStartDate.equals(expectedStartDate) && actualEndDate.equals(expectedEndDate) && expectedVendorName.equals(actualEVendorName) ) {
			System.out.println("testcase pass");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 7, 7,"pass");
		}
		else
		{
			System.out.println("testcase failed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 7, 7,"fail");
		}
		//sign out application
		webdriverUtility.initializeActions();
		commonPage.mouseOverOnAdministratorImg(webdriverUtility);
		commonPage.clickOnSignoutLink();	
		//close excel
		excelUtility.closeExcel();
		//close property file
		property.closePropertyFile();
		//quit browser
		webdriverUtility.quitBrowser();
	}
}





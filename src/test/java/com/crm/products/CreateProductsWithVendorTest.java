package com.crm.products;




import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amandla.genericutility.BaseClass;
import com.amandla.genericutility.IConstantPath;
import com.amandla.genericutility.SheetName;
/**
 * it is used to test CreateProductsWithVendor module
 * @author VANNUR 
 *
 */
@Listeners(com.amandla.genericutility.ListenerImplementationClass.class)
public class CreateProductsWithVendorTest extends BaseClass {
	@Parameters("browser")
	@Test
	public  void createProductsWithVendorTest(String browser)  {
		System.out.println("createProductsWithVendorTest   "+browser+"----->"+Thread.currentThread().getId());
		String expectedStartDate=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 1);
		String expectedEndDate=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 2);
		String excepetedProductcat=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 3);
		String expectedProductName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 4);
		String expectedVendorName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 8, 5);
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
		//		Assert.assertEquals(acutalProductName, expectedProductName);
		//		Assert.assertEquals(actualStartDate, expectedStartDate);
		//		Assert.assertEquals(actualEndDate, expectedEndDate);
		//		Assert.assertEquals(expectedVendorName, actualEVendorName);
		Assert.assertTrue(acutalProductName.equals(expectedProductName) && actualStartDate.equals(expectedStartDate) && actualEndDate.equals(expectedEndDate) && expectedVendorName.equals(actualEVendorName));
		excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");

	}
}





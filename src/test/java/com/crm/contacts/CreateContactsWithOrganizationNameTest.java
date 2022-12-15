package com.crm.contacts;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.FeatureFileUtility;
import com.vtiger1.genericutility.IConstantPath;
import com.vtiger1.genericutility.PropertyFileKeys;
import com.vtiger1.genericutility.SheetName;
import com.vtiger1.genericutility.WebDriverUtility;
import com.vtiger1.objectrepository.CommonPage;
import com.vtiger1.objectrepository.ContactInformationPage;
import com.vtiger1.objectrepository.CreateContactsPage;
import com.vtiger1.objectrepository.CreatingNewContactPage;
import com.vtiger1.objectrepository.LoginPage;
/**
 * It is used to test create contacts with organization name
 * @author jay
 *
 */

public class CreateContactsWithOrganizationNameTest {
	public static void main(String[] args) throws IOException {
		//creating object of genericUtility classes
		FeatureFileUtility property=new FeatureFileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		//reading data from property file
		String username = property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.convertToString());
		String password=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.convertToString());
		String url=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//reading data from excel file
		String ExpectedFirstName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 1);
		String ExpectedLastName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 2);
		String ExpectedOrganizationName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 3);
		//launching browser and Application
		WebDriver driver=webdriverUtility.launchApplication("chrome", 10, url);
		//creating object of objectRepository classes related to Leads module
		LoginPage loginPage=new LoginPage(driver);
		CommonPage commonPage=new CommonPage(driver);
		CreateContactsPage createContactsPage=new CreateContactsPage(driver);
		CreatingNewContactPage creatingNewContactPage=new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		//login to application
		loginPage.loginAction(username, password);
		//clicking on contacts tab
		commonPage.clickContactsTab();
		//clicking on create new contacts icon
		createContactsPage.clickCreateContactsIcon();
		//filling all the details in creating new contacts page with organization name
		creatingNewContactPage.selectFirstNameDropDown(webdriverUtility,"Mr.");
		creatingNewContactPage.enterTextInFirstNameTextFiled(ExpectedFirstName);
		creatingNewContactPage.enterTextInLatNameTextFiled(ExpectedLastName);
		creatingNewContactPage.clickOnOrganizationNameLookupIcon();
		creatingNewContactPage.enterTextInOrganizationNameSearchTextBox(webdriverUtility, "\"module=Accounts\"",ExpectedOrganizationName);
		creatingNewContactPage.clickOnsearchNowButton(driver, ExpectedOrganizationName);
		webdriverUtility.handlingWindowsBasedOnUrl("module=Contacts");
		//clicking on save button
		creatingNewContactPage.clickOnSaveButton();
		webdriverUtility.waitCondition(10);
		contactInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//fetching all the details
		String actualFirstName=contactInformationPage.getFirstNameTextFiled();
		String actualLastName=contactInformationPage.getLastNameTextFiled();
		String actualOrganizationName=contactInformationPage.getOrganizationNameTextFiled();
		//verification and validation
		if (ExpectedLastName.equals(actualLastName) && ExpectedFirstName.contains(actualFirstName) && ExpectedOrganizationName.equals(actualOrganizationName)) {
			System.out.println("testcase passed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 3, 7,"pass");
		}
		else {
			System.out.println("testcase failed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 3, 7,"fail");
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

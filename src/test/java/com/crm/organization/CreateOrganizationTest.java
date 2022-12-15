package com.crm.organization;

<<<<<<< HEAD
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.FeatureFileUtility;
import com.vtiger1.genericutility.IConstantPath;
import com.vtiger1.genericutility.JavaUtility;
import com.vtiger1.genericutility.PropertyFileKeys;
import com.vtiger1.genericutility.SheetName;
import com.vtiger1.genericutility.WebDriverUtility;
import com.vtiger1.objectrepository.CommonPage;
import com.vtiger1.objectrepository.CreateOrganizationsPage;
import com.vtiger1.objectrepository.CreatingNewOrganizationPage;
import com.vtiger1.objectrepository.LoginPage;
import com.vtiger1.objectrepository.OrganizationInformationPage;
/**
 * it is used to test create organization module
 * @author jay
 *
 */
public class CreateOrganizationTest {
	public static void main(String[] args) throws IOException {
		//creating object of genericUtility classes
		FeatureFileUtility property=new FeatureFileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javautility=new JavaUtility();
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		//reading/fetching data from property file
		String username = property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.convertToString());
		String password=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.convertToString());
		String url=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//generating random number
		int randomNum=javautility.getRandomNumber(1000);  
		//reading/fetching data from excel file
		String ExpectedOrgName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 6, 1)+randomNum;
		//launching application
		WebDriver driver = webdriverUtility.launchApplication("chrome", 10, url);
		//creating object of objectRepository classes related to Organization
		LoginPage loginPage=new LoginPage(driver);
		CommonPage commonPage=new CommonPage(driver);
		CreateOrganizationsPage createOrganizationsPage=new CreateOrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		//launching application
		loginPage.loginAction(username, password);
		//clicking on organization module
		commonPage.clickOrganizationsTab();
		//clicking on create organization icon
		createOrganizationsPage.clickCreateOrganizationIcon();
		//filling details in the creating new organization page
		creatingNewOrganizationPage.enterTextInOrganizationNameTextFiled(ExpectedOrgName);
		creatingNewOrganizationPage.clickOnSaveButton();
		//waiting for status bar invisible after clicking save button
		webdriverUtility.waitCondition(10);
		organizationInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//fetching data
		String actualOrgName=organizationInformationPage.getOrganizationNameTextFiled();
		
		//Assert.assertEquals(actualOrgName, ExpectedOrgName);
		//System.out.println("pass");
		
		//verification and validation
		if (ExpectedOrgName.equals(actualOrgName)) {
			System.out.println("testcase is passed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");		
		}
		else {
			System.out.println("testcase is failed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");
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
=======
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amandla.genericutility.BaseClass;
import com.amandla.genericutility.IConstantPath;
import com.amandla.genericutility.SheetName;
import com.amandla.objectrepository.CreateOrganizationsPage;
import com.amandla.objectrepository.CreatingNewOrganizationPage;
import com.amandla.objectrepository.OrganizationInformationPage;
/**
 * this class is used test createOrganization module
 * @author VANNUR
 *
 */
@Listeners(com.amandla.genericutility.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Parameters("browser")
	@Test
	public  void createOrganizationTest(String browser) {
		System.out.println("createOrganizationTest   "+browser+"----->"+Thread.currentThread().getId());
		//reading/fetching data from excel file
		String ExpectedOrgName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 6, 1)+randomNum;

		CreateOrganizationsPage createOrganizationsPage=new CreateOrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		//clicking on organization module
		commonPage.clickOrganizationsTab();
		//clicking on create organization icon
		createOrganizationsPage.clickCreateOrganizationIcon();
		//filling details in the creating new organization page
		creatingNewOrganizationPage.enterTextInOrganizationNameTextFiled(ExpectedOrgName);
		creatingNewOrganizationPage.clickOnSaveButton();
		//waiting for status bar invisible after clicking save button
		webdriverUtility.waitCondition(10);
		organizationInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//fetching data
		String actualOrgName=organizationInformationPage.getOrganizationNameTextFiled();
		//verification and validation
		//		Assert.assertEquals(ExpectedOrgName, actualOrgName);
		Assert.assertTrue(ExpectedOrgName.equals(actualOrgName));
		excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");


>>>>>>> branch 'master' of https://github.com/vannurV/Amandla_SeleniumFramework.git
	}
}

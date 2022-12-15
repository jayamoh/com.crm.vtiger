package com.crm.leads;

<<<<<<< HEAD
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.vtiger1.genericutility.ExcelUtility;
import com.vtiger1.genericutility.FeatureFileUtility;
import com.vtiger1.genericutility.IConstantPath;
import com.vtiger1.genericutility.PropertyFileKeys;
import com.vtiger1.genericutility.SheetName;
import com.vtiger1.genericutility.WebDriverUtility;
import com.vtiger1.objectrepository.CommonPage;
import com.vtiger1.objectrepository.CreateLeadsPage;
import com.vtiger1.objectrepository.CreatingNewLeadPage;
import com.vtiger1.objectrepository.LeadInformationPage;
import com.vtiger1.objectrepository.LoginPage;
/**
 * this class is to test create leads module
 * @author jay
 *
 */
public class CreateLeadsTest  {

	public static void main(String[] args) throws IOException, InterruptedException {
		//creating object of genericUtility classes
		FeatureFileUtility property=new FeatureFileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		//reading data from property file
		String username = property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.convertToString());
		String password=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.convertToString());
		String url=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//reading data from excel file
		String ExpectedFirstName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 2, 1);
		String ExpectedLastName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 2, 2);
		String ExpectedCompanyName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 2, 3);
		//launching browser and Application
		WebDriver driver=webdriverUtility.launchApplication("chrome", 10, url);
		//creating object of objectRepository classes related to Leads module
		LoginPage loginPage=new LoginPage(driver);
		CommonPage commonPage=new CommonPage(driver);
		CreateLeadsPage createLeadsPage=new CreateLeadsPage(driver);
		CreatingNewLeadPage creatingNewLeadPage=new CreatingNewLeadPage(driver);
		LeadInformationPage leadInformationPage=new LeadInformationPage(driver);
		webdriverUtility.waitCondition(10);	
		//login to application
		loginPage.loginAction(username, password);
		//clicking on LeadsTab
		commonPage.clickLeadsTab();
		//clicking on create lead icon
		createLeadsPage.clickCreateLeadIcon();
		// filling all the details in creating new lead page
		creatingNewLeadPage.selectFirstNameDropDown(webdriverUtility,"Mr.");
		creatingNewLeadPage.enterTextInFirstNameTextFiled(ExpectedFirstName);
		creatingNewLeadPage.enterTextInLatNameTextFiled(ExpectedLastName);
		creatingNewLeadPage.enterTextInCompanyTextFiled(ExpectedCompanyName);
		creatingNewLeadPage.clickOnGroupRadioButton();
		//clicking on save button after filling details in creating new lead page
		creatingNewLeadPage.clickOnSaveButton();
		leadInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//verification and validation
		String actualFirstName=leadInformationPage.getFirstNameTextFiled();
		String actualLastName=leadInformationPage.getLastNameTextFiled();
		String actualCompanyName=leadInformationPage.getCompanyTextFiled();
		if (actualFirstName.contains(ExpectedFirstName) && actualLastName.contains(ExpectedLastName) && actualCompanyName.contains(ExpectedCompanyName) ) {
			System.out.println("testcase is passed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");
		}
		else {
			System.out.println("testcase is failed");
			excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"fail");
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
import com.amandla.objectrepository.CreateLeadsPage;
import com.amandla.objectrepository.CreatingNewLeadPage;
import com.amandla.objectrepository.LeadInformationPage;
/**
 * this class is used to test CreateLeads module
 * @author VANNUR
 *
 */
@Listeners(com.amandla.genericutility.ListenerImplementationClass.class)
public class CreateLeadsTest extends BaseClass {
	@Parameters("browser")
	@Test
	public  void createLeadsTest(String browser) {
		System.out.println("createLeadsTest   "+browser+"----->"+Thread.currentThread().getId());
		String ExpectedCompanyName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 2, 3);
		CreateLeadsPage createLeadsPage=new CreateLeadsPage(driver);
		CreatingNewLeadPage creatingNewLeadPage=new CreatingNewLeadPage(driver);
		LeadInformationPage leadInformationPage=new LeadInformationPage(driver);
		webdriverUtility.waitCondition(10);	
		//clicking on LeadsTab
		commonPage.clickLeadsTab();
		//clicking on create lead icon
		createLeadsPage.clickCreateLeadIcon();
		// filling all the details in creating new lead page
		creatingNewLeadPage.selectFirstNameDropDown(webdriverUtility,"Mr.");
		creatingNewLeadPage.enterTextInFirstNameTextFiled(ExpectedFirstName);
		creatingNewLeadPage.enterTextInLatNameTextFiled(ExpectedLastName);
		creatingNewLeadPage.enterTextInCompanyTextFiled(ExpectedCompanyName);
		creatingNewLeadPage.clickOnGroupRadioButton();
		//clicking on save button after filling details in creating new lead page
		creatingNewLeadPage.clickOnSaveButton();
		leadInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//verification and validation
		String actualFirstName=leadInformationPage.getFirstNameTextFiled();
		String actualLastName=leadInformationPage.getLastNameTextFiled();
		String actualCompanyName=leadInformationPage.getCompanyTextFiled();
		//		Assert.assertEquals(actualFirstName, ExpectedFirstName);
		//		Assert.assertEquals(actualLastName, ExpectedLastName);
		//		Assert.assertEquals(actualCompanyName, ExpectedCompanyName);
		Assert.assertTrue(actualFirstName.contains(ExpectedFirstName) && actualLastName.contains(ExpectedLastName) && actualCompanyName.contains(ExpectedCompanyName));
		excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");


>>>>>>> branch 'master' of https://github.com/vannurV/Amandla_SeleniumFramework.git
	}

}

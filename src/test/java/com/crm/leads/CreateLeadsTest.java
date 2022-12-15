package com.crm.leads;

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


	}

}

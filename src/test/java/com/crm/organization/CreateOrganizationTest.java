package com.crm.organization;

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


	}
}
